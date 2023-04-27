package com.example.foodbook.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.UUID;

@Node("Ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(GeneratedValue.UUIDGenerator.class)
    private UUID ingredientId;

    @Property("name")
    private String name;

    public Ingredient(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getIngredientId() {
        return ingredientId;
    }

    public String getName() {
        return name;
    }
}
