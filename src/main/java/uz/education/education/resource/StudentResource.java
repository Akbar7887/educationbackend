package uz.education.education.resource;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.education.education.models.user.Student;
import uz.education.education.service.StudentService;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/student/")
@RequiredArgsConstructor
public class StudentResource {

    @Autowired
    private final StudentService studentService;

    @GetMapping("get")
    private ResponseEntity<List<Student>> getAllActive(){
        return ResponseEntity.ok().body(studentService.getAllActive());
    }

    @PostMapping("save")
    private ResponseEntity<Student> save(Student student){
        return ResponseEntity.ok().body(studentService.save(student));
    }

    @PutMapping("remove")
    private ResponseEntity<Student> remove(String id){
        return ResponseEntity.ok().body(studentService.remove(id));
    }
}
