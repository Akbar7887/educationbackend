package uz.education.education.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.education.education.models.Course;
import uz.education.education.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/course/")
@RequiredArgsConstructor
public class CourseResource {

    private final CourseService courseService;

    @GetMapping("get")
    public ResponseEntity<List<Course>> getAll(){

        return ResponseEntity.ok().body(courseService.getAll());
    }

    @PostMapping("save")
    public ResponseEntity<Course> save(@RequestBody  Course course){
        return  ResponseEntity.ok().body(courseService.save(course));
    }

}
