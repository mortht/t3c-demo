package morthth.t3c.demo.course.boundary;

import morthth.t3c.demo.course.control.CourseRepository;
import morthth.t3c.demo.course.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/course")
public class CourseResource {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseResource(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> createCourse(@RequestBody Course course) {
        //TODO crete courses
        return ResponseEntity.noContent().build();
    }

    Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @RequestMapping(path = "{courseId}")
    Course getCourse(@PathVariable Integer courseId) {
        return courseRepository.findById(courseId).get();
    }


}
