package morthth.t3c.demo.course;

import morthth.t3c.demo.employee.Employee;
import morthth.t3c.demo.employee.EmployeeService;
import morthth.t3c.demo.rest.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(path = "/course")
public class CourseResource {

    private final CourseRepository courseRepository;
    private final EmployeeService employeeService;

    @Autowired
    public CourseResource(CourseRepository courseRepository, EmployeeService employeeService) {
        this.courseRepository = courseRepository;
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> createCourse(@Valid @RequestBody Course course) {
        Employee lecturer = employeeService.findEmployeeById(course.getLecturerId())
                .filter(employee -> employee.getRoles().contains("LECTURER"))
                .orElseThrow(() -> new InvalidInputException("Invalid lecturer ID: " + course.getLecturerId()));
        course.setLecturerFullName(lecturer.getTitle() + " " + lecturer.getFirstName() + " " + lecturer.getSurName());

        Course savedCourse = courseRepository.save(course);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{courseId}")
                .buildAndExpand(savedCourse.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @RequestMapping(path = "{courseId}")
    ResponseEntity<Course> getCourse(@PathVariable Integer courseId) {
        return courseRepository.findById(courseId)
                .map(course -> ResponseEntity.ok(course))
                .orElse(ResponseEntity.notFound().build());
    }


}
