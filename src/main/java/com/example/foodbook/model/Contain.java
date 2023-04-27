package com.example.foodbook.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.UUID;

@RelationshipProperties
public class Contain {
    @Id
    @GeneratedValue
    private Long id;

    @TargetNode
    private Meal meal;

    public Long getContainId() {
        return id;
    }

    public Meal getMeal() {
        return meal;
    }
}
