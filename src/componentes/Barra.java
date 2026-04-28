package componentes;

import bus.EventBus;
import bus.EventHandler;
import eventos.BebidaServidaEvent;
import eventos.PedidoRealizadoEvent;

public class Barra implements EventHandler<PedidoRealizadoEvent> {

    private final EventBus bus;

    public Barra(EventBus bus) {
        this.bus = bus;
    }

    @Override
    public void handle(PedidoRealizadoEvent event) {

        for (String item : event.getItems()) {
            if (esBebida(item)) {
                prepararBebida(event.getMesaId(), item);
            }
        }
    }

    private boolean esBebida(String item) {
        return item.equalsIgnoreCase("cerveza");
    }

    private void prepararBebida(int mesaId, String bebida) {
        System.out.println("[Barra] Preparando " + bebida);

        bus.publish(new BebidaServidaEvent(mesaId, bebida));
    }
}