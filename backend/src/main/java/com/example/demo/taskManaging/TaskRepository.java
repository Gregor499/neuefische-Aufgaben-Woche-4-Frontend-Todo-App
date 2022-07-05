package com.example.demo.taskManaging;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
//@RequiredArgsConstructor

public interface TaskRepository extends MongoRepository<Task, String> {}

/*public class TaskRepository {
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
}*/
