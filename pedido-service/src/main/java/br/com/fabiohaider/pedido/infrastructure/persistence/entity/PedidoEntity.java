
package br.com.fabiohaider.pedido.infrastructure.persistence.entity;

import br.com.fabiohaider.pedido.domain.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@NoArgsConstructor
@SuppressWarnings("unused")
public class PedidoEntity {

    @Id
    private UUID id;

    @Column(name = "cliente_id", nullable = false)
    private UUID clienteId;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "data_criacao")
    private Instant dataCriacao;

}
