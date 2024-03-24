package com.fiap.techchallenge.techstoregateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTech {

    private String username;
    private String email;
    private String tipoUsuario;

}
