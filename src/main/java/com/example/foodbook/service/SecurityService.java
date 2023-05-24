package com.example.foodbook.service;

import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    private final GoogleService googleService;
    private final UserService userService;
    private final TokenService tokenService;
    public SecurityService(GoogleService googleService, UserService userService, TokenService tokenService) {
        this.googleService = googleService;
        this.userService = userService;
        this.tokenService = tokenService;
    }

    public String signInWithGoogle(String code) {
        try {
            var googleProfileDto = googleService.getUserInfo(code);
            var user = userService.getUserFromGoogle(googleProfileDto);
            return tokenService.generateToken(user);
        } catch (Exception ignored) {
            throw new RuntimeException("Problem occurred in `sign in with google`");
        }
    }
}
