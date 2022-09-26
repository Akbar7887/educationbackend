package uz.education.education.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.education.education.models.Level;
import uz.education.education.service.LevelService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/level/")
public class LevelResource {


    private final LevelService levelService;

    @GetMapping("getcs")
    private ResponseEntity<List<Level>> getAllActiveCourseSubject(@RequestParam("course_id") String course_id,
                                                                  @RequestParam("subject_id") String subject_id) {
        return ResponseEntity.ok().body(levelService.getAllActiveCourseSubject(course_id, subject_id));
    }

    @PostMapping("save")
    private ResponseEntity<Level> save(@RequestBody Level level) {
        return ResponseEntity.ok().body(levelService.save(level));
    }

    @PutMapping("remove")
    private ResponseEntity<Level> remove(@RequestParam("id") String id) {
        return ResponseEntity.ok().body(levelService.remove(id));
    }

}
