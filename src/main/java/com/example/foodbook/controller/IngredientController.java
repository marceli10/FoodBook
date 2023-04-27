package com.example.foodbook.controller;

import com.example.foodbook.controller.dto.request.IngredientDto;
import com.example.foodbook.model.Ingredient;
import com.example.foodbook.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/all")
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @PostMapping
    public Ingredient createIngredient(@RequestBody IngredientDto ingredientDto) {
        return ingredientService.createIngredient(ingredientDto);
    }
}
