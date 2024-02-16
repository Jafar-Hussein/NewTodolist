package com.example.newTodoList.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @Author Jafar Hussein
 * this class is the model for the todo list
 * it has variables for the id, task, isCompleted and taskOwner
 * it annotations that are used for constructors, getters and setters and the document for the database
 * */
@Document(collection = "todos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Todo {
    @Id
    private String id;
    private String task;
    private boolean isCompleted;
   private String taskOwner;


}
