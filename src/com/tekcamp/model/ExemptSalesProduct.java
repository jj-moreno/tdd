package com.tekcamp.model;

public class ExemptSalesProduct extends Product implements IExemptSalesTax {

    public ExemptSalesProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public double getSalesTax() {
        return this.getPrice() * EXEMPT_SALES_TAX_MULTIPLIER;
    }
}
