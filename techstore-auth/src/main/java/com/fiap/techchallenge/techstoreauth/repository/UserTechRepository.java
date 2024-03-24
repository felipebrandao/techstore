package com.fiap.techchallenge.techstoreauth.repository;

import com.fiap.techchallenge.techstoreauth.model.UserTech;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserTechRepository extends MongoRepository<UserTech, UUID> {
    UserTech findByUsername(String username);

    boolean existsByEmail(String email);
}
