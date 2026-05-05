import bus.Event;
import bus.EventBus;
import componentes.*;
import eventos.*;

import java.util.Arrays;

/**
 * Simulación principal del sistema.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        EventBus bus = new EventBus();

        // Componentes
        SistemaDePedidos pedidos = new SistemaDePedidos(bus);
        Barra barra = new Barra(bus);
        Cocina cocina = new Cocina(bus);
        Banda banda = new Banda(bus);
        PanelLED panel = new PanelLED();
        SistemaDeSonido sonido = new SistemaDeSonido();
        SistemaDeHumo humo = new SistemaDeHumo();

        // Suscripciones
        bus.suscribir(PedidoRealizadoEvent.class, barra);
        bus.suscribir(PedidoRealizadoEvent.class, cocina);

        bus.suscribir(Event.class, panel); // escucha todo

        bus.suscribir(BandaTocandoEvent.class, sonido);
        bus.suscribir(BandaTocandoEvent.class, humo);

        System.out.println("====================================");
        System.out.println("  Taberna El Gólem Alquímico");
        System.out.println("====================================\n");

        // Canción 1
        banda.tocarCancion("Los Tigres del Norte", "La Puerta Negra", 180);

        // Pedido 1
        pedidos.crearPedido(5, 101, Arrays.asList("cerveza", "hamburguesa"));

        Thread.sleep(3000);

        // Canción 2
        banda.tocarCancion("Los Ángeles Azules", "Cómo Te Voy a Olvidar", 300);

        // Pedido 2
        pedidos.crearPedido(7, 102, Arrays.asList("agua", "papas"));

        Thread.sleep(3000);

        // Momento especial
        System.out.println("\n[Sistema] La música sube de ambiente...");
        banda.tocarCancion("Maná", "Oye Mi Amor", 240);

        Thread.sleep(7000);

        System.out.println("\n====================================");
        System.out.println("  Fin de la simulación");
        System.out.println("====================================");
    }
}