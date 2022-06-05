package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private final String id = UUID.randomUUID().toString();
    private String task;
    private String description;
    private StatusState status;
}
