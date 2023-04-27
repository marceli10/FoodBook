package com.example.foodbook.controller;

import com.example.foodbook.controller.dto.request.CodeDto;
import com.example.foodbook.service.SecurityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/security")
public class SecurityController {

    private final SecurityService securityService;

    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @PostMapping("/oauth/google")
    public String singInWithGoogle(@RequestBody CodeDto codeDto) {
        return securityService.signInWithGoogle(codeDto.code());
    }
}
