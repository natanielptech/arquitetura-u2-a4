package br.com.aula.hexagonal.application.ports.out;

import br.com.aula.hexagonal.domain.Pedido;

public interface PedidoRepository {
    Pedido salvar(Pedido pedido);
}
