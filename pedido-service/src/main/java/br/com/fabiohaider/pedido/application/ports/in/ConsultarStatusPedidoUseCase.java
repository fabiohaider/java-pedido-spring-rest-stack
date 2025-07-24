
package br.com.fabiohaider.pedido.application.ports.in;

import br.com.fabiohaider.pedido.domain.enums.Status;
import java.util.UUID;

@FunctionalInterface
public interface ConsultarStatusPedidoUseCase {
    Status consultar(UUID pedidoId);
}
