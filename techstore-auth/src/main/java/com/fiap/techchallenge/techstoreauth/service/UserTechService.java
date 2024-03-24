package com.fiap.techchallenge.techstoreauth.service;

import com.fiap.techchallenge.techstoreauth.model.UserTech;

public interface UserTechService {

    UserTech registerUser(UserTech userTech);
    String authenticateUser(String username, String password);

    UserTech findByUsername(String username);
}
