package br.com.aula.camadas.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String descricao;

    private BigDecimal valor;

    private String status;

    protected PedidoEntity() {
    }

    public PedidoEntity(String descricao, BigDecimal valor, String status) {
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
