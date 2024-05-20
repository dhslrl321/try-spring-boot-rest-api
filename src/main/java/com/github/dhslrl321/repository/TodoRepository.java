package com.github.dhslrl321.repository;

import com.github.dhslrl321.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
