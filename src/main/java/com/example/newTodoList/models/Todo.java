package com.example.newTodoList.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
