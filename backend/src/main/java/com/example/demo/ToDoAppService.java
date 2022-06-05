package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoAppService {
    TaskRepository taskRepository = new TaskRepository();

    public Task addTask(Task taskToAdd){
        return taskRepository.addTask(taskToAdd);
    }

    public List<Task> addedTasks() {
        return taskRepository.addedTasks();
    }

    public void deleteTask(String id) {
        taskRepository.deleteTask(id);
    }

    public void switchStatus(Task task) {
        taskRepository.switchStatus(task);
    }

    public void switchStatusBackwards(Task task) {
        taskRepository.switchStatusBackwards(task);
    }

    public Task getItemById(String id) {
        return taskRepository.getItemById(id);
    }

    public void editTask(Task task) {
        taskRepository.editTask(task);
    }
}
