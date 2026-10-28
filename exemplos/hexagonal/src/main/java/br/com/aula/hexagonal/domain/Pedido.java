package br.com.aula.hexagonal.domain;

import java.math.BigDecimal;
import java.util.UUID;

public record Pedido(UUID id, String descricao, BigDecimal valor, String status) {

    public Pedido {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("A descrição do pedido é obrigatória");
        }
        if (valor == null || valor.signum() <= 0) {
            throw new IllegalArgumentException("O valor do pedido deve ser positivo");
        }
    }

    public static Pedido novo(String descricao, BigDecimal valor) {
        return new Pedido(UUID.randomUUID(), descricao, valor, "PROCESSADO");
    }
}
