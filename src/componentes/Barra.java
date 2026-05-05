package componentes;

import bus.EventBus;
import bus.EventHandler;
import eventos.BebidaServidaEvent;
import eventos.PedidoRealizadoEvent;

import java.util.concurrent.CompletableFuture;

/**
 * Prepara bebidas de los pedidos.
 */
public class Barra implements EventHandler<PedidoRealizadoEvent> {

    private final EventBus bus;

    public Barra(EventBus bus) {
        this.bus = bus;
    }

    @Override
    public void handle(PedidoRealizadoEvent event) {

        for (String item : event.getItems()) {

            if (esBebida(item)) {

                CompletableFuture.runAsync(() -> {
                    try {
                        System.out.println("[Barra] Preparando " + item);
                        Thread.sleep(2000);

                        bus.publicar(new BebidaServidaEvent(
                                event.getMesaId(),
                                item
                        ));

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }
    }

    private boolean esBebida(String item) {
        return item.equalsIgnoreCase("cerveza")
                || item.equalsIgnoreCase("agua");
    }
}