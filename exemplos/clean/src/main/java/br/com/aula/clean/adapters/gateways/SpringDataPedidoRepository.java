package br.com.aula.clean.adapters.gateways;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataPedidoRepository extends JpaRepository<PedidoJpaEntity, UUID> {
}
