package com.example.newTodoList.services;

import com.example.newTodoList.models.Todo;
import com.example.newTodoList.models.TodoDto;

import com.example.newTodoList.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @Author Jafar Hussein
 * this class is the service for the todo list
 * it has a constructor that takes in the todo repository
 * it has methods to create a todo, get all todos, get a todo by id, update a todo, delete a todo and clear all todos
 * it is used to interact with the repository and the controller
 * */

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // create a todo
    public Todo createTodo(TodoDto todo) {
        // if the task is empty, return null
        if (todo.getTask() == null) {
            return null;
        }
        // if not null, create a new todo and save it
        Todo newTodo = new Todo(todo.getId(), todo.getTask(), todo.isCompleted(), todo.getTaskOwner());
        return todoRepository.save(newTodo);
    }

    // get all todos
    public List<Todo> getAllTodos() {
        // if there are no todos, return null
        if (todoRepository.findAll().isEmpty()) {
            return null;
        }
        // otherwise, return all todos
        return todoRepository.findAll();
    }

    // get a todo by id
    public Todo getById(String id) {
        // if the specific task does not exist, return null
        if (todoRepository.findById(id).isEmpty()) {
            return null;
        }
        // otherwise, return the specific task
        return todoRepository.findById(id).orElse(null);
    }

    // update a todo
   public Todo updateTodo(String id, Todo updatedTodo) {
        // if the specific task does not exist, return null
        Todo todoToUpdate = todoRepository.findById(id).orElse(null);
        // if the specific task exists, update the task
        if (todoToUpdate != null) {
            // set the updated task
            todoToUpdate.setId(updatedTodo.getId());
            todoToUpdate.setTask(updatedTodo.getTask());
            todoToUpdate.setTaskOwner(updatedTodo.getTaskOwner());
            todoToUpdate.setCompleted(updatedTodo.isCompleted());
            // save the updated task
            return todoRepository.save(todoToUpdate);
        }
        return null;
    }

    // delete a todo
    public void deleteById(String id) {
        todoRepository.deleteById(id);
    }

    // clear all todos
    public void clearAll() {
        todoRepository.deleteAll();
    }
}
