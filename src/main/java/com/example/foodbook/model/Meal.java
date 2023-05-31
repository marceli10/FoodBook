package com.example.foodbook.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;
import java.util.UUID;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.OUTGOING;

@Node("Meal")
public class Meal {

    @Id
    @GeneratedValue(GeneratedValue.UUIDGenerator.class)
    private UUID mealId;

    private String name;
    private String creator;

    @Relationship(type = "CONTAINS", direction = OUTGOING)
    private Set<Ingredient> ingredients;

    public Meal(String name, String creator, Set<Ingredient> ingredients) {
        this.name = name;
        this.creator = creator;
        this.ingredients = ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public UUID getMealId() {
        return mealId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }
}
