package com.fiap.techchallenge.techstorepagamento.service.impl;

import com.fiap.techchallenge.techstorepagamento.dto.CarrinhoDTO;
import com.fiap.techchallenge.techstorepagamento.dto.ItemCarrinhoDTO;
import com.fiap.techchallenge.techstorepagamento.exception.PagamentoJaEfetuadoException;
import com.fiap.techchallenge.techstorepagamento.model.Pagamento;
import com.fiap.techchallenge.techstorepagamento.repository.PagamentoRepository;
import com.fiap.techchallenge.techstorepagamento.service.PagamentoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;
import java.util.UUID;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoServiceImpl(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @Override
    public CarrinhoDTO simularPagamento(CarrinhoDTO carrinhoDTO) {
        BigDecimal valorTotal = BigDecimal.ZERO;

        valorTotal = valorTotalPedido(carrinhoDTO, valorTotal);

        carrinhoDTO.setValorTotal(valorTotal);

        return carrinhoDTO;
    }

    private static BigDecimal valorTotalPedido(CarrinhoDTO carrinhoDTO, BigDecimal valorTotal) {
        for (ItemCarrinhoDTO item : carrinhoDTO.getItens()) {
            BigDecimal subtotalItem = item.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade()));
            valorTotal = valorTotal.add(subtotalItem);
        }
        return valorTotal;
    }

    @Override
    public void processarPagamento(UUID idPedido, CarrinhoDTO carrinhoDTO) {

//        Optional<Pagamento> pagamentoEfetuado = pagamentoRepository.findById(idPedido);
//
//        if(pagamentoEfetuado.isPresent()){
//            throw new PagamentoJaEfetuadoException("Pedido com este ID " + idPedido + " já efetuado pagamento.");
//        }

        BigDecimal valorTotal = BigDecimal.ZERO;
        LocalDate now = LocalDate.now();
        valorTotal = valorTotalPedido(carrinhoDTO, valorTotal);

        Pagamento pagamento = new Pagamento();
        pagamento.setId(carrinhoDTO.getId());
        pagamento.setDataPagamento(now);
        pagamento.setTotal(valorTotal);

        pagamentoRepository.save(pagamento);
    }

}
