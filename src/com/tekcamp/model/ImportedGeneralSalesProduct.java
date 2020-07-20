package com.tekcamp.model;

public class ImportedGeneralSalesProduct extends Product implements IGeneralSalesTax, IImportedSalesTax{

    public ImportedGeneralSalesProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public double getSalesTax() {
        double generalSalesTax = super.getPrice() * GENERAL_SALES_TAX_MULTIPLIER;
        double importSalesTax = super.getPrice() * IMPORTED_SALES_TAX_MULTIPLIER;
        return generalSalesTax + importSalesTax;
    }
}
