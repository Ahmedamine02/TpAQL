package org.example;

public class Order {
    private String id;
    private String product;
    private int quantity;

    public Order(String id, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    // Getters
    public String getId() { return id; }
    public String getProduct() { return product; }
    public int getQuantity() { return quantity; }

    // toString(), equals(), hashCode(), etc. si besoin
}
