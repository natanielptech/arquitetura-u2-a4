package br.com.aula.clean.adapters.gateways;

import br.com.aula.clean.entities.Pedido;
import br.com.aula.clean.usecases.ports.PedidoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class PedidoJpaGateway implements PedidoRepository {

    private final SpringDataPedidoRepository repository;

    public PedidoJpaGateway(SpringDataPedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pedido salvar(Pedido pedido) {
        PedidoJpaEntity entity = new PedidoJpaEntity(
                pedido.id(), pedido.descricao(), pedido.valor(), pedido.status());
        PedidoJpaEntity saved = repository.save(entity);
        return new Pedido(saved.getId(), saved.getDescricao(), saved.getValor(), saved.getStatus());
    }
}
