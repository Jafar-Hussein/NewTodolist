package com.example.newTodoList.controller;

import com.example.newTodoList.models.TodoDto;
import com.example.newTodoList.models.Todo;
import com.example.newTodoList.services.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * @Author Jafar Hussein
 * this class is the controller for the todo list
 * it has the following methods:
 * 1. startPage() - starting page
 * 2. createTodo() - add a new todo
 * 3. getTodos() - get all todos
 * 4. getById() - get a todo by id
 * 5. updateTodo() - update a todo
 * 6. deleteById() - delete a todo
 * 7. clearAll() - clear all todos
 * */

@RestController
@RequestMapping("/todo")
@CrossOrigin("*")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    /**
     * starting page
     * @Method startPage()
     * @return ResponseEntity<String>
     * this method returns a welcome message to the user when the user starts the application
     * */
    @GetMapping("")
    public ResponseEntity<String> startPage() {
        return ResponseEntity.ok("Welcome to the Todo List");
    }

    /**
     * add a new todo
     * @URL localhost:5000/todo/add
     * @Method createTodo()
     * @param todo - TodoDto
     * @Return ResponseEntity<Todo>
     * @if the task or the task owner is empty, it returns a bad request
     *  this method takes a TodoDto object and adds it to the todo list
     * */
    @PostMapping("/add")
    public ResponseEntity<Todo> createTodo(@RequestBody TodoDto todo) {
        if (todo.getTask().isEmpty() || todo.getTaskOwner().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(todoService.createTodo(todo));
    }

    /**
     * get all todos
     * @URL localhost:5000/todo/todos
     * @Method getTodos()
     * @Return ResponseEntity<?>
     * this method returns all the todos in the todo list
     * */
    @GetMapping("/todos")
    public ResponseEntity<?> getTodos() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    /**
     * get a todo by id
     * @URL localhost:5000/todo/getById/{id}
     * @Method getById()
     * @param id - String
     * @Return ResponseEntity<?>
     * this method returns a todo by its id from the todo list
     * */
    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        return ResponseEntity.ok(todoService.getById(id));
    }

    /**
     * update a todo
     * @URL localhost:5000/todo/update/{id}
     * @Method updateTodo()
     * @param id - String
     * @param updatedTodo - Todo
     * @Return ResponseEntity<?>
     * this method updates a todo by its id and returns the updated todo
     * */
    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable String id, @RequestBody Todo updatedTodo) {
        return ResponseEntity.ok(todoService.updateTodo(id, updatedTodo));
    }

    /**
     * delete a todo
     * @URL localhost:5000/todo/delete/{id}
     * @Method deleteById()
     * @param id - String
     * @Return ResponseEntity<?>
     * this method deletes a todo by its id and returns a message
     * */

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        todoService.deleteById(id);
        return ResponseEntity.ok("Todo deleted");
    }

    /**
     * clear all todos
     * @URL localhost:5000/todo/clearAll
     * @Method clearAll()
     * @Return ResponseEntity<?>
     * this method deletes all the todos in the todo list and returns a message
     * */
    @DeleteMapping("/clearAll")
    public ResponseEntity<?> clearAll() {
        todoService.clearAll();
        return ResponseEntity.ok("All todos deleted");
    }
}
