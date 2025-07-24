package br.com.fabiohaider.pedido.infrastructure.controller.dto;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record PedidoRequest(@NotNull UUID clienteId) {
}