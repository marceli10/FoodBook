package com.example.foodbook.service.dto;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

public record GoogleProfileDto(
        String email,
        String pictureUrl,
        String firstName,
        String lastName
) {
    public static GoogleProfileDto from(GoogleIdToken.Payload payload) {
        return new GoogleProfileDto(
                payload.getEmail(),
                (String) payload.get("picture"),
                (String) payload.get("given_name"),
                (String) payload.get("family_name")
        );
    }
}
