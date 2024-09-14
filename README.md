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
      - [Explicación del comportamiento de las claves en HashMap](#explicación-del-comportamiento-de-las-claves-en-hashmap)
      - [Ejemplo Incorrecto equals y hashcode](#ejemplo-incorrecto-clase-product-sin-equals-y-hashcode)
      - [¿Por qué a veces usamos Map en lugar de HashMap?](#por-qué-a-veces-usamos-map-en-lugar-de-hashmap)
      - [¿Por qué a veces usamos List en lugar de ArrayList?](#por-qué-a-veces-se-usa-list-en-lugar-de-arraylist)
  - [UML](#uml-diagramas-de-casos-de-uso-y-diagramas-de-clase)
     - [Diagramas de caso de uso](#diagrama-de-casos-de-uso)
     - [Diagramas de clase](#diagrama-de-clase)
  - [Ejercicio práctico con enums, hashMaps y uml](#ejercicio-práctico-trabajo-con-enums-hashmaps-y-uml)
     - [Descripción](#descripción-de-la-tarea)
     - [Desafíos adicionales](#desafíos-adicionales-si-el-tiempo-lo-permite)

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

---
### Explicación del comportamiento de las claves en HashMap

Cuando se usa un **HashMap**, es importante que los objetos utilizados como claves implementen correctamente los métodos `equals()` y `hashCode()`. Estos métodos son fundamentales para el correcto funcionamiento de un HashMap porque influyen en cómo se almacenan y comparan las claves en la tabla hash.

#### **hashCode()**
El método `hashCode()` genera un número entero (valor hash) que se utiliza para determinar en qué "cubo" o posición en la tabla hash se almacenará un par clave-valor. El HashMap utiliza este valor para buscar rápidamente la clave correspondiente.

- **Importante**: Todas las claves que son iguales según `equals()` deben generar el mismo valor hash. Si dos claves tienen valores hash diferentes, se almacenan en diferentes cubos. Si tienen el mismo valor hash, podrían terminar en el mismo cubo, lo que requiere una verificación adicional usando el método `equals()`.

- **Analogía sencilla**: Imagina que tienes una caja organizadora con varias divisiones (cubos). El valor hash actúa como un índice que te indica en qué división guardar un objeto. Si el valor hash es único, cada objeto va a su propia división. Si dos objetos diferentes terminan en la misma división, tendrás que abrir la caja y mirar más de cerca para ver cuál es cuál, usando `equals()`.

#### **equals()**
El método `equals()` se utiliza para comparar dos objetos y determinar si son equivalentes. Esto es crucial en caso de **colisiones**, cuando dos claves diferentes producen el mismo valor hash y terminan en el mismo cubo.

- Si los valores hash de dos claves coinciden, el HashMap usa `equals()` para determinar si las claves son verdaderamente iguales o si simplemente tienen el mismo valor hash.
- Si `equals()` devuelve `true`, se considera que las claves son iguales y el nuevo valor reemplaza al anterior. Si `equals()` devuelve `false`, ambas claves pueden coexistir en el mismo cubo, pero como claves separadas.

### Resumen:

- **hashCode()**: Genera un número que indica en qué cubo del HashMap se debe almacenar una clave.
- **equals()**: Verifica si dos claves son iguales, especialmente cuando ocurren colisiones (cuando dos claves tienen el mismo valor hash).

En resumen, ambos métodos son cruciales para el rendimiento y el correcto funcionamiento de un HashMap, ya que aseguran que los elementos se almacenen y recuperen correctamente, incluso cuando dos claves puedan producir el mismo valor hash.

### Ejemplo Incorrecto: Clase `Product` sin `equals()` y `hashCode()`

Ahora veremos qué ocurre cuando `equals()` y `hashCode()` no están implementados, lo cual impide que `HashMap` gestione correctamente las instancias de `Product` como claves.

#### Definición de la Clase `Product` Sin Métodos Apropiados

```java
public class Product {
    private String id;
    private String name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Sin equals() y hashCode()
}
```

#### Uso en `HashMap`

```java
import java.util.HashMap;

public class InventoryManager {
    public static void main(String[] args) {
        HashMap<Product, Integer> inventory = new HashMap<>();
        Product product1 = new Product("101", "Coffee Mug");

        // Agregamos el producto al inventario con una cantidad inicial
        inventory.put(product1, 150);

        // Intentamos recuperar la cantidad usando una nueva instancia con el mismo ID
        Product sameProduct = new Product("101", "Coffee Mug");
        System.out.println("Inventory count for product ID 101: " + inventory.get(sameProduct));  // Esto imprimirá 'null'
    }
}
```

### Explicación del Fallo

En el ejemplo incorrecto, `product1` y `sameProduct` tienen el mismo `id` y nombre, pero como los métodos `equals()` y `hashCode()` no están definidos, el `HashMap` los trata como si fueran completamente diferentes. Esto significa que al intentar recuperar la cantidad de `sameProduct`, el resultado es `null` porque el `HashMap` no puede encontrar una entrada para la nueva instancia de `Product`, a pesar de que tiene el mismo ID que `product1`.

---

### ¿Por qué a veces usamos `Map` en lugar de `HashMap`?

En muchos casos, verás que se usa la interfaz **Map** en lugar de la clase concreta **HashMap**. Esto es una buena práctica de diseño orientado a interfaces en Java. Las diferencias clave son las siguientes:

- **Map** es una interfaz que define los comportamientos generales de una estructura de datos de tipo mapa, como almacenar pares clave-valor y realizar operaciones como `put()`, `get()`, `remove()`, etc.
- **HashMap** es una implementación específica de **Map** que utiliza una tabla hash para almacenar los pares clave-valor.

#### Ventajas de usar `Map` en lugar de `HashMap`:
1. **Flexibilidad**: Al declarar una variable como `Map<K, V>` en lugar de `HashMap<K, V>`, puedes cambiar fácilmente la implementación a otro tipo de `Map` (como `TreeMap` o `LinkedHashMap`) sin modificar el resto del código.

   ```java
   Map<String, Integer> myMap = new HashMap<>();
   ```

   Esto es útil porque, si decides más adelante que otra implementación de mapa es más adecuada (por ejemplo, `TreeMap` para mantener un orden de las claves), puedes cambiar la declaración sin afectar otras partes de tu código.

2. **Polimorfismo**: Usar la interfaz te permite aplicar principios de polimorfismo. Si pasas un objeto que implementa `Map` a un método, ese método puede trabajar con diferentes tipos de mapas (HashMap, TreeMap, etc.) sin necesidad de saber la implementación específica.

En resumen, usar la interfaz **Map** promueve la flexibilidad, el desacoplamiento (es un principio de diseño de software que se refiere a la reducción de las dependencias directas entre las diferentes partes de un sistem) y el polimorfismo en el diseño del código.

---

### ¿Por qué a veces se usa `List` en lugar de `ArrayList`?

De manera similar a **Map** y **HashMap**, en muchos casos verás que se usa la interfaz **List** en lugar de una implementación concreta como **ArrayList**. Aquí las razones son similares:

- **List** es una interfaz que define un contrato para las operaciones que una lista debe proporcionar, como agregar, eliminar, obtener elementos por índice, etc.
- **ArrayList** es una implementación específica de **List** que utiliza un arreglo dinámico como estructura subyacente.

#### Ventajas de usar `List` en lugar de `ArrayList`:
1. **Intercambiabilidad**: Si declaras una lista como `List`, puedes cambiar la implementación fácilmente a otra clase que implemente la interfaz `List`, como **LinkedList** o **Vector**, sin cambiar el resto del código.

   ```java
   List<String> myList = new ArrayList<>();
   ```

   Esto es útil si decides más adelante que una **LinkedList** (que es más eficiente para inserciones/eliminaciones en el medio de la lista) sería mejor para tu caso de uso.

2. **Polimorfismo**: Al usar la interfaz `List`, puedes aprovechar el polimorfismo y pasar cualquier implementación de `List` a un método sin preocuparte por la implementación específica que se utiliza. Esto permite escribir código más flexible y reutilizable.

3. **Mejores prácticas**: En general, en Java se recomienda programar hacia interfaces (como `List`, `Map`, `Set`), ya que esto te permite cambiar las implementaciones subyacentes sin afectar el código que usa esas estructuras.

### Diferencias entre `ArrayList` y `LinkedList` (las dos implementaciones comunes de `List`):

- **ArrayList**: Utiliza un arreglo dinámico. Es eficiente para acceder a elementos por índice (operación `O(1)`), pero puede ser costoso al insertar o eliminar elementos, ya que puede requerir que se desplacen elementos en el arreglo.

- **LinkedList**: Utiliza una lista doblemente enlazada. Es más eficiente para insertar o eliminar elementos en el medio o al principio de la lista (operación `O(1)` para agregar al inicio o fin), pero es menos eficiente para acceder a elementos por índice (operación `O(n)`).

En resumen, **List** ofrece la flexibilidad de cambiar entre diferentes implementaciones de listas, mientras que **ArrayList** es una implementación específica que es más eficiente en ciertos casos (como acceso aleatorio rápido).

### Resumen:

- Usamos la interfaz **Map** en lugar de la implementación específica **HashMap** para lograr flexibilidad y permitir el uso de diferentes implementaciones de mapas sin modificar el código.
- De manera similar, usamos **List** en lugar de **ArrayList** para aprovechar la flexibilidad y el polimorfismo, lo que permite intercambiar implementaciones como **LinkedList** o **ArrayList** según sea necesario.

---

### UML (Diagramas de Casos de Uso y Diagramas de Clase)

#### ¿Qué es UML?
**UML (Unified Modeling Language)** es un lenguaje visual que se utiliza para modelar y documentar sistemas de software. Ayuda a visualizar el diseño y comportamiento de un sistema antes de comenzar la implementación.

#### Diagrama de Casos de Uso
Un **diagrama de casos de uso** muestra cómo interactúan los usuarios (actores) con un sistema, representando las funciones principales del sistema desde una perspectiva de alto nivel.

#### Ejemplo de un diagrama de casos de uso:
- **Actores**: Cliente, Administrador
- **Casos de uso**: Hacer pedido, Cancelar pedido, Modificar perfil

**Utilidad**: Facilita la comprensión de las interacciones entre usuarios y el sistema, permitiendo *definir claramente las funcionalidades necesarias*.

---

#### Diagrama de Clase
Un **diagrama de clase** muestra la estructura del sistema, representando las clases, sus atributos, métodos y las relaciones entre ellas (herencia, asociación, etc.).

#### Ejemplo de un diagrama de clase:
- **Clases**: `Usuario`, `Libro`, `Biblioteca`
- **Relaciones**: Un `Usuario` puede pedir muchos `Libros`; una `Biblioteca` contiene muchos `Libros`.

**Utilidad**: Proporciona una visión detallada de cómo se estructuran las entidades en un sistema, ayudando en el diseño de la arquitectura del software.

---

### Notas Importantes
- **Enums** permiten representar estados o valores limitados y constantes.
- **HashMaps** ofrecen una manera eficiente de almacenar datos en pares clave-valor, permitiendo búsquedas rápidas.
- **Los diagramas UML** ayudan a visualizar la arquitectura y comportamiento de un sistema antes de desarrollarlo, promoviendo un diseño claro y organizado.

---

## Ejercicio Práctico: Trabajo con Enums, HashMaps, y UML

### Descripción de la Tarea:
1. Define un **enum** para representar los estados de un ticket de soporte (`OPEN`, `IN_PROGRESS`, `RESOLVED`).
2. Usa un **HashMap** para almacenar y consultar tickets de soporte, utilizando el número de ticket como clave y el estado del ticket como valor.
3. Dibuja un **diagrama de clase UML** para modelar el sistema de tickets de soporte, con clases como `Ticket`, `Cliente`, y `Soporte`.

### Desafíos Adicionales (si el tiempo lo permite):
- Implementa funciones para cambiar el estado de un ticket y mostrar todos los tickets que están abiertos.
- Dibuja un **diagrama de casos de uso UML** que represente las interacciones entre un cliente y el sistema de soporte.

---