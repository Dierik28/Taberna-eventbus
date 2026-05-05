package componentes;

import bus.Event;
import bus.EventHandler;
import eventos.*;

/**
 * Muestra notificaciones en consola.
 */
public class PanelLED implements EventHandler<Event> {

    @Override
    public void handle(Event event) {

        if (event instanceof BebidaServidaEvent e) {
            System.out.println("[LED] Bebida lista en mesa " + e.getMesaId());
        }

        else if (event instanceof ComidaPreparadaEvent e) {
            System.out.println("[LED] Comida lista del pedido " + e.getPedidoId());
        }

        else if (event instanceof BandaTocandoEvent e) {
            System.out.println("[LED] Tocando: " + e.getCancion());
        }
    }
}