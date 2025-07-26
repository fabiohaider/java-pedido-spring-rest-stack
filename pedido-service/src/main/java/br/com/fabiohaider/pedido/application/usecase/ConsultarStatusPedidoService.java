
package br.com.fabiohaider.pedido.application.usecase;

import br.com.fabiohaider.pedido.application.ports.in.ConsultarStatusPedidoUseCase;
import br.com.fabiohaider.pedido.application.ports.out.PedidoRepositoryPort;
import br.com.fabiohaider.pedido.domain.enums.Status;
import br.com.fabiohaider.pedido.domain.model.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@SuppressWarnings("unused")
public class ConsultarStatusPedidoService implements ConsultarStatusPedidoUseCase {

    private static final Logger logger = LoggerFactory.getLogger(ConsultarStatusPedidoService.class);

    private final PedidoRepositoryPort repository;

    public ConsultarStatusPedidoService(PedidoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Status consultar(UUID pedidoId) {
        return repository.buscarPorId(pedidoId)
            .map(Pedido::status)
            .orElseThrow(() -> {
                logger.error("Pedido {} não encontrado", pedidoId);
                return new RuntimeException("Pedido não encontrado");
            });
                         
    }
}
