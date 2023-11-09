package co.dev.mongotemplate.api.course;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final MongoTemplate mongoTemplate;

    public List<Course> getCoursesByCategories(String categoryName) {

        Query query = new Query(Criteria.where("categoryList").elemMatch(Criteria.where("categoryName").is(categoryName)));

        List<Course> courseList = mongoTemplate.find(query, Course.class);

        return courseList.stream()
                .peek(course -> {
                    List<Category> filteredCategories = course.getCategoryList()
                            .stream()
                            .filter(category -> category.getCategoryName().equalsIgnoreCase(categoryName))
                            .collect(Collectors.toList());
                    course.setCategoryList(filteredCategories);
                    System.out.println(course);
                })
                .collect(Collectors.toList());
    }


}
