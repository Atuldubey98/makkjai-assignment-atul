package com.makkajai.cart;

import java.util.ArrayList;
import java.util.List;

import com.makkajai.tax.BasicSalesTax;
import com.makkajai.tax.CustomDutyTax;
import com.makkajai.tax.Tax;

public class Product {
    private static final String IMPORT = "import";
    private static final List<String> EXEMPTED_PRODUCTS = List.of("chocolate", "pill", "book");
    private double price;
    private String receiptName;
    private double totalAfterTax;

    public double getTotalAfterTax() {
        return totalAfterTax;
    }

    public void setTotalAfterTax(double totalAfterTax) {
        this.totalAfterTax = totalAfterTax;
    }

    public String getReceiptName() {
        return receiptName;
    }

    public void setReceiptName(String receiptName) {
        this.receiptName = receiptName;
    }

    private int quantity;
    private List<Tax> taxes;

    public List<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes() {
        if (isBasicTaxApplicable()) {
            this.taxes.add(new BasicSalesTax());
        }
        if (this.name.contains(IMPORT)) {
            this.taxes.add(new CustomDutyTax());
        }
    }

    private boolean isBasicTaxApplicable() {
        return EXEMPTED_PRODUCTS.stream()
                .noneMatch((name) -> this.name.contains(name));
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(double price, String name, int quantity, String receiptName) {
        this.price = price;
        this.receiptName = receiptName;
        this.name = name;
        this.quantity = quantity;
        this.taxes = new ArrayList<>();
        this.setTaxes();
    }
}
