package br.com.aula.clean.usecases;

import br.com.aula.clean.entities.Pedido;
import br.com.aula.clean.usecases.ports.PedidoRepository;

import java.math.BigDecimal;

public class ProcessarNovoPedido {

    private final PedidoRepository repository;

    public ProcessarNovoPedido(PedidoRepository repository) {
        this.repository = repository;
    }

    public Pedido executar(String descricao, BigDecimal valor) {
        return repository.salvar(Pedido.novo(descricao, valor));
    }
}
