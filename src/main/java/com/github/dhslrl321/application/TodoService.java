package com.github.dhslrl321.application;

import com.github.dhslrl321.domain.Todo;
import com.github.dhslrl321.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public List<Todo> findAll() {
        return repository.findAll();
    }

    public Todo createNew(String title, String description) {
        Todo newTodo = new Todo(title, description);
        return repository.save(newTodo);
    }
}
