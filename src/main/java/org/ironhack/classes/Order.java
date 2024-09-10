package org.ironhack.classes;

import org.ironhack.enums.OrderStatus;

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

        if (isSameStatus(status)){
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
}
