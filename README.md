#  Taberna El Gólem Alquímico
### Meta 3.1 – Análisis y Diseño de Sistemas

---

##  Descripción del problema

En la taberna **“El Gólem Alquímico”** ocurren múltiples procesos al mismo tiempo:

- Los clientes realizan pedidos
- La barra prepara bebidas
- La cocina prepara alimentos
- La banda toca música en vivo
- El sistema de sonido ajusta la música
- Un panel LED muestra lo que sucede en el lugar

El problema es que, si estos componentes están acoplados, cada cambio o nueva funcionalidad
requiere modificar varias partes del sistema, lo que lo vuelve difícil de mantener.

---

##  Objetivo del proyecto

Implementar el patrón **Publisher/Subscriber** mediante un **Event Bus** para:

- Desacoplar los componentes
- Permitir comunicación mediante eventos
- Facilitar la extensión del sistema

---

##  ¿Cómo funciona?

Cada acción importante genera un evento, por ejemplo:

- Pedido realizado
- Bebida servida
- Comida preparada
- Canción en reproducción

El **EventBus**:

1. Recibe el evento
2. Busca los suscriptores
3. Notifica a los componentes interesados

Los componentes reaccionan sin conocerse entre sí.

---

##  Características

- Arquitectura desacoplada
- Comunicación basada en eventos
- Procesos asíncronos (barra y cocina trabajan en paralelo)
- Uso de genéricos en el EventBus
- Sistema fácil de extender

---

##  Arquitectura

- `bus` → EventBus y manejo de eventos
- `eventos` → Clases de eventos
- `componentes` → Lógica del sistema
- `main` → Ejecución del programa

---

##  Ejecución

1. Abrir el proyecto en IntelliJ
2. Usar Java 17 o superior
3. Ejecutar `Main.java`

---

##  Resultado esperado

En consola se verá:

- La banda tocando canciones
- Preparación de bebidas y comida
- Mensajes del panel LED
- Procesos ejecutándose en paralelo
- Activación del sistema de humo en momentos específicos

---

##  Flujo del sistema

1. Se crea un pedido
2. El EventBus lo distribuye
3. Barra y cocina procesan en paralelo
4. Se generan nuevos eventos
5. Otros componentes reaccionan

---

##  Extensibilidad

Se agregó el componente:

- **SistemaDeHumo**

Este reacciona a eventos de la banda sin modificar código existente.

---

##  Autor

Diego Erik Alfonso Montoya  
Ingeniería en Computación

---

##  Nota

Proyecto académico para demostrar el uso de arquitectura basada en eventos.