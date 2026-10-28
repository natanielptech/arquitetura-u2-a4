package br.com.aula.clean.usecases;

import br.com.aula.clean.entities.Pedido;
import br.com.aula.clean.usecases.ports.PedidoRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProcessarNovoPedidoTest {

    @Test
    void processaPedidoComGatewayEmMemoria() {
        List<Pedido> pedidos = new ArrayList<>();
        PedidoRepository repository = pedido -> {
            pedidos.add(pedido);
            return pedido;
        };
        ProcessarNovoPedido useCase = new ProcessarNovoPedido(repository);

        Pedido resultado = useCase.executar("Livro", new BigDecimal("49.90"));

        assertNotNull(resultado.id());
        assertEquals("PROCESSADO", resultado.status());
        assertEquals(1, pedidos.size());
    }
}
