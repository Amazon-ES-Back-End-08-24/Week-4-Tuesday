package org.ironhack.classes;

import org.ironhack.enums.OrderStatus;

import java.util.Objects;

public class Order {
    private int orderId;
    private String productName;
    private double price;
    private OrderStatus status;

    public Order(int orderId, String productName, double price, OrderStatus status) {
        this.orderId = orderId;
        this.productName = productName;
        this.price = price;
        this.status = status;
    }

    public Order(int orderId, String productName, double price) {
        this.orderId = orderId;
        this.productName = productName;
        this.price = price;
        this.status = OrderStatus.PENDING;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void updateStatus(OrderStatus status) {

        if (isSameStatus(status)) {
            System.out.println();
        }

        this.status = status;
    }

    private boolean isSameStatus(OrderStatus status) {
        boolean isSameStatus = status == this.status;
        return isSameStatus;
    }

    public void printOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Product: " + productName);
        System.out.println("Price : " + price + " $");
        System.out.println("Current status: " + status);
        System.out.println("-------------");
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }

    // PARA VERIFICAR EL FUNCIONAMIENTO DE EQUALS COMENTAR ESTE MÉTODO:
    // verifica si dos objetos son iguales
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // order.equals(order); ESTO SERÁ TRUE
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return orderId == order.orderId && Double.compare(price, order.price) == 0 && Objects.equals(productName, order.productName) && status == order.status;
    }

    // int que indica en qué cubo del HashMap se almacena una clave
    @Override
    public int hashCode() {
        return Objects.hash(orderId, productName, price, status);
    }
}
