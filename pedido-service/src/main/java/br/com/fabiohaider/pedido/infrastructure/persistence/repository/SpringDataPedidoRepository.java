package br.com.fabiohaider.pedido.infrastructure.persistence.repository;

import br.com.fabiohaider.pedido.application.ports.out.PedidoRepositoryPort;
import br.com.fabiohaider.pedido.domain.model.Pedido;
import br.com.fabiohaider.pedido.infrastructure.persistence.entity.PedidoEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@SuppressWarnings("unused")
public class SpringDataPedidoRepository implements PedidoRepositoryPort {

    private final SpringJpaPedidoRepository jpa;

    public SpringDataPedidoRepository(SpringJpaPedidoRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Pedido salvar(Pedido pedido) {
        var entity = new PedidoEntity();
        entity.setId(pedido.id());
        entity.setClienteId(pedido.clienteId());
        entity.setStatus(pedido.status());
        entity.setDataCriacao(pedido.dataCriacao());
        return toDomain(jpa.save(entity));
    }

    @Override
    public Optional<Pedido> buscarPorId(UUID id) {
        return jpa.findById(id).map(this::toDomain);
    }

    private Pedido toDomain(PedidoEntity e) {
        return new Pedido(e.getId(), e.getClienteId(), e.getStatus(), e.getDataCriacao());
    }
}
