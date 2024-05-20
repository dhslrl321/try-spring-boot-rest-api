package com.github.dhslrl321.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor // Jpa 사용시 entity 에는 기본 생성자(noArgsConstructor) 가 default
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String description;
    @Enumerated(EnumType.STRING)
    TodoStatus status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    /**
     * TODO 생성
     * id 는 null 이어야 jpa 에서 insert query 를 통해 신규 엔티티 생성
     */
    public Todo(String title, String description) {
        this.title = title;
        this.description = description;

        this.status = TodoStatus.TODO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
