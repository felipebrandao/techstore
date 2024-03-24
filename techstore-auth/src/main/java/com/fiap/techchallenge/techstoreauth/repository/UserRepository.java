package com.fiap.techchallenge.techstoreauth.repository;

import com.fiap.techchallenge.techstoreauth.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {
    boolean findByUsername(String username);

    boolean existsByEmail(String email);
}
