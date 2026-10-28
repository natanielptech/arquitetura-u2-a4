package br.com.aula.clean.usecases.ports;

import br.com.aula.clean.entities.Pedido;

public interface PedidoRepository {
    Pedido salvar(Pedido pedido);
}
