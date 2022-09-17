package uz.education.education.repository;

import org.springframework.data.repository.CrudRepository;
import uz.education.education.models.Course;

import java.util.List;

public interface CourseRepo extends CrudRepository<Course, Long> {

    List<Course> findAll();
}
