import bus.EventBus;
import componentes.*;
import eventos.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        EventBus bus = new EventBus();

        // Componentes
        SistemaDePedidos pedidos = new SistemaDePedidos(bus);
        Barra barra = new Barra(bus);
        PanelLED panel = new PanelLED();

        // Suscripciones
        bus.suscribir(PedidoRealizadoEvent.class, barra);
        bus.suscribir(BebidaServidaEvent.class, panel);

        // Flujo
        pedidos.crearPedido(1, 100, Arrays.asList("cerveza", "tacos"));
    }
}