package eventos;

import bus.Event;
import java.util.List;

public final class PedidoRealizadoEvent implements Event {

    private final int mesaId;
    private final int pedidoId;
    private final List<String> items;

    public PedidoRealizadoEvent(int mesaId, int pedidoId, List<String> items) {
        this.mesaId = mesaId;
        this.pedidoId = pedidoId;
        this.items = List.copyOf(items); // inmutabilidad defensiva
    }

    public int getMesaId() {
        return mesaId;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public List<String> getItems() {
        return items;
    }
}