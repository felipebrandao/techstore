package com.fiap.techchallenge.techstoreauth.service;

public interface UserService {

    User registerUser(User user);
    User authenticateUser(String username, String password);
    User findByUsername(String username);

}
