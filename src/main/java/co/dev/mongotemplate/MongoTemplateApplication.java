package co.dev.mongotemplate;

import co.dev.mongotemplate.api.course.Category;
import co.dev.mongotemplate.api.course.CategoryRepository;
import co.dev.mongotemplate.api.course.Course;
import co.dev.mongotemplate.api.course.CourseRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class MongoTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoTemplateApplication.class, args);
    }

    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;

//    @PostConstruct
    public void init() {


        Category backEnd = Category.builder()
                .categoryName("BACK-END")
                .build();

        Category design = Category.builder()
                .categoryName("DESIGN")
                .build();

        Course ui = Course.builder()
                .name("UI/UX")
                .categoryList(List.of(design))
                .build();

        Course java = Course.builder()
                .name("Java")
                .categoryList(List.of(backEnd))
                .build();
        Course c = Course.builder()
                .name("C#")
                .categoryList(List.of(backEnd))
                .build();

        courseRepository.saveAll(List.of(ui, java, c));
        categoryRepository.saveAll(List.of(backEnd, design));
    }

}
