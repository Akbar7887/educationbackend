package uz.education.education.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.education.education.models.Active;
import uz.education.education.models.Student;
import uz.education.education.repository.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {

    @Autowired
    final StudentRepo studentRepo;

    public List<Student> getAllActive() {
        return studentRepo.findAll(Active.ACTIVE);
    }

    public Student save(Student student) {
        return studentRepo.save(student);
    }

    public Student remove(String id) {
        Optional<Student> studentOptional = studentRepo.findById(Long.parseLong(id));
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setActive(Active.NOACTIVE);
            return student;
        } else {
            return null;
        }

    }
}
