package com.tekcamp.program;

import com.tekcamp.model.*;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ConsoleReceiptPrinter consoleReceiptPrinter = ConsoleReceiptPrinter.getInstance();

        List<Product> productsList1 = Arrays.asList(
                new ExemptSalesProduct("book", 12.49),
                new GeneralSalesProduct("music CD", 14.99),
                new ExemptSalesProduct("chocalate bar", 0.85));
        ShoppingBasket shoppingBasket1 = new ShoppingBasket(productsList1);
        Receipt receipt1 = new Receipt(shoppingBasket1);

        consoleReceiptPrinter.printReceipt(receipt1);

        List<Product> productsList2 = Arrays.asList(
                new ImportedExemptSalesProduct("imported box of chocolates", 10.00),
                new ImportedGeneralSalesProduct("imported bottle of perfume", 47.50)
        );
        ShoppingBasket shoppingBasket2 = new ShoppingBasket(productsList2);
        Receipt receipt2 = new Receipt(shoppingBasket2);
        consoleReceiptPrinter.printReceipt(receipt2);


        List<Product> productsList3 = Arrays.asList(
                new ImportedGeneralSalesProduct("imported bottle of perfume", 27.99),
                new GeneralSalesProduct("bottle of perfume ", 18.99),
                new ExemptSalesProduct("packet of headache pills", 9.75),
                new ImportedExemptSalesProduct("box of imported chocolates ", 11.25)
        );
        ShoppingBasket shoppingBasket3 = new ShoppingBasket(productsList3);
        Receipt receipt3 = new Receipt(shoppingBasket3);
        consoleReceiptPrinter.printReceipt(receipt3);

    }
}
