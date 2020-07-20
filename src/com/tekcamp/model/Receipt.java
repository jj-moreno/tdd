package com.tekcamp.model;

import com.tekcamp.program.SalesCalculator;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<ProductLineItem> productLineItems = new ArrayList<>();
    private double totalSalesTax;
    private double totalPrice;

    private ShoppingBasket shoppingBasket;
    private SalesCalculator salesCalculator;

    public Receipt(ShoppingBasket shoppingBasket) {
        String lineItemName;
        double lineItemProductTotalPriceIncludingTax;
        this.shoppingBasket = shoppingBasket;
        salesCalculator = SalesCalculator.getInstance();
        for (Product product : this.shoppingBasket.getProducts()) {
            lineItemName = product.getName();
            lineItemProductTotalPriceIncludingTax = salesCalculator.getTotalProductPriceIncludingTax(product);
            productLineItems.add(new ProductLineItem(lineItemName, lineItemProductTotalPriceIncludingTax));
        }
        this.totalSalesTax = salesCalculator.getTotalSalesTaxFromShoppingBasket(shoppingBasket);
        this.totalPrice = salesCalculator.getTotalPriceFromShoppingBasket(shoppingBasket);
    }

    public List<ProductLineItem> getProductLineItems() {
        return productLineItems;
    }

    public double getTotalSalesTax() {
        return totalSalesTax;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
