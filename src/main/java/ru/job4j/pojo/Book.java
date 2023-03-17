package ru.job4j.pojo;

public class Book {
    private String name;
    private int quantity;

    public Book(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
