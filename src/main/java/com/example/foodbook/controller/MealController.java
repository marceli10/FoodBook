package com.example.foodbook.controller;

import com.example.foodbook.model.Meal;
import com.example.foodbook.service.MealService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.foodbook.model.security.SecurityRoles.ADMIN;
import static com.example.foodbook.model.security.SecurityRoles.USER;

@RestController
@RequestMapping("/api/meals")
public class MealController {
    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/all")
    @RolesAllowed({USER, ADMIN})
    public List<Meal> getAllMeals() {
        return mealService.getAllMeals();
    }

}
