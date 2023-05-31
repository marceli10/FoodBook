package com.example.foodbook.controller.dto.request;

import org.springframework.lang.NonNull;

import java.util.Set;

public record MealDto(
        @NonNull String name,
        @NonNull Set<String> ingredientsIds
) {}
