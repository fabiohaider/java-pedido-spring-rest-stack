
package br.com.fabiohaider.pedido.infrastructure.persistence.repository;

import br.com.fabiohaider.pedido.infrastructure.persistence.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringJpaPedidoRepository extends JpaRepository<PedidoEntity, UUID> {
}
