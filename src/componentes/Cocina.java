package componentes;

import bus.EventBus;
import bus.EventHandler;
import eventos.ComidaPreparadaEvent;
import eventos.PedidoRealizadoEvent;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Procesa comida de los pedidos.
 */
public class Cocina implements EventHandler<PedidoRealizadoEvent> {

    private final EventBus bus;

    public Cocina(EventBus bus) {
        this.bus = bus;
    }

    @Override
    public void handle(PedidoRealizadoEvent event) {

        for (String item : event.getItems()) {

            if (esComida(item)) {

                CompletableFuture.runAsync(() -> {
                    try {
                        System.out.println("[Cocina] Cocinando " + item);
                        Thread.sleep(5000);

                        bus.publicar(new ComidaPreparadaEvent(
                                event.getPedidoId(),
                                item
                        ));

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }
    }

    // Solo alimentos reales
    private boolean esComida(String item) {
        return item.equalsIgnoreCase("hamburguesa")
                || item.equalsIgnoreCase("papas");
    }
}