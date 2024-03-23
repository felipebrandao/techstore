package com.fiap.techchallenge.techstorecarrinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemCarrinho extends JpaRepository<ItemCarrinho, UUID> {
}
