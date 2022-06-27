package com.example.demo;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ToDoAppServiceTest {

	@Test
	void shouldAddTask() {
		//GIVEN
		Task testTask = new Task("testid", "efef", "sf", StatusState.OPEN);
		TaskRepository testTaskRepository = Mockito.mock(TaskRepository.class);

		ToDoAppService testToDoAppService = new ToDoAppService(testTaskRepository);

		//WHEN
		testToDoAppService.addTask(testTask);

		//THEN
		Mockito.verify(testTaskRepository).addTask(testTask);
	}

	@Test
	void shouldReturnAllTasks(){
		//GIVEN
		Task testTask1 = new Task("testid1", "e111ef", "sf111", StatusState.DONE);
		Task testTask2 = new Task("testid2", "ef2dwaffef", "sfsqwf2f", StatusState.IN_PROGRESS);
		Task testTask3 = new Task("testid3", "efsdadw3ef", "sasdad3f", StatusState.OPEN);

		TaskRepository testTaskRepository = Mockito.mock(TaskRepository.class);

		ToDoAppService testToDoAppService = new ToDoAppService(testTaskRepository);

		//WHEN
		when(testTaskRepository.addedTasks()).thenReturn(List.of(testTask1,testTask2, testTask3));

		//THEN
		assertThat(testToDoAppService.addedTasks()).contains(testTask1, testTask2, testTask3);
	}
}