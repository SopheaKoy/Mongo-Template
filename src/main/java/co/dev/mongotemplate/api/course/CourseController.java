package co.dev.mongotemplate.api.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseService courseService, CourseRepository courseRepository) {
        this.courseService = courseService;
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public List<Course> findAll(){
        return courseRepository.findAll();
    }


    @GetMapping("/byCategory/{categoryName}")
    public List<Course> getCoursesByCategory(@PathVariable String categoryName) {

        System.out.println(courseService.getCoursesByCategories(categoryName));

        return courseService.getCoursesByCategories(categoryName);
    }
}
