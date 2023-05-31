package com.example.foodbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "You cannot delete other users recipes")
public class PermissionException extends RuntimeException{
}
