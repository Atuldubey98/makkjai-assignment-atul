package com.makkajai.products;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.makkajai.tax.TaxCalculator;

public class Cart {
    private List<Product> products;

    private TaxCalculator taxCalculator;

    public TaxCalculator getTaxCalculator() {
        return taxCalculator;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Cart(String productsReceipts) {
        this.products = Arrays.stream(productsReceipts.split("\n")).map(String::trim)
                .map(receiptName -> new ReceiptProductMapper(receiptName).mapDTOToProduct())
                .collect(Collectors.toList());
    }
}
