package componentes;

import bus.EventBus;
import eventos.PedidoRealizadoEvent;

import java.util.List;

/**
 * Encargado de generar pedidos.
 */
public class SistemaDePedidos {

    private final EventBus bus;

    public SistemaDePedidos(EventBus bus) {
        this.bus = bus;
    }

    public void crearPedido(int mesaId, int pedidoId, List<String> items) {
        PedidoRealizadoEvent event = new PedidoRealizadoEvent(mesaId, pedidoId, items);
        bus.publish(event);
    }
}