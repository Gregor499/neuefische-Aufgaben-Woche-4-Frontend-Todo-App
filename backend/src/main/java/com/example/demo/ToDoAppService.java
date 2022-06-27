package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        taskRepository.switchStatus(task);
    }

    public void switchStatusBackwards(Task task) {
        taskRepository.switchStatusBackwards(task);
    }

    public Task getItemById(String id) {
        return taskRepository.findById(id);
    }

    public void editTask(Task task) {
        taskRepository.save(task);
    }
}
