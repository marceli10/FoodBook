package com.example.foodbook.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Service
public class GoogleService {
    private final GoogleAuthorizationCodeFlow authorizationCodeFlow;
    private final GoogleIdTokenVerifier tokenVerifier;

    public GoogleService(GoogleAuthorizationCodeFlow authorizationCodeFlow, GoogleIdTokenVerifier tokenVerifier) {
        this.authorizationCodeFlow = authorizationCodeFlow;
        this.tokenVerifier = tokenVerifier;
    }

    public GoogleTokenResponse getAccessTokenFromAuthCode(String code) throws IOException {
        return authorizationCodeFlow
                .newTokenRequest(code)
                .setRedirectUri("postmessage")
                .execute();
    }

    public GoogleIdToken verifyAccessToken(GoogleTokenResponse token) throws GeneralSecurityException, IOException {
        return tokenVerifier.verify(token.getIdToken());
    }
}
