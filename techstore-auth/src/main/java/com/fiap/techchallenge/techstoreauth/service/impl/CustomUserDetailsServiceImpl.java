package com.fiap.techchallenge.techstoreauth.service.impl;

import com.fiap.techchallenge.techstoreauth.enums.TipoUsuarioEnum;
import com.fiap.techchallenge.techstoreauth.model.UserTech;
import com.fiap.techchallenge.techstoreauth.repository.UserTechRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserTechRepository userTechRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserTech userTech = userTechRepository.findByUsername(username);
        if (userTech == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        if (userTech.getTipoUsuario().equals(TipoUsuarioEnum.CLIENTE)) {
            authorities.add(new SimpleGrantedAuthority("CLIENTE"));
        } else if (userTech.getTipoUsuario().equals(TipoUsuarioEnum.ADMINISTRADOR)) {
            authorities.add(new SimpleGrantedAuthority("ADMINISTRADOR"));
        }

        return new User(userTech.getUsername(), userTech.getPassword(), authorities);

    }

}
