package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToDoAppControllerIT {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void shouldTestWholeApp() {
		//GIVEN
		Task task1 = new Task("new", "blabla", StatusState.OPEN);
		testRestTemplate.postForEntity("/api/kanban", task1, Void.class);
		ResponseEntity<>re

		//THEN

	}

}
