package com.fiap.techchallenge.techstorepagamento.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Document
@Data
public class Pagamento {

    @Id
    private UUID id;
    private BigDecimal total;
    private LocalDate dataPagamento;

}
