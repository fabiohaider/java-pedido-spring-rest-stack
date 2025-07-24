
package br.com.fabiohaider.pedido.application.ports.out;

import br.com.fabiohaider.pedido.domain.model.Pedido;
import java.util.Optional;
import java.util.UUID;

public interface PedidoRepositoryPort {
    Pedido salvar(Pedido pedido);
    Optional<Pedido> buscarPorId(UUID id);
}
