package com.tekcamp.program;

import com.tekcamp.model.Product;

public class SalesCalculator {

    private static SalesCalculator salesCalculator = new SalesCalculator();
    private static IPriceRounder iPriceRounder = new RoundPriceNearestNickle();

    private SalesCalculator() { }

    public static SalesCalculator getInstance() {
        return salesCalculator;
    }

    public double getProductSalesTax(Product product) {
        double salesTaxToNearestNickle = iPriceRounder.roundPrice(product.getSalesTax());
        return salesTaxToNearestNickle;
    }
}
