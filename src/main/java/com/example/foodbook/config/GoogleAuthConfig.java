package com.example.foodbook.config;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class GoogleAuthConfig {
    @Value("${oauth2.provider.google.client-id}")
    private String clientId;

    @Value("${oauth2.provider.google.client-secret}")
    private String clientSecret;

    @Value("${oauth2.provider.google.scopes}")
    private String[] scopes;

    @Bean
    public GoogleAuthorizationCodeFlow googleAuthorizationCodeFlow() {
        return new GoogleAuthorizationCodeFlow(
                new NetHttpTransport(),
                new GsonFactory(),
                clientId,
                clientSecret,
                Arrays.asList(scopes)
        );
    }

    @Bean
    public GoogleIdTokenVerifier googleIdTokenVerifier() {
        return new GoogleIdTokenVerifier
                .Builder(new NetHttpTransport(), new GsonFactory())
                .setAudience(Collections.singletonList(clientId))
                .build();
    }
}
