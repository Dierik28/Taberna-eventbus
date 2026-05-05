package componentes;

import bus.EventBus;
import eventos.PedidoRealizadoEvent;

import java.util.List;

/**
 * Genera pedidos y los publica en el bus.
 */
public class SistemaDePedidos {

    private final EventBus bus;

    public SistemaDePedidos(EventBus bus) {
        this.bus = bus;
    }

    public void crearPedido(int mesaId, int pedidoId, List<String> items) {

        System.out.println("[Sistema] Nuevo pedido en mesa " + mesaId);

        bus.publicar(new PedidoRealizadoEvent(
                mesaId,
                pedidoId,
                items
        ));
    }
}