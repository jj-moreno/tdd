package com.tekcamp.program;

import com.tekcamp.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void totalProductPriceIncludingTax() {
        Product product = new ExemptSalesProduct("book", 12.49);
        double totalProductPriceIncludingTax = salesCalculator.getTotalProductPriceIncludingTax(product);
        assertEquals(12.49, totalProductPriceIncludingTax);

        product = new GeneralSalesProduct("music CD", 14.99);
        totalProductPriceIncludingTax = salesCalculator.getTotalProductPriceIncludingTax(product);
        assertEquals(16.49, totalProductPriceIncludingTax);

        product = new ImportedGeneralSalesProduct("imported bottle of perfume", 47.50);
        totalProductPriceIncludingTax = salesCalculator.getTotalProductPriceIncludingTax(product);
        assertEquals(54.65, totalProductPriceIncludingTax);
    }

    @Test
    public void totalSalesTaxFromShoppingBasket() {
        List<Product> products = Arrays.asList(
                new ExemptSalesProduct("book", 12.49),
                new GeneralSalesProduct("music CD", 14.99),
                new ExemptSalesProduct("chocalate bar", 0.85));
        ShoppingBasket shoppingBasket = new ShoppingBasket(products);
        double totalSalesTaxFromShoppingBasket = salesCalculator.getTotalSalesTaxFromShoppingBasket(shoppingBasket);
        assertEquals(1.50, totalSalesTaxFromShoppingBasket);

        products = Arrays.asList(
                new ImportedExemptSalesProduct("imported box of chocolates", 10.00),
                new ImportedGeneralSalesProduct("imported bottle of perfume", 47.50)
        );
        shoppingBasket = new ShoppingBasket(products);
        totalSalesTaxFromShoppingBasket = salesCalculator.getTotalSalesTaxFromShoppingBasket(shoppingBasket);
        assertEquals(7.65, totalSalesTaxFromShoppingBasket);
    }

    @Test
    public void totalSalesPriceFromShoppingBasket() {
        ShoppingBasket shoppingBasket = new ShoppingBasket(Arrays.asList(
                new ExemptSalesProduct("book", 12.49),
                new GeneralSalesProduct("music CD", 14.99),
                new ExemptSalesProduct("chocalate bar", 0.85)));
        double totalPriceFromShoppingBasket = salesCalculator.getTotalPriceFromShoppingBasket(shoppingBasket);
        assertEquals(29.83, totalPriceFromShoppingBasket);

    }

}
