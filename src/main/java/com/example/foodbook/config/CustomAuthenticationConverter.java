package com.example.foodbook.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.example.foodbook.model.security.SecurityRoles.ROLE_PREFIX;

public class CustomAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Override
    public final JwtAuthenticationToken convert(@NonNull Jwt jwt) {
        String role = String.format("%s%s", ROLE_PREFIX, jwt.getClaim("role"));

        return new JwtAuthenticationToken(
                jwt,
                List.of(new SimpleGrantedAuthority(role)),
                jwt.getSubject()
        );
    }
}