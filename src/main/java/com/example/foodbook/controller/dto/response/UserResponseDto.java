package com.example.foodbook.controller.dto.response;

import com.example.foodbook.model.User;

public record UserResponseDto(
        String email,
        String pictureUrl,
        String firstName,
        String lastName,
        String role
) {

    public static UserResponseDto from(User user) {
        return new UserResponseDto(
                user.getEmail(),
                user.getPictureUrl(),
                user.getFirstName(),
                user.getLastName(),
                user.getRole()
            );
    }
}
