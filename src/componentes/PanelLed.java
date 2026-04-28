package componentes;

import bus.EventHandler;
import eventos.BebidaServidaEvent;

public class PanelLED implements EventHandler<BebidaServidaEvent> {

    @Override
    public void handle(BebidaServidaEvent event) {
        System.out.println("[LED] Bebida lista en mesa " + event.getMesaId());
    }
}