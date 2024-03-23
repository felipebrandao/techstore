package com.fiap.techchallenge.techstoreauth.service.impl;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        // Implementação para registrar um novo usuário
    }

    @Override
    public User authenticateUser(String username, String password) {
        // Implementação para autenticar um usuário
    }

    @Override
    public User findByUsername(String username) {
        // Implementação para buscar um usuário por nome de usuário
    }
}
