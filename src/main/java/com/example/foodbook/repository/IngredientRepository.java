package com.example.foodbook.repository;

import com.example.foodbook.model.Ingredient;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface IngredientRepository extends Neo4jRepository<Ingredient, UUID> {
    @Query("MATCH (i: Ingredient) RETURN i")
    List<Ingredient> getAllIngredients();

    @Query("MATCH (i: Ingredient) WHERE i.ingredientId IN $ingredientsIds RETURN i")
    Set<Ingredient> getAllIngredientsFromListWithIds(Set<String> ingredientsIds);

    @Query("MATCH (i: Ingredient)<-[:CONTAINS]-(:Meal{mealId: $mealId}) RETURN i")
    Set<Ingredient> getAllIngredientsByMealId(String mealId);
}
