package com.example.foodbook.service;

import com.example.foodbook.service.dto.GoogleProfileDto;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.util.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Service
public class GoogleService {
    private final GoogleAuthorizationCodeFlow authorizationCodeFlow;
    private final GoogleIdTokenVerifier tokenVerifier;
    private final UserService userService;

    @Value("${oauth2.provider.google.client-id}")
    private String clientId;

    public GoogleService(
            GoogleAuthorizationCodeFlow authorizationCodeFlow,
            GoogleIdTokenVerifier tokenVerifier,
            UserService userService
    ) {
        this.authorizationCodeFlow = authorizationCodeFlow;
        this.tokenVerifier = tokenVerifier;
        this.userService = userService;
    }

    public GoogleProfileDto getUserInfo(String code) throws IOException, GeneralSecurityException {
        var accessToken = getAccessTokenFromAuthCode(code);
        var payload = verifyAccessToken(accessToken).getPayload();
        return GoogleProfileDto.from(payload);
    }

    private GoogleTokenResponse getAccessTokenFromAuthCode(String code) throws IOException {
        return authorizationCodeFlow
                .newTokenRequest(code)
                .setRedirectUri("postmessage")
                .execute();
    }

    private GoogleIdToken verifyAccessToken(GoogleTokenResponse token) throws GeneralSecurityException, IOException {
        return tokenVerifier.verify(token.getIdToken());
    }
}
