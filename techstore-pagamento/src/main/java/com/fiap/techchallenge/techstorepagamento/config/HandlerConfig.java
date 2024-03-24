package com.fiap.techchallenge.techstorepagamento.config;

import com.fiap.techchallenge.techstorepagamento.dto.ErroDeFormularioDTO;
import com.fiap.techchallenge.techstorepagamento.dto.ErrorDTO;
import com.fiap.techchallenge.techstorepagamento.exception.PagamentoException;
import com.fiap.techchallenge.techstorepagamento.exception.PagamentoJaEfetuadoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@RestControllerAdvice
@Order(HIGHEST_PRECEDENCE)
@Component
@Slf4j
public class HandlerConfig {


    @ExceptionHandler(PagamentoException.class)
    public ResponseEntity<ErrorDTO> handleTechChallengeException(PagamentoException ex) {
        log.error("Erro na requisição, erro: ", ex);
        ErrorDTO error = new ErrorDTO(Instant.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<ErroDeFormularioDTO>> handleException(MethodArgumentNotValidException ex) {
        log.error("Erro na requisição, erro: ", ex);

        List<ErroDeFormularioDTO> dto = new ArrayList<>();

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            ErroDeFormularioDTO erro = new ErroDeFormularioDTO(e.getField(), e.getDefaultMessage());
            dto.add(erro);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDTO> handleException(Exception ex) {
        log.error("Erro na requisição, erro: ", ex);
        ErrorDTO error = new ErrorDTO(Instant.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro inesperado");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(PagamentoJaEfetuadoException.class)
    public ResponseEntity<ErrorDTO> handleTechChallengeException(PagamentoJaEfetuadoException ex) {
        log.error("Erro na requisição, erro: ", ex);
        ErrorDTO error = new ErrorDTO(Instant.now(), HttpStatus.BAD_REQUEST .value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
