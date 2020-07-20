package com.tekcamp.model;

import java.util.List;

public class ShoppingBasket {
    private List<Product> products;

    public ShoppingBasket(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

}
