package bus;

/**
 * Define el contrato para cualquier componente que quiera reaccionar a eventos.
 */
@FunctionalInterface
public interface EventHandler<T extends Event> {
    void handle(T event);
}