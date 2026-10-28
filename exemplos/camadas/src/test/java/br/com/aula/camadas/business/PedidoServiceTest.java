package br.com.aula.camadas.business;

import br.com.aula.camadas.data.PedidoEntity;
import br.com.aula.camadas.data.PedidoJpaRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PedidoServiceTest {

    @Test
    void processaPedidoComRepositorioDuble() {
        PedidoJpaRepository repository = mock(PedidoJpaRepository.class);
        PedidoService service = new PedidoService(repository);
        when(repository.save(org.mockito.ArgumentMatchers.any(PedidoEntity.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        PedidoEntity resultado = service.processar("Livro", new BigDecimal("49.90"));

        assertEquals("PROCESSADO", resultado.getStatus());
        assertEquals("Livro", resultado.getDescricao());
    }
}
