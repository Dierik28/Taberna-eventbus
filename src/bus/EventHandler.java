package bus;

/**
 * Interfaz para cualquier clase que quiera escuchar eventos.
 */
@FunctionalInterface
public interface EventHandler<T extends Event> {
    void handle(T event);
}