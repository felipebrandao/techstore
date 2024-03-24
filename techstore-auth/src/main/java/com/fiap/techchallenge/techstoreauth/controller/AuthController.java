package com.fiap.techchallenge.techstoreauth.controller;

import com.fiap.techchallenge.techstoreauth.dto.request.LoginRequest;
import com.fiap.techchallenge.techstoreauth.dto.response.AuthResponse;
import com.fiap.techchallenge.techstoreauth.model.User;
import com.fiap.techchallenge.techstoreauth.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        String token = userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());

        return ResponseEntity.ok(new AuthResponse(token));
    }

}
