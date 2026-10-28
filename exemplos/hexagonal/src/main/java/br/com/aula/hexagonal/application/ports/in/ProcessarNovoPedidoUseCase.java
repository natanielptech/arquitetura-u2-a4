package br.com.aula.hexagonal.application.ports.in;

import br.com.aula.hexagonal.domain.Pedido;

import java.math.BigDecimal;

public interface ProcessarNovoPedidoUseCase {
    Pedido processar(String descricao, BigDecimal valor);
}
