package uz.education.education.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.education.education.models.*;
import uz.education.education.repository.LevelRepo;
import uz.education.education.repository.TaskRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskService {

    final TaskRepo taskRepo;
    final LevelRepo levelRepo;

    public List<Task> getAll() {
        return taskRepo.getAllActive(Active.ACTIVE);
    }

    public List<Task> getByLevel(String id) {
        return taskRepo.findByLevelId(Long.parseLong(id), Active.ACTIVE);
    }

    public Task save(Task task, String levelid) {
        Optional<Level> levelOptional = levelRepo.findById(Long.parseLong(levelid));

        if (levelOptional.isPresent()) {
            Level level = levelOptional.get();
            task.setLevel(levelOptional.get());
            Task task1 = taskRepo.save(task);
            level.addTask(task1);
            levelRepo.save(level);
            return task1;
        } else {
            return null;
        }
    }

    public Task remove(String id) {
        Optional<Task> taskOptional = taskRepo.findById(Long.parseLong(id));
        if (!taskOptional.isPresent()) {
            return null;
        }
        Task task = taskOptional.get();
        task.setActive(Active.NOACTIVE);
        return taskRepo.save(task);
    }

    public List<Task> getActiveShow(boolean show) {
        return taskRepo.findActiveShow(Active.ACTIVE, show);
    }

    public Boolean saveShow(String id, boolean show) {
            Optional<Task> taskOptional = taskRepo.findById(Long.parseLong(id));
            if (taskOptional.isEmpty()) {
               return false;
            }
            Task task = taskOptional.get();
            task.setShow(show);
            taskRepo.save(task);
        return true;
    }
}
