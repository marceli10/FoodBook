package com.example.foodbook.controller;

import com.example.foodbook.model.Meal;
import com.example.foodbook.service.MealService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/meal")
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/all")
    public List<Meal> getAllMeals() {
        return mealService.getAllMeals();
    }
}
