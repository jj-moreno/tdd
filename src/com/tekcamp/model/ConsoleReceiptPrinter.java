package com.tekcamp.model;

public class ConsoleReceiptPrinter implements  IReceiptPrinter{
    private static ConsoleReceiptPrinter consoleReceiptPrinter = new ConsoleReceiptPrinter();

    private ConsoleReceiptPrinter() {}

    public static ConsoleReceiptPrinter getInstance() {
        return consoleReceiptPrinter;
    }

    @Override
    public void printReceipt(Receipt receipt) {

        for (ProductLineItem productLineItem : receipt.getProductLineItems()) {
            System.out.printf("1 %s: %.2f\n\n", productLineItem.getName(), productLineItem.getPrice());
        }
        System.out.printf("Sales Taxes: %.2f Total: %.2f\n\n", receipt.getTotalSalesTax(), receipt.getTotalPrice());

    }
}
