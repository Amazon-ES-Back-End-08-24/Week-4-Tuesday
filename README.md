# Week 4
- [Introducción a Enums, HashMaps, y UML](#introducción-a-enums-hashmaps-y-uml)
   - [Enums](#enums)
      - [Ejemplo en código](#ejemplo-en-código)
      - [Ejercicio con Enums](#ejercicio-con-enums)
   - [HashMaps](#hashmaps)
      - [¿Cuándo usar HashMaps?](#cuándo-usar-hashmaps)
      - [Métodos clave de un HashMap](#métodos-clave-de-un-hashmap)
      - [Ejemplo en código](#ejemplo)
      - [Ejercicio Práctico con HashMap](#ejercicio-práctico-con-hashmap-sistema-de-puntuación-en-un-videojuego)


# Introducción a Enums, HashMaps, y UML

## Enums

**Enums** (enumeraciones) en Java permiten definir un conjunto fijo de constantes, facilitando la legibilidad y seguridad en el código.

### Ejemplo en código:
```java
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

public class TestEnum {
    public static void main(String[] args) {
        Day today = Day.WEDNESDAY;

        if (today == Day.WEDNESDAY) {
            System.out.println("It's midweek!");
        }
    }
}
```
---

### Ejercicio con Enums:

1. Crea un **enum** llamado `OrderStatus` que contenga los siguientes estados: `PENDING`, `PROCESSING`, `SHIPPED`, `DELIVERED`, `CANCELLED`.
2. Crea una clase `Order` que contenga los siguientes atributos:
    - `int orderId`
    - `String productName`
    - `double price`
    - `OrderStatus status`
3. Implementa métodos en la clase `Order` para:
    - Cambiar el estado del pedido (`updateStatus(OrderStatus newStatus)`).
    - Mostrar el resumen del pedido (`printOrderDetails()`).

4. Escribe un programa principal que:
    - Cree tres instancias de la clase `Order` con distintos productos.
    - Cambie el estado de los pedidos utilizando el **enum**.
    - Muestre los detalles de cada pedido en su estado actual.
---

## HashMaps

Un **HashMap** en Java es una estructura de datos que almacena pares clave-valor y permite realizar búsquedas, inserciones y eliminaciones de manera rápida utilizando una clave única.

### ¿Cuándo usar HashMaps?

- **Útil**: cuando necesitas almacenar y acceder a datos rápidamente mediante una clave única. Por ejemplo, en un sistema de usuarios, podrías almacenar el ID del usuario como clave y el nombre del usuario como valor.
- **No es útil**: cuando necesitas mantener el orden de los elementos (por ejemplo, cuando el orden de inserción es importante) o si necesitas permitir duplicados en las claves (en un HashMap, las claves deben ser únicas).

### Métodos clave de un HashMap:

1. **put(K key, V value)**: Inserta o actualiza un par clave-valor en el HashMap.
2. **get(Object key)**: Busca un valor utilizando una clave.
3. **remove(Object key)**: Elimina un par clave-valor asociado a una clave específica.
4. **containsKey(Object key)**: Verifica si el mapa contiene una clave específica.
5. **keySet()**: Devuelve un conjunto con todas las claves en el HashMap.

### Ejemplo:

```java
import java.util.HashMap;

public class TestHashMap {
    public static void main(String[] args) {
        // Crear un HashMap
        HashMap<String, Integer> scores = new HashMap<>();

        // Agregar elementos al HashMap con el método put()
        scores.put("Alice", 90);
        scores.put("Bob", 85);
        scores.put("Charlie", 95);

        // Obtener el valor de una clave con el método get()
        System.out.println("Bob's score: " + scores.get("Bob"));

        // Actualizar el valor de una clave existente
        scores.put("Alice", 95); // El puntaje de Alice se actualiza a 95
        System.out.println("Updated Alice's score: " + scores.get("Alice"));

        // Eliminar un elemento con el método remove()
        scores.remove("Charlie");
        System.out.println("Charlie's score removed.");

        // Verificar si una clave existe con containsKey()
        if (scores.containsKey("Bob")) {
            System.out.println("Bob's score is in the map.");
        }

        // Iterar sobre el HashMap con keySet()
        System.out.println("All scores:");
        for (String key : scores.keySet()) {
            System.out.println(key + ": " + scores.get(key));
        }
    }
}
```

### Ejercicio Práctico con HashMap: Sistema de Puntuación en un Videojuego

1. Crea un **HashMap** llamado `scoreboard` que almacene jugadores. Las **claves** del HashMap serán los nombres de los jugadores (tipo `String`) y los **valores** serán las puntuaciones (tipo `Integer`).
2. Implementa las siguientes funciones en uns clase llamada `ScoreManager`:
    - `addPlayer(String playerName, int score)`: Agrega un nuevo jugador al marcador con su puntuación inicial o actualiza la puntuación si el jugador ya existe.
    - `updateScore(String playerName, int newScore)`: Actualiza la puntuación de un jugador específico.
    - `checkScore(String playerName)`: Consulta la puntuación de un jugador en el marcador e imprime el resultado.
    - `printAllScores()`: Imprime todos los jugadores con sus puntuaciones en el marcador.

3. Escribe un programa principal que:
    - Crea una instancia de `ScoreManager`.
    - Añade varios jugadores al marcador.
    - Actualizalas puntuaciones de algunos jugadores.
    - Consulta la puntuación de algunos jugadores.
    - Imprime el estado completo del marcador.

