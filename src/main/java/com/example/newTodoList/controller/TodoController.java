package com.example.newTodoList.controller;

import com.example.newTodoList.models.TodoDto;
import com.example.newTodoList.models.Todo;
import com.example.newTodoList.services.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // add a new todo
    @PostMapping("/add")
    public ResponseEntity<Todo> createTodo(@RequestBody TodoDto todo) {
        if (todo.getTask().isEmpty() || todo.getTaskOwner().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(todoService.createTodo(todo));
    }

    // get all todos
    @GetMapping("/todos")
    public ResponseEntity<?> getTodos() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    // get a todo by id
    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        return ResponseEntity.ok(todoService.getById(id));
    }

    // update a todo
    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable String id, @RequestBody Todo updatedTodo) {
        return ResponseEntity.ok(todoService.updateTodo(id, updatedTodo));
    }

    // delete a todo

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        todoService.deleteById(id);
        return ResponseEntity.ok("Todo deleted");
    }

    // clear all todos
    @DeleteMapping("/clearAll")
    public ResponseEntity<?> clearAll() {
        todoService.clearAll();
        return ResponseEntity.ok("All todos deleted");
    }
}
