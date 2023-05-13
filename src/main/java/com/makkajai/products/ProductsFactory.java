package com.makkajai.products;

public class ProductsFactory {
    public Product getProductFromFactory(String receiptName) {
        if (receiptName.contains("chocolate")) {
            return new Food(receiptName);
        }
        if (receiptName.contains("pill")) {
            return new Food(receiptName);
        }
        if (receiptName.contains("book")) {
            return new Book(receiptName);
        }
        return new Other(receiptName);
    }
}
