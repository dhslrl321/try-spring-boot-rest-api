package com.github.dhslrl321.controller;

import com.github.dhslrl321.application.TodoService;
import com.github.dhslrl321.controller.dto.CreateTodoHttpRequest;
import com.github.dhslrl321.domain.Todo;
import com.github.dhslrl321.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoRepository repository;

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> todos() {
        List<Todo> todos = repository.findAll();
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> todos(@PathVariable Long id) {
        Todo todo = repository.findById(id)
                .orElseThrow(NoSuchElementException::new);
        return ResponseEntity.ok(todo);
    }

    @PostMapping("/todos")
    public ResponseEntity<Todo> create(@RequestBody CreateTodoHttpRequest request) {
        Todo newTodo = new Todo(request.getTitle(), request.getDescription());
        Todo saved = repository.save(newTodo);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saved);
    }
}
