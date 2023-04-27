package com.example.foodbook.service;

import com.example.foodbook.controller.dto.request.IngredientDto;
import com.example.foodbook.model.Ingredient;
import com.example.foodbook.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.getAllIngredients();
    }

    public Ingredient createIngredient(IngredientDto ingredientDto) {
        return ingredientRepository.save(new Ingredient(ingredientDto.name()));
    }
}
