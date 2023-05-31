package com.example.foodbook.controller.dto.response;

import com.example.foodbook.model.Meal;

public record MealCoverageDto(
        Meal meal,
        Double coverage
) {
}
