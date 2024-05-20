package com.github.dhslrl321.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateTodoHttpRequest {
    private String title;
    private String description;
}
