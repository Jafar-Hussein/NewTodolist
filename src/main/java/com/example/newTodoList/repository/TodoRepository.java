package com.example.newTodoList.repository;

import com.example.newTodoList.models.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/**
 * @Author Jafar Hussein
 * this interface is the repository for the todo list
 * it extends the MongoRepository and has the Todo and String as the type and the id type
 * it is used to interact with the database
 * */
@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
}
