package eventos;

import bus.Event;

/**
 * Evento que indica que la banda está tocando.
 */
public final class BandaTocandoEvent implements Event {

    private final String nombreBanda;
    private final String cancion;
    private final int duracion;

    public BandaTocandoEvent(String nombreBanda, String cancion, int duracion) {
        this.nombreBanda = nombreBanda;
        this.cancion = cancion;
        this.duracion = duracion;
    }

    public String getNombreBanda() { return nombreBanda; }
    public String getCancion() { return cancion; }
    public int getDuracion() { return duracion; }
}