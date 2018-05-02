package morthth.t3c.demo.course.control;

import morthth.t3c.demo.course.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {

}
