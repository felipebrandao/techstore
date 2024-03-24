package com.fiap.techchallenge.techstoreauth.service.impl;

import com.fiap.techchallenge.techstoreauth.exception.AuthenticationFailedException;
import com.fiap.techchallenge.techstoreauth.exception.UsuarioExisteException;
import com.fiap.techchallenge.techstoreauth.model.UserTech;
import com.fiap.techchallenge.techstoreauth.repository.UserTechRepository;
import com.fiap.techchallenge.techstoreauth.security.JwtTokenProvider;
import com.fiap.techchallenge.techstoreauth.service.UserTechService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserTechServiceImpl implements UserTechService {
    private final UserTechRepository userTechRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public UserTechServiceImpl(UserTechRepository userTechRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.userTechRepository = userTechRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public UserTech registerUser(UserTech userTech) {

        if (userTechRepository.existsByEmail(userTech.getUsername())) {
            throw new UsuarioExisteException("Username já existe");
        }

        if(userTechRepository.existsByEmail(userTech.getEmail())){
            throw new UsuarioExisteException("Email já existe");
        }

        userTech.setId(UUID.randomUUID());
        userTech.setPassword(passwordEncoder.encode(userTech.getPassword()));

        return userTechRepository.save(userTech);
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

    @Override
    public UserTech findByUsername(String username) {
        UserTech userTechEncontrado = userTechRepository.findByUsername(username);
        if(userTechEncontrado == null){
            throw new UsuarioExisteException("Usuário não encontrado");
        }

        return userTechEncontrado;
    }

}
