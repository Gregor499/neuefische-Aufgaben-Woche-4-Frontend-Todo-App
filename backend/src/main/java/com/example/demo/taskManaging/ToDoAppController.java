package com.example.demo.taskManaging;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/react")
@RequiredArgsConstructor

public class ToDoAppController {

	private final ToDoAppService toDoAppService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Task addTask(@RequestBody Task task) {
		return toDoAppService.addTask(task);
	}

	@GetMapping
	public List<Task> listTasks() {
		return toDoAppService.addedTasks();
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable String id) {
		toDoAppService.deleteTask(id);
	}

	@PutMapping("/next")
	@ResponseStatus(HttpStatus.IM_USED)
	public void nextStatus(@RequestBody Task task) {
		toDoAppService.switchStatus(task);
	}

	@PutMapping("prev")
	@ResponseStatus(HttpStatus.IM_USED)
	public void previousStatus(@RequestBody Task task) {
		toDoAppService.switchStatusBackwards(task);
	}

	@GetMapping("/{id}")
	public Task getTaskToEdit(@PathVariable String id) {
		return toDoAppService.getItemById(id).get();
	}

	@PutMapping
	public void newContent(@RequestBody Task task){
		toDoAppService.editTask(task);
	}
}