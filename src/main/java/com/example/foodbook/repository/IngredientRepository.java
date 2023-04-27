package com.example.foodbook.repository;

import com.example.foodbook.model.Ingredient;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IngredientRepository extends Neo4jRepository<Ingredient, UUID> {
    @Query("MATCH (i: Ingredient) RETURN i")
    List<Ingredient> getAllIngredients();
}
