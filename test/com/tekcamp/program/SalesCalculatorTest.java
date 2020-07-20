package com.tekcamp.program;

import com.tekcamp.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SalesCalculatorTest {

    SalesCalculator salesCalculator;

    @BeforeEach
    public void setup() {
        salesCalculator = SalesCalculator.getInstance();
    }

    @Test
    public void salesTaxTenPercentAppliedForGeneralSalesProducts() {
        Product product = new GeneralSalesProduct("music CD", 14.99);
        double productSalesTax = salesCalculator.getProductSalesTax(product);
        assertEquals(1.5, productSalesTax);
    }

    @Test
    public void salesTaxTenPercentNotAppliedForExemptSalesProducts() {
        Product product = new ExemptSalesProduct("book", 12.49);
        double productSalesTax = salesCalculator.getProductSalesTax(product);
        assertEquals(0.0, productSalesTax);

        product = new ExemptSalesProduct("chocolate bar", 0.85);
        productSalesTax = salesCalculator.getProductSalesTax(product);
        assertEquals(0.0, productSalesTax);
    }

    @Test
    public void additionalSalesTaxFivePercentAppliedForImportedExemptSalesProducts() {
        Product product = new ImportedExemptSalesProduct("imported box of chocolates", 10.00);
        double productSalesTax = salesCalculator.getProductSalesTax(product);
        assertEquals(0.50, productSalesTax);
    }

    @Test
    public void additionalSalesTaxFivePercentAppliedForImportedGeneralSalesProducts() {
        Product product = new ImportedGeneralSalesProduct("imported bottle of perfume", 47.50);
        double productSalesTax = salesCalculator.getProductSalesTax(product);
        assertEquals(7.15, productSalesTax);
    }


}
