package com.example.foodbook.repository;

import com.example.foodbook.model.Meal;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MealRepository extends Neo4jRepository<Meal, UUID> {
    @Query("MATCH (m: Meal) RETURN m")
    List<Meal> getAllMeals();

    @Query("MATCH (m: Meal {creator: $userId}) RETURN m")
    List<Meal> getAllMealsCreatedByUser(String userId);

    @Query("MATCH (m: Meal)-[:CONTAINS]->(i: Ingredient) WHERE i.ingredientId IN $ingredientsIds RETURN m")
    List<Meal> findMealsByIngredientsId(List<String> ingredientsIds);

    @Query("OPTIONAL MATCH (m: Meal {mealId: $mealId}) RETURN m")
    Optional<Meal> findById(String mealId);

    @Query("MATCH (m: Meal {mealId: $mealId}) DELETE m")
    void deleteMealByMealId(String mealId);
}
