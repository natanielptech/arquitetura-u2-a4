package br.com.aula.clean.adapters.controllers;

import br.com.aula.clean.entities.Pedido;
import br.com.aula.clean.usecases.ProcessarNovoPedido;
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

    private final ProcessarNovoPedido useCase;

    public PedidoController(ProcessarNovoPedido useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoResponse processar(@RequestBody PedidoRequest request) {
        Pedido pedido = useCase.executar(request.descricao(), request.valor());
        return new PedidoResponse(pedido.id(), pedido.descricao(), pedido.valor(), pedido.status());
    }

    public record PedidoRequest(String descricao, BigDecimal valor) {
    }

    public record PedidoResponse(UUID id, String descricao, BigDecimal valor, String status) {
    }
}
