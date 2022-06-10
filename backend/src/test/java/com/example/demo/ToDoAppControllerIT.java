package com.example.demo;


import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToDoAppControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;

/*	@Test
	void shouldTestWholeApp() {
		//GIVEN
		Task task1 = new Task("new", "blabla", StatusState.OPEN);
		testRestTemplate.postForEntity("/api/kanban", task1, Void.class);
		ResponseEntity<>;

		//THEN

	}*/
	@Test
	void integrationsTest(){
		ResponseEntity<Task[]> emptyResponse = restTemplate.getForEntity("/api/react", Task[].class);
		Assertions.assertThat(emptyResponse.getBody()).isEmpty();
	}

}
