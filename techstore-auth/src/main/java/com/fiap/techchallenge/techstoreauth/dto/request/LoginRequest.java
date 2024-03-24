package com.fiap.techchallenge.techstoreauth.dto.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
