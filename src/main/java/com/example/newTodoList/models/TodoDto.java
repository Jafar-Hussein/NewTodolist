package com.example.newTodoList.models;

import lombok.Data;

@Data
public class TodoDto {
    private String id;
    private String task;
    private boolean isCompleted;
    private String taskOwner;
}
