package com.tekcamp.model;

public class ProductLineItem {
    private String name;
    private double price;

    public ProductLineItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
