package com.example.demo.taskManaging;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToDoAppService {
     private final TaskRepository taskRepository;

    public Task addTask(Task taskToAdd){
        return taskRepository.save(taskToAdd);
    }

    public List<Task> addedTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    public void switchStatus(Task task) {
        switch (task.getStatus()) {
            case OPEN -> task.setStatus((StatusState.IN_PROGRESS));
            case IN_PROGRESS -> task.setStatus((StatusState.DONE));
        }
        taskRepository.save(task);
    }

    public void switchStatusBackwards(Task task) {
        switch (task.getStatus()) {
            case IN_PROGRESS -> task.setStatus((StatusState.OPEN));
            case DONE -> task.setStatus((StatusState.IN_PROGRESS));
        }
        taskRepository.save(task);
    }

    public Optional<Task> getItemById(String id) {
        return taskRepository.findById(id);
    }

    public void editTask(Task task) {
        taskRepository.save(task);
    }
}
