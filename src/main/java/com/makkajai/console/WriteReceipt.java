package com.makkajai.console;

import java.util.List;

import com.makkajai.products.Cart;
import com.makkajai.products.Product;
import com.makkajai.tax.TaxCalculator;

public class WriteReceipt {
    private Cart cart;

    public WriteReceipt(Cart cart, TaxCalculator taxCalculator) {
        this.cart = cart;
        this.taxCalculator = taxCalculator;
    }

    private TaxCalculator taxCalculator;

    private String cartToString() {
        List<Product> products = cart.getProducts();
        StringBuilder productsReceipt = new StringBuilder("");
        for (int i = 0; i < products.size(); i++) {
            productsReceipt.append(i == products.size() - 1 ? products.get(i) : products.get(i) + "\n");
        }
        return productsReceipt.toString();
    }

    private String taxToString() {
        return "Sales Taxes: " + " "
                + String.format("%.2f", taxCalculator.getTotalTax()) + "\n" + "Sales Total: " + " "
                + String.format("%.2f", taxCalculator.getGrandTotal()) + "\n";
    }

    public void outputReceipt() {
        System.out.println(cartToString());
        System.out.println(taxToString());
    }
}
