package com.makkajai.products;

import java.util.ArrayList;
import java.util.List;

import com.makkajai.tax.TaxCalculator;

public class Cart {
    private List<Product> products;
    private ProductsFactory productsFactory;
    private TaxCalculator taxCalculator;

    public TaxCalculator getTaxCalculator() {
        return taxCalculator;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Cart(String productsReceipts) {
        this.productsFactory = new ProductsFactory();
        this.products = new ArrayList<>();
        this.initilizeCart(productsReceipts);
    }

    private void initilizeCart(String productsReceipts) {
        String productRecs[] = productsReceipts.split("\n");
        for (String productRec : productRecs) {
            this.products.add(this.productsFactory.getProductFromFactory(productRec));
        }
    }

    @Override
    public String toString() {
        StringBuilder productsReceipt = new StringBuilder("");
        for (int i = 0; i < products.size(); i++) {
            productsReceipt.append(i == products.size() - 1 ? products.get(i) : products.get(i) + "\n");
        }
        return productsReceipt.toString();
    }
}
