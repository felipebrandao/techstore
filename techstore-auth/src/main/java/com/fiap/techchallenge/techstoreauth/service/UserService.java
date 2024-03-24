package com.fiap.techchallenge.techstoreauth.service;

import com.fiap.techchallenge.techstoreauth.model.User;

public interface UserService {

    User registerUser(User user);
    String authenticateUser(String username, String password);
}
