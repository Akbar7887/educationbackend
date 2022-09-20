package uz.education.education.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.education.education.models.Subject;
import uz.education.education.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/subject/")
@RequiredArgsConstructor
public class SubjectResource {
    @Autowired
    final SubjectService subjectService;

    @GetMapping("get")
    private ResponseEntity<List<Subject>> getAll(){
        return ResponseEntity.ok().body(subjectService.getAll());
    }
}
