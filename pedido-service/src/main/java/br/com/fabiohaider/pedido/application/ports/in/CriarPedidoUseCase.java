
package br.com.fabiohaider.pedido.application.ports.in;

import br.com.fabiohaider.pedido.domain.model.Pedido;
import java.util.UUID;

@FunctionalInterface
public interface CriarPedidoUseCase {
    Pedido criar(UUID clienteId);
}
