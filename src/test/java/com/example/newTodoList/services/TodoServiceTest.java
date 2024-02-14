package com.example.newTodoList.services;

import com.example.newTodoList.models.Todo;
import com.example.newTodoList.models.TodoDto;
import com.example.newTodoList.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TodoServiceTest {
    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createTodo_ValidTodoDto_ReturnsCreatedTodo() {
        TodoDto todoDto = new TodoDto("1","clean", false, "Owner");
        Todo expectedTodo = new Todo("1", "Task", false, "Owner");
        when(todoRepository.save(any(Todo.class))).thenReturn(expectedTodo);

        Todo createdTodo = todoService.createTodo(todoDto);

        assertNotNull(createdTodo);
        assertEquals(expectedTodo, createdTodo);
    }

    @Test
    void createTodo_NullTask_ReturnsNull() {
        TodoDto todoDto = new TodoDto("1","clean", false, "Owner");

        Todo createdTodo = todoService.createTodo(todoDto);

        assertNull(createdTodo);
    }

    @Test
    void getAllTodos_ReturnsListOfTodos() {
        List<Todo> expectedTodos = Arrays.asList(
                new Todo("1", "Task1", false, "Owner1"),
                new Todo("2", "Task2", true, "Owner2")
        );
        when(todoRepository.findAll()).thenReturn(expectedTodos);

        List<Todo> todos = todoService.getAllTodos();

        assertEquals(expectedTodos.size(), todos.size());
        assertEquals(expectedTodos, todos);
    }

    @Test
    void getById_ExistingId_ReturnsTodo() {
        Todo expectedTodo = new Todo("1", "Task", false, "Owner");
        when(todoRepository.findById("1")).thenReturn(Optional.of(expectedTodo));

        Todo todo = todoService.getById("1");

        assertNotNull(todo);
        assertEquals(expectedTodo, todo);
    }

    @Test
    void getById_NonExistingId_ReturnsNull() {
        when(todoRepository.findById("1")).thenReturn(Optional.empty());

        Todo todo = todoService.getById("1");

        assertNull(todo);
    }

    @Test
    void updateTodo_ValidIdAndTodo_ReturnsUpdatedTodo() {
        Todo existingTodo = new Todo("1", "Task1", false, "Owner1");
        Todo updatedTodo = new Todo("1", "Updated Task", true, "Owner2");
        when(todoRepository.findById("1")).thenReturn(Optional.of(existingTodo));
        when(todoRepository.save(any(Todo.class))).thenReturn(updatedTodo);

        Todo resultTodo = todoService.updateTodo("1", updatedTodo);

        assertNotNull(resultTodo);
        assertEquals(updatedTodo, resultTodo);
        assertEquals("Updated Task", resultTodo.getTask());
        assertTrue(resultTodo.isCompleted());
        assertEquals("Owner2", resultTodo.getTaskOwner());
    }

    @Test
    void updateTodo_NonExistingId_ReturnsNull() {
        when(todoRepository.findById("1")).thenReturn(Optional.empty());

        Todo resultTodo = todoService.updateTodo("1", new Todo());

        assertNull(resultTodo);
    }

    @Test
    void deleteById_ExistingId_DeletesTodo() {
        doNothing().when(todoRepository).deleteById("1");

        todoService.deleteById("1");

        verify(todoRepository, times(1)).deleteById("1");
    }

    @Test
    void clearAll_ClearsAllTodos() {
        doNothing().when(todoRepository).deleteAll();

        todoService.clearAll();

        verify(todoRepository, times(1)).deleteAll();
    }
}