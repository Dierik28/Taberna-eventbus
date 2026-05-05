package eventos;

import bus.Event;

/**
 * Evento que indica que una bebida fue servida.
 */
public final class BebidaServidaEvent implements Event {

    private final int mesaId;
    private final String bebida;

    public BebidaServidaEvent(int mesaId, String bebida) {
        this.mesaId = mesaId;
        this.bebida = bebida;
    }

    public int getMesaId() { return mesaId; }
    public String getBebida() { return bebida; }
}