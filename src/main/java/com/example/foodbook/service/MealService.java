package com.example.foodbook.service;

import com.example.foodbook.controller.dto.request.MealDto;
import com.example.foodbook.controller.dto.response.MealCoverageDto;
import com.example.foodbook.exception.MealNotFoundException;
import com.example.foodbook.exception.PermissionException;
import com.example.foodbook.model.Ingredient;
import com.example.foodbook.model.Meal;
import com.example.foodbook.repository.IngredientRepository;
import com.example.foodbook.repository.MealRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class MealService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MealService.class);
    private final MealRepository mealRepository;
    private final IngredientRepository ingredientRepository;

    public MealService(MealRepository mealRepository, IngredientRepository ingredientRepository) {
        this.mealRepository = mealRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<Meal> getAllMeals() {
        return mealRepository.getAllMeals();
    }

    public List<Meal> getAllMealsCreatedByUser(String userId) {
        List<Meal> mealsCreatedByUser = mealRepository.getAllMealsCreatedByUser(userId);
        mealsCreatedByUser.forEach(meal -> {
            meal.setIngredients(ingredientRepository.getAllIngredientsByMealId(meal.getMealId().toString()));
        });

        return mealsCreatedByUser;
    }

    public void createMeal(MealDto mealDto, String userId) {
        Set<Ingredient> ingredients = ingredientRepository.getAllIngredientsFromListWithIds(mealDto.ingredientsIds());
        Meal meal = new Meal(mealDto.name(), userId, ingredients);
        meal = mealRepository.save(meal);

        LOGGER.info("Created meal with id: {}", meal.getMealId());
    }

    public List<MealCoverageDto> findAllMeals(List<String> ingredientsIds) {
        List<Meal> foundMeals = mealRepository.findMealsByIngredientsId(ingredientsIds);
        foundMeals.forEach(meal -> {
            meal.setIngredients(ingredientRepository.getAllIngredientsByMealId(meal.getMealId().toString()));
        });
        return foundMeals.stream()
                .map(meal -> {
                    List<String> mealIngredientsIds = meal.getIngredients()
                            .stream()
                            .map(Ingredient::getIngredientId)
                            .map(UUID::toString)
                            .toList();

                    double coverage = ingredientsIds
                            .stream()
                            .filter(mealIngredientsIds::contains)
                            .count();
                    return new MealCoverageDto(meal, Math.min(coverage / foundMeals.size(), 1.0) * 100);
                })
                .toList();
    }

    public void deleteMeal(String mealId, String userId) {
        Optional<Meal> meal = mealRepository.findById(mealId);
        if (meal.isEmpty()) {
            throw new MealNotFoundException();
        }

        if (!meal.get().getCreator().equals(userId)) {
            throw new PermissionException();
        }

        mealRepository.deleteMealByMealId(mealId);
        LOGGER.info("Deleted meal with id: {}", mealId);
    }
}
