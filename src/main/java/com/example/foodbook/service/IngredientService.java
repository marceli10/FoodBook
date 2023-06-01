package com.example.foodbook.service;

import com.example.foodbook.controller.dto.request.IngredientDto;
import com.example.foodbook.model.Ingredient;
import com.example.foodbook.repository.IngredientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(IngredientService.class);

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.getAllIngredients();
    }

    public Ingredient createIngredient(IngredientDto ingredientDto) {
        var ingredient = ingredientRepository.save(new Ingredient(ingredientDto.name()));
        LOGGER.info("Created: {} ingredient with id: {} ", ingredient.getName(), ingredient.getIngredientId());
        return ingredient;
    }

    public void deleteIngredient(UUID ingredientId) {
        ingredientRepository.deleteById(ingredientId);
        LOGGER.info("Deleted ingredient with id: {}", ingredientId);
    }
}
