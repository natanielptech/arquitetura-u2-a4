package br.com.aula.hexagonal.application;

import br.com.aula.hexagonal.application.ports.in.ProcessarNovoPedidoUseCase;
import br.com.aula.hexagonal.application.ports.out.PedidoRepository;
import br.com.aula.hexagonal.domain.Pedido;

import java.math.BigDecimal;

public class ProcessarNovoPedidoService implements ProcessarNovoPedidoUseCase {

    private final PedidoRepository repository;

    public ProcessarNovoPedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pedido processar(String descricao, BigDecimal valor) {
        return repository.salvar(Pedido.novo(descricao, valor));
    }
}
