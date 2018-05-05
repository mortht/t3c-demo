package morthth.t3c.demo.courseDir;

import morthth.t3c.demo.course.control.CourseRepository;
import morthth.t3c.demo.course.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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
        Course savedCourse = courseRepository.save(course);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/").path(savedCourse.getId().toString())
                .build().toUri();

        //TODO check existence
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @RequestMapping(path = "{courseId}")
    Course getCourse(@PathVariable Integer courseId) {
        return courseRepository.findById(courseId).get();
    }


}
