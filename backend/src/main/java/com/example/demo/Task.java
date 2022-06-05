package com.example.demo;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Data
public class Task {
    private final String id = UUID.randomUUID().toString();
    private String task;
    private String description;
    private StatusState status;
}
