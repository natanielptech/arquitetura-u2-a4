package br.com.aula.hexagonal.adapters.out;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataPedidoRepository extends JpaRepository<PedidoJpaEntity, UUID> {
}
