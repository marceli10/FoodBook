package com.example.foodbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User with given id doesn't exist")
public class UserNotFoundException extends RuntimeException {}
