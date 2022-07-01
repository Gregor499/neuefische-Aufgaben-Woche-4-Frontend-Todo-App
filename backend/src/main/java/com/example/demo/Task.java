package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Repository;

@Data
@NoArgsConstructor
public class Task {

    @Id
    private String id;
    private String task;
    private String description;
    private StatusState status;

    public Task(String id, String task, String description, StatusState status) {
        this.id = id;
        this.task = task;
        this.description = description;
        this.status = status;
    }
}
