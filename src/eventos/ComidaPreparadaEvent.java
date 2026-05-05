package eventos;

import bus.Event;

/**
 * Evento que indica que la comida está lista.
 */
public final class ComidaPreparadaEvent implements Event {

    private final int pedidoId;
    private final String plato;

    public ComidaPreparadaEvent(int pedidoId, String plato) {
        this.pedidoId = pedidoId;
        this.plato = plato;
    }

    public int getPedidoId() { return pedidoId; }
    public String getPlato() { return plato; }
}