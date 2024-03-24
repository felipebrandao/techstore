package com.fiap.techchallenge.techstoreitens.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Document
@Data
public class Item {

    @Id
    private UUID id;
    private String descricao;
    private BigDecimal preco;

}
