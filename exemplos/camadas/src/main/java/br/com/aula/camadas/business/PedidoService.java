package br.com.aula.camadas.business;

import br.com.aula.camadas.data.PedidoEntity;
import br.com.aula.camadas.data.PedidoJpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PedidoService {

    private final PedidoJpaRepository repository;

    public PedidoService(PedidoJpaRepository repository) {
        this.repository = repository;
    }

    public PedidoEntity processar(String descricao, BigDecimal valor) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("A descrição do pedido é obrigatória");
        }
        if (valor == null || valor.signum() <= 0) {
            throw new IllegalArgumentException("O valor do pedido deve ser positivo");
        }
        PedidoEntity pedido = new PedidoEntity(descricao, valor, "PROCESSADO");
        return repository.save(pedido);
    }
}
