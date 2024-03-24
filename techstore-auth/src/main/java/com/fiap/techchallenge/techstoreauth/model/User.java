package com.fiap.techchallenge.techstoreauth.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
public class User {

    @Id
    private UUID id;
    private String username;
    private String email;
    private String password;

}
