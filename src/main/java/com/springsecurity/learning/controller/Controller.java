package com.springsecurity.learning.controller;

import com.springsecurity.learning.auth.AuthService;
import com.springsecurity.learning.auth.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class Controller {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest registerRequest
    ){
        AuthenticationResponse authResponse = authService.register(registerRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(authResponse);
    }
}
