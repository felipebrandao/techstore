package com.fiap.techchallenge.techstoreitens.repository;

import com.fiap.techchallenge.techstoreitens.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepository extends MongoRepository<Item, UUID> {

}
