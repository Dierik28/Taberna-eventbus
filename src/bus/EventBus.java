package bus;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Implementación central del patrón Event Bus.
 */
public class EventBus {

    private final Map<Class<? extends Event>, List<EventHandler<? extends Event>>> subscribers = new ConcurrentHashMap<>();

    public <T extends Event> void suscribir(Class<T> eventType, EventHandler<T> handler) {
        subscribers
                .computeIfAbsent(eventType, k -> new CopyOnWriteArrayList<>())
                .add(handler);
    }

    public <T extends Event> void desuscribir(Class<T> eventType, EventHandler<T> handler) {
        List<EventHandler<? extends Event>> handlers = subscribers.get(eventType);
        if (handlers != null) {
            handlers.remove(handler);
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends Event> void publicar(T event) {
        List<EventHandler<? extends Event>> handlers = subscribers.get(event.getClass());

        if (handlers == null) return;

        for (EventHandler<? extends Event> handler : handlers) {
            ((EventHandler<T>) handler).handle(event);
        }
    }
}