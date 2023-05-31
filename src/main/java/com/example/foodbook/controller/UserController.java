package com.example.foodbook.controller;

import com.example.foodbook.controller.dto.response.UserResponseDto;
import com.example.foodbook.exception.UserNotFoundException;
import com.example.foodbook.model.User;
import com.example.foodbook.repository.UserRepository;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.example.foodbook.model.security.SecurityRoles.ADMIN;
import static com.example.foodbook.model.security.SecurityRoles.USER;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/me")
    @RolesAllowed({USER, ADMIN})
    public UserResponseDto getUserInfo(Authentication authentication) {
        Optional<User> user = userRepository.findUserById(authentication.getName());
        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }
        return UserResponseDto.from(user.get());
    }
}
