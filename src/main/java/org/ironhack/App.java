package org.ironhack;

import org.ironhack.classes.Order;
import org.ironhack.classes.Product;
import org.ironhack.classes.Role;
import org.ironhack.classes.ScoreManager;
import org.ironhack.enums.Day;
import org.ironhack.enums.OrderStatus;
import org.ironhack.enums.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) {
        // enumExample();
        // enumExercise();

        // hashMapExample();
        // hashMapExercise();

        // equalsExample();
        // equalsAndHashcodeExample();


        List<String> names = new ArrayList<>();
    }

    private static void enumExample() {
        Day today = Day.SATURDAY;

        if (today == Day.TUESDAY || today == Day.SATURDAY) {
            System.out.println("We have back-end class today!");
        } else {
            System.out.println("Practice some Java");
        }

        User user = new User(91, "Lorenzo", "password", Role.ADMIN);
        System.out.println(user.getUserRole());
    }

    private static void enumExercise() {
        Order order = new Order(1, "Iphone", 1200.99);
        Order order1 = new Order(2, "Laptop", 1500);
        Order order2 = new Order(3, "Hat", 17.13);

        order.printOrderDetails();
        order1.printOrderDetails();
        order2.printOrderDetails();

        order.updateStatus(OrderStatus.CANCELLED);
        order1.updateStatus(OrderStatus.SHIPPED);
        order2.updateStatus(OrderStatus.PROCESSING);

        order.printOrderDetails();
        order1.printOrderDetails();
        order2.printOrderDetails();
    }

    private static void hashMapExample() {
        // Hashmaps almacena pares clave-valor -> la clave debe ser ÚNICA - key-value

        HashMap<String, Integer> scores = new HashMap<>();

        // insertar o actualizar un par clave-valor en el hashmap
        scores.put("Alice", 90);
        scores.put("Bob", 85);
        scores.put("Charlie", 95);

        // busca en el hasmap un valor a través de la clave
        System.out.println("Bob's score " + scores.get("Bob"));

        scores.put("Alice", 95);
        System.out.println("Alice's score " + scores.get("Alice"));

        System.out.println("Does Charlie's score still exist? " + scores.containsKey("Charlie"));

        scores.remove("Charlie");
        System.out.println("Charlie's score " + scores.get("Charlie"));

        System.out.println("Does Charlie's score still exist? " + scores.containsKey("Charlie"));

        System.out.println(scores.keySet());
    }

    private static void hashMapExercise() {
        ScoreManager scoreManager = new ScoreManager();

        scoreManager.addPlayer("Alice", 100);
        scoreManager.addPlayer("Alice", 100); // duplicado para tirar error
        scoreManager.addPlayer("Bob", 150);
        scoreManager.addPlayer("Charlie", 200);

        scoreManager.checkScore("Bob");
        scoreManager.checkScore("Test"); // para ver el mensaje de error

        scoreManager.updateScore("Test 2", 180); // para ver el mensaje de error
        scoreManager.updateScore("Alice", 180);

        scoreManager.checkScore("Alice");

        scoreManager.printAllScores();
    }

    private static void equalsExample() {
        Order order = new Order(1, "Iphone", 1200.99);
        Order order1 = new Order(1, "Iphone", 1200.99);

        System.out.println(order.toString());
        System.out.println(order1.toString());

        System.out.println(order.getClass());
        System.out.println(order.equals(order1));
    }

    private static void equalsAndHashcodeExample() {
        Map<Product, Integer> inventory = new HashMap<>();

        Product product1 = new Product("101", "Coffee Mug");

        inventory.put(product1, 150);

        // para verificar el funcionamiento de equals & hashcode
        Product sameProduct = new Product("101", "Coffee Mug");

        Integer productInventory = inventory.get(sameProduct);

        System.out.println("Inventory count for product Id 101 Coffee Mug " + productInventory);
    }
}
