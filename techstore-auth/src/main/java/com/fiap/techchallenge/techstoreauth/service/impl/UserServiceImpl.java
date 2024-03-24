package com.fiap.techchallenge.techstoreauth.service.impl;

import com.fiap.techchallenge.techstoreauth.exception.AuthenticationFailedException;
import com.fiap.techchallenge.techstoreauth.exception.UsuarioExisteException;
import com.fiap.techchallenge.techstoreauth.model.User;
import com.fiap.techchallenge.techstoreauth.repository.UserRepository;
import com.fiap.techchallenge.techstoreauth.security.JwtTokenProvider;
import com.fiap.techchallenge.techstoreauth.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public User registerUser(User user) {

        if (userRepository.findByUsername(user.getUsername())) {
            throw new UsuarioExisteException("Username já existe");
        }

        if(userRepository.existsByEmail(user.getEmail())){
            throw new UsuarioExisteException("Email já existe");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public String authenticateUser(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        if (authentication.isAuthenticated()) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return jwtTokenProvider.generateToken(userDetails);
        } else {
            throw new AuthenticationFailedException("Falha na autenticação: Email do usuário ou senha inválidos.");
        }
    }
}
