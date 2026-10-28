package br.com.aula.camadas.presentation;

import br.com.aula.camadas.business.PedidoService;
import br.com.aula.camadas.data.PedidoEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoResponse processar(@RequestBody PedidoRequest request) {
        PedidoEntity pedido = pedidoService.processar(request.descricao(), request.valor());
        return new PedidoResponse(pedido.getId(), pedido.getDescricao(), pedido.getValor(), pedido.getStatus());
    }

    public record PedidoRequest(String descricao, BigDecimal valor) {
    }

    public record PedidoResponse(UUID id, String descricao, BigDecimal valor, String status) {
    }
}
