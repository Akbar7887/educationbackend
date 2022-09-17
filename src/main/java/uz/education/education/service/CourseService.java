package uz.education.education.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.education.education.models.Course;
import uz.education.education.repository.CourseRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CourseService {

    final CourseRepo courseRepo;

    public Course save(Course course) {
        return courseRepo.save(course);
    }

    public List<Course> getAll() {
        return courseRepo.findAll();
    }
}
