package com.example.newTodoList.services;

import com.example.newTodoList.models.Todo;
import com.example.newTodoList.models.TodoDto;

import com.example.newTodoList.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // create a todo
    public Todo createTodo(TodoDto todo) {
        if (todo.getTask() == null) {
            return null;
        }
        Todo newTodo = new Todo(todo.getId(), todo.getTask(), todo.isCompleted(), todo.getTaskOwner());
        return todoRepository.save(newTodo);
    }

    // get all todos
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // get a todo by id
    public Todo getById(String id) {
        return todoRepository.findById(id).orElse(null);
    }

    // update a todo
   public Todo updateTodo(String id, Todo updatedTodo) {
        Todo todoToUpdate = todoRepository.findById(id).orElse(null);
        if (todoToUpdate != null) {
            // Update Todo
            todoToUpdate.setId(updatedTodo.getId());
            todoToUpdate.setTask(updatedTodo.getTask());
            todoToUpdate.setTaskOwner(updatedTodo.getTaskOwner());
            todoToUpdate.setCompleted(updatedTodo.isCompleted());
            // Save updated Todo
            return todoRepository.save(todoToUpdate);
        }
        return null;
    }

    // delete a todo
    public void deleteById(String id) {
        todoRepository.deleteById(id);
    }

    // clear all todos
    public void clearAll() { // denna metoden ska ta bort alla todos när användaren blir klar
        todoRepository.deleteAll();
    }
}
