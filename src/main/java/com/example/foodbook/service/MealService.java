package com.example.foodbook.service;

import com.example.foodbook.model.Meal;
import com.example.foodbook.repository.IngredientRepository;
import com.example.foodbook.repository.MealRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    private final MealRepository mealRepository;
    private final IngredientRepository ingredientRepository;

    public MealService(MealRepository mealRepository, IngredientRepository ingredientRepository) {
        this.mealRepository = mealRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<Meal> getAllMeals() {
        return mealRepository.getAllMeals();
    }
}
