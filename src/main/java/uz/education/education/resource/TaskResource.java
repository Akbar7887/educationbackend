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

    @GetMapping("getbylevel")
    private ResponseEntity<List<Task>> getbylevel(@RequestParam("id") String id) {
        return ResponseEntity.ok().body(taskService.getByLevel(id));
    }

    @PostMapping("save")
    private ResponseEntity<Task> save(@RequestBody Task task, @RequestParam("id") String id) {
        return ResponseEntity.ok().body(taskService.save(task, id));
    }

    @PutMapping("remove")
    private ResponseEntity<Task> remove(@RequestParam("id") String id) {
        return ResponseEntity.ok().body(taskService.remove(id));
    }

    @GetMapping("get/show")
    private ResponseEntity<List<Task>> getActoveShow(@RequestParam("show") boolean show) {
        return ResponseEntity.ok().body(taskService.getActiveShow(show));
    }

    @PutMapping("save/show")
    private ResponseEntity<Boolean> saveShow(@RequestParam(value = "id") String id, @RequestParam("show") Boolean show){

        return ResponseEntity.ok().body(taskService.saveShow(id, show));
    }

}
