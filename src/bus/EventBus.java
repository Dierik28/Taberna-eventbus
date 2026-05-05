package bus;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Implementación del Event Bus.
 * Maneja la suscripción y publicación de eventos.
 */
public class EventBus {

    // Mapa: tipo de evento -> lista de suscriptores
    private final Map<Class<? extends Event>, List<EventHandler<? extends Event>>> subscribers = new ConcurrentHashMap<>();

    /**
     * Suscribe un handler a un tipo de evento.
     */
    public <T extends Event> void suscribir(Class<T> eventType, EventHandler<T> handler) {
        subscribers
                .computeIfAbsent(eventType, k -> new CopyOnWriteArrayList<>())
                .add(handler);
    }

    /**
     * Desuscribe un handler.
     */
    public <T extends Event> void desuscribir(Class<T> eventType, EventHandler<T> handler) {
        List<EventHandler<? extends Event>> handlers = subscribers.get(eventType);
        if (handlers != null) {
            handlers.remove(handler);
        }
    }

    /**
     * Publica un evento a todos los suscriptores compatibles.
     */
    @SuppressWarnings("unchecked")
    public <T extends Event> void publicar(T event) {

        for (Map.Entry<Class<? extends Event>, List<EventHandler<? extends Event>>> entry : subscribers.entrySet()) {

            // Permite que un suscriptor escuche subtipos (ej: Event.class)
            if (entry.getKey().isAssignableFrom(event.getClass())) {

                for (EventHandler<?> handler : entry.getValue()) {
                    ((EventHandler<T>) handler).handle(event);
                }
            }
        }
    }
}