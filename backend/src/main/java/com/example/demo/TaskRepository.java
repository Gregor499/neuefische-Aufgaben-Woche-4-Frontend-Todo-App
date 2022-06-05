package com.example.demo;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Repository
@RequiredArgsConstructor

public class TaskRepository {
	HashMap<String, Task> allMyTasks = new HashMap<>();

	public Task addTask(Task newTask) {
		allMyTasks.put(newTask.getId(), newTask);
		return newTask;
	}

	public List<Task> addedTasks() {
		return allMyTasks.values().stream().toList();
	}

	public void deleteTask(String id) {
		allMyTasks.remove(id);
	}

	public void switchStatus(Task task) {
		switch (task.getStatus()) {
			case OPEN -> task.setStatus((StatusState.IN_PROGRESS));
			case IN_PROGRESS -> task.setStatus((StatusState.DONE));
		}
		allMyTasks.put(task.getId(), task);
	}

	public void switchStatusBackwards(Task task) {
		switch (task.getStatus()) {
			case IN_PROGRESS -> task.setStatus((StatusState.OPEN));
			case DONE -> task.setStatus((StatusState.IN_PROGRESS));
		}
		allMyTasks.put(task.getId(), task);
	}

	public Task getItemById(String id) {
		return allMyTasks.get(id);
	}

	public void editTask(Task task) {
		allMyTasks.put(task.getId(), task);
	}
}
