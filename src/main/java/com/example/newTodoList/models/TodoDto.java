package com.example.newTodoList.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TodoDto {
    private String id;
    private String task;
    private boolean isCompleted;
    private String taskOwner;
}
