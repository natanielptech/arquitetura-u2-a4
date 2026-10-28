package br.com.aula.hexagonal.adapters.out;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "pedidos")
public class PedidoJpaEntity {

    @Id
    private UUID id;

    private String descricao;

    private BigDecimal valor;

    private String status;

    protected PedidoJpaEntity() {
    }

    public PedidoJpaEntity(UUID id, String descricao, BigDecimal valor, String status) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }
}
