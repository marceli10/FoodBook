package com.example.foodbook.model;

import com.example.foodbook.model.security.Provider;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.UUID;

@Node("User")
public class User {

    @Id
    @GeneratedValue(GeneratedValue.UUIDGenerator.class)
    private UUID userId;
    private String email;
    private String pictureUrl;
    private String firstName;
    private String lastName;
    private Provider provider;
    private String role;

    public User(String email, String pictureUrl, String firstName, String lastName, Provider provider, String role) {
        this.email = email;
        this.pictureUrl = pictureUrl;
        this.firstName = firstName;
        this.lastName = lastName;
        this.provider = provider;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
