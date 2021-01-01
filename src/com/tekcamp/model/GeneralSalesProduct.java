package com.tekcamp.model;

public class GeneralSalesProduct extends Product implements IGeneralSalesTax {

    public GeneralSalesProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public double getSalesTax() {
        return this.getPrice() * GENERAL_SALES_TAX_MULTIPLIER;
    }
}
