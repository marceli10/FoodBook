package com.example.foodbook.service;

import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    public final GoogleService googleService;

    public SecurityService(GoogleService googleService) {
        this.googleService = googleService;
    }

    public String signInWithGoogle(String code) {
        try {
            var token = googleService.getAccessTokenFromAuthCode(code);
            var idToken = googleService.verifyAccessToken(token);
            return idToken.getPayload().getEmail();
        } catch (Exception ignored) {
            throw new RuntimeException("Problem occurred in `sign in with google`");
        }
    }
}
