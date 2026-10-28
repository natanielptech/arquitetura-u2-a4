package br.com.aula.hexagonal.adapters.out;

import br.com.aula.hexagonal.application.ports.out.PedidoRepository;
import br.com.aula.hexagonal.domain.Pedido;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoJpaAdapter implements PedidoRepository {

    private final SpringDataPedidoRepository repository;

    public PedidoJpaAdapter(SpringDataPedidoRepository repository) {
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
