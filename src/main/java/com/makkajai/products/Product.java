package com.makkajai.products;

import java.util.ArrayList;
import java.util.List;

import com.makkajai.tax.BasicSalesTax;
import com.makkajai.tax.CustomDutyTax;
import com.makkajai.tax.Tax;

public class Product {

    private String productName;
    private double price;
    private int quantity;
    private boolean isImport;
    private double amountAfterTax;

    public double getAmountAfterTax() {
        return amountAfterTax;
    }

    public void setAmountAfterTax(double amountAfterTax) {
        this.amountAfterTax = amountAfterTax;
    }

    public boolean isImport() {
        return isImport;
    }

    public List<Tax> getTaxes() {
        List<Tax> taxes = new ArrayList<>();
        if (!BasicSalesTax.EXEMPTED_PRODUCTS.stream().anyMatch((item) -> this.productName.contains(item)))
            taxes.add(new BasicSalesTax());
        if (isImport) {
            taxes.add(new CustomDutyTax());
        }
        return taxes;
    }

    public Product(String productName, double price, int quantity, boolean isImport) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.isImport = isImport;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return this.price * this.quantity;
    }

    @Override
    public String toString() {
        return this.quantity + " " + this.productName + " : " + String.format("%.2f", this.amountAfterTax);
    }
}
