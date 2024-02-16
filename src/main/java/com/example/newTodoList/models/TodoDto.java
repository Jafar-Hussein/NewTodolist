package com.example.newTodoList.models;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * @Author Jafar Hussein
 * this class is a dto for the todo list
 * it has variables for the id, task, isCompleted and taskOwner
 * it has annotations for constructors and getters and setters
 * this class is used to transfer data between the service and the controller and vice versa
 * */
@Data
@AllArgsConstructor
public class TodoDto {
    private String id;
    private String task;
    private boolean isCompleted;
    private String taskOwner;
}
