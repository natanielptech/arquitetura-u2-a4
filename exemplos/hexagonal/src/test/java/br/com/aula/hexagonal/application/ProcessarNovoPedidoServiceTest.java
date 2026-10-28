package br.com.aula.hexagonal.application;

import br.com.aula.hexagonal.application.ports.out.PedidoRepository;
import br.com.aula.hexagonal.domain.Pedido;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProcessarNovoPedidoServiceTest {

    @Test
    void processaPedidoComAdaptadorEmMemoria() {
        List<Pedido> pedidos = new ArrayList<>();
        PedidoRepository repository = pedido -> {
            pedidos.add(pedido);
            return pedido;
        };
        ProcessarNovoPedidoService service = new ProcessarNovoPedidoService(repository);

        Pedido resultado = service.processar("Livro", new BigDecimal("49.90"));

        assertNotNull(resultado.id());
        assertEquals("PROCESSADO", resultado.status());
        assertEquals(1, pedidos.size());
    }
}
