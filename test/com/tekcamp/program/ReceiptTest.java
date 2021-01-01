package com.tekcamp.program;

import com.tekcamp.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptTest {
    ShoppingBasket shoppingBasket;
    Receipt receipt;

    @BeforeEach
    public void setup() {
        shoppingBasket = new ShoppingBasket(Arrays.asList(
                new ImportedGeneralSalesProduct("imported bottle of perfume", 27.99),
                new GeneralSalesProduct("bottle of perfume", 18.99),
                new ExemptSalesProduct("packet of headache pills", 9.75),
                new ImportedExemptSalesProduct("box of imported chocolates", 11.25)
        ));
        receipt = new Receipt(shoppingBasket);
    }


    @Test
    public void productLineItem() {
        ProductLineItem productLineItem = new ProductLineItem(receipt.getProductLineItems().get(0).getName(), receipt.getProductLineItems().get(0).getPrice());
        assertEquals("imported bottle of perfume", productLineItem.getName());
        assertEquals(32.19, productLineItem.getPrice());

        productLineItem = new ProductLineItem(receipt.getProductLineItems().get(1).getName(), receipt.getProductLineItems().get(1).getPrice());
        assertEquals("bottle of perfume", productLineItem.getName());
        assertEquals(20.89, productLineItem.getPrice());

        productLineItem = new ProductLineItem(receipt.getProductLineItems().get(2).getName(), receipt.getProductLineItems().get(2).getPrice());
        assertEquals("packet of headache pills", productLineItem.getName());
        assertEquals(9.75, productLineItem.getPrice());

        productLineItem = new ProductLineItem(receipt.getProductLineItems().get(3).getName(), receipt.getProductLineItems().get(3).getPrice());
        assertEquals("box of imported chocolates", productLineItem.getName());
        assertEquals(11.85, productLineItem.getPrice());
    }

    @Test
    public void totalSalesTax() {
        double totalSalesTax = receipt.getTotalSalesTax();
        assertEquals(6.70, totalSalesTax);
    }

    @Test
    public void totalPrice() {
        double totalPrice = receipt.getTotalPrice();
        assertEquals(74.68, totalPrice);
    }

}
