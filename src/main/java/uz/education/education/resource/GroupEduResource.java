package uz.education.education.resource;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.education.education.models.GroupEdu;
import uz.education.education.service.GroupEduService;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/groupedu/")
@RequiredArgsConstructor
public class GroupEduResource {

    private final GroupEduService groupEduService;

    @GetMapping("get")
    private ResponseEntity<List<GroupEdu>> getAllActive() {

        return ResponseEntity.ok().body(groupEduService.getAllActive());
    }

    @PostMapping("saveid")
    private ResponseEntity<GroupEdu> save(@RequestBody GroupEdu groupEdu,
                          @RequestParam("course_id") String id) {
        return  ResponseEntity.ok().body(groupEduService.save(groupEdu, id));
    }

    @PutMapping("remove")
    private ResponseEntity<GroupEdu> remove(@RequestParam("id") String id) {
        return ResponseEntity.ok().body(groupEduService.remove(id));
    }

}
