package com.example.foodbook.controller;

import com.example.foodbook.controller.dto.request.MealDto;
import com.example.foodbook.controller.dto.response.MealCoverageDto;
import com.example.foodbook.model.Meal;
import com.example.foodbook.service.MealService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PostMapping
    @RolesAllowed({USER, ADMIN})
    public void createMeal(@RequestBody MealDto mealDto, Authentication authentication) {
        mealService.createMeal(mealDto, authentication.getName());
    }

    @GetMapping("/all/my")
    @RolesAllowed({USER, ADMIN})
    public List<Meal> getAllMyMeals(Authentication authentication) {
        return mealService.getAllMealsCreatedByUser(authentication.getName());
    }

    @GetMapping("/find")
    @RolesAllowed({USER, ADMIN})
    public List<MealCoverageDto> findRecipes(@RequestBody List<String> ingredientsIds) {
        return mealService.findAllMeals(ingredientsIds);
    }

    @DeleteMapping
    @RolesAllowed({USER, ADMIN})
    public void deleteRecipe(@RequestBody String mealId, Authentication authentication) {
        mealService.deleteMeal(mealId, authentication.getName());
    }
}
