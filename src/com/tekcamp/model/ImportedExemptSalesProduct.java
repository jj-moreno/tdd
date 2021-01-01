package com.tekcamp.model;

public class ImportedExemptSalesProduct extends Product implements IExemptSalesTax, IImportedSalesTax{

    public ImportedExemptSalesProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public double getSalesTax() {
        double exemptSalesTax = super.getPrice() * EXEMPT_SALES_TAX_MULTIPLIER;
        double importSalesTax = super.getPrice() * IMPORTED_SALES_TAX_MULTIPLIER;
        return exemptSalesTax + importSalesTax;
    }
}
