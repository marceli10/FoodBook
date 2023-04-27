package com.example.foodbook.repository;

import com.example.foodbook.model.Meal;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MealRepository extends Neo4jRepository<Meal, UUID> {
    @Query("MATCH (m: Meal) RETURN m")
    List<Meal> getAllMeals();
}
