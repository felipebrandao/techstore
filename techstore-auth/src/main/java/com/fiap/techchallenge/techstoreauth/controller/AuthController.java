package com.fiap.techchallenge.techstoreauth.controller;

import com.fiap.techchallenge.techstoreauth.dto.request.LoginRequest;
import com.fiap.techchallenge.techstoreauth.dto.response.AuthResponse;
import com.fiap.techchallenge.techstoreauth.model.UserTech;
import com.fiap.techchallenge.techstoreauth.security.JwtTokenProvider;
import com.fiap.techchallenge.techstoreauth.service.UserTechService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserTechService userTechService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserTechService userTechService, JwtTokenProvider jwtTokenProvider) {
        this.userTechService = userTechService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserTech userTech) {
        UserTech registeredUserTech = userTechService.registerUser(userTech);
        return new ResponseEntity<>(registeredUserTech, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        String token = userTechService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());

        return ResponseEntity.ok(new AuthResponse(token));
    }

    @GetMapping("/validate-token")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            String token = authorizationHeader.replace("Bearer ", "");

            String username = jwtTokenProvider.extractUsername(token);
            if (username != null) {
                UserTech user = userTechService.findByUsername(username);
                if (user != null) {
                    return ResponseEntity.ok(user);
                }
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token não é válido ou expirou.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token não é válido ou expirou.");
        }
    }

}
