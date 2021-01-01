package com.tekcamp.program;

import com.tekcamp.model.ShoppingBasket;
import com.tekcamp.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesCalculator {

    private static SalesCalculator salesCalculator = new SalesCalculator();
    private static ISalesRounder iSalesRounder = new RoundSalesNearestNickle();

    private SalesCalculator() {
    }

    public static SalesCalculator getInstance() {
        return salesCalculator;
    }

    public double getProductSalesTax(Product product) {
        double salesTaxToNearestNickle = iSalesRounder.roundPrice(product.getSalesTax());
        return salesTaxToNearestNickle;
    }

    public double getTotalProductPriceIncludingTax(Product product) {
        double totalProductPriceIncludingTax = product.getPrice() + this.getProductSalesTax(product);
        return iSalesRounder.roundTwoDecimalPlaces(totalProductPriceIncludingTax);
    }

    public double getTotalSalesTaxFromShoppingBasket(ShoppingBasket shoppingBasket) {
        double totalSalesTax = 0.0;
        for (Product product : shoppingBasket.getProducts()) {
            totalSalesTax += this.getProductSalesTax(product);
        }
        return iSalesRounder.roundTwoDecimalPlaces(totalSalesTax);
    }


    public double getTotalPriceFromShoppingBasket(ShoppingBasket shoppingBasket) {
        double totalPrice = 0.0;
        for (Product product : shoppingBasket.getProducts()) {
            totalPrice += this.getTotalProductPriceIncludingTax(product);
        }
        return iSalesRounder.roundTwoDecimalPlaces(totalPrice);
    }
}
