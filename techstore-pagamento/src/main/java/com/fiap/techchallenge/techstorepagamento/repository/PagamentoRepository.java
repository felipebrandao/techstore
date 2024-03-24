package com.fiap.techchallenge.techstorepagamento.repository;

import com.fiap.techchallenge.techstorepagamento.model.Pagamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PagamentoRepository extends MongoRepository<Pagamento, UUID> {
}
