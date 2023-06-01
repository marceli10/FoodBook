package com.example.foodbook.controller;

import com.example.foodbook.controller.dto.request.IngredientDto;
import com.example.foodbook.model.Ingredient;
import com.example.foodbook.service.IngredientService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.example.foodbook.model.security.SecurityRoles.ADMIN;
import static com.example.foodbook.model.security.SecurityRoles.USER;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/all")
    @RolesAllowed({USER, ADMIN})
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @PostMapping
    @RolesAllowed(ADMIN)
    public Ingredient createIngredient(@RequestBody IngredientDto ingredientDto) {
        return ingredientService.createIngredient(ingredientDto);
    }

    @PostMapping
    @RolesAllowed(ADMIN)
    public void deleteIngredient(@RequestBody UUID ingredientId) {
        ingredientService.deleteIngredient(ingredientId);
    }
}
