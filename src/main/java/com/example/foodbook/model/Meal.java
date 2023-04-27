package com.example.foodbook.model;

import org.springframework.data.neo4j.core.schema.*;

import java.util.Set;
import java.util.UUID;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

@Node("Meal")
public class Meal {

    @Id
    @GeneratedValue(GeneratedValue.UUIDGenerator.class)
    private UUID mealId;

    @Property("name")
    private String name;

    @Relationship(type = "CONTAIN", direction = INCOMING)
    private Set<Contain> ingredients;

    public Meal(String name) {
        this.name = name;
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

    public Set<Contain> getIngredients() {
        return ingredients;
    }
}
