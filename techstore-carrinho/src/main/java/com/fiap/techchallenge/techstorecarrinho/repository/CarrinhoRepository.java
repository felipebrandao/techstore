package com.fiap.techchallenge.techstorecarrinho.repository;

import com.fiap.techchallenge.techstorecarrinho.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, UUID> {
}
