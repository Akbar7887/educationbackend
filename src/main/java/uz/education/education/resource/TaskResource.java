package uz.education.education.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.education.education.models.Task;
import uz.education.education.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task/")
public class TaskResource {

    final TaskService taskService;

    @GetMapping("get")
    private ResponseEntity<List<Task>> getAllActive() {
        return ResponseEntity.ok().body(taskService.getAll());
    }

    @PostMapping("save")
    private ResponseEntity<Task> save(@RequestBody Task task, @RequestParam("id") String id) {
        return ResponseEntity.ok().body(taskService.save(task, id));
    }

    @PutMapping("remove")
    private ResponseEntity<Task> remove(@RequestParam("id") String id){
        return ResponseEntity.ok().body(taskService.remove(id));
    }

}
