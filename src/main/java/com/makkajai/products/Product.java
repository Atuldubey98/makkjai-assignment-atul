package com.makkajai.products;

import java.util.List;

import com.makkajai.tax.Tax;

public abstract class Product {
    private String receiptName;
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

    public abstract List<Tax> getTaxes();

    public Product(String receiptName) {
        this.receiptName = receiptName;
        this.initilizeProduct(receiptName);
    }

    public String getReceiptName() {
        return receiptName;
    }

    public void initilizeProduct(String receiptName) {
        String priceStr = "";
        int i = this.receiptName.length() - 1;
        while (i >= 0 && this.receiptName.charAt(i) != ' ')
            priceStr = this.receiptName.charAt(i--) + priceStr;

        this.price = Double.parseDouble(priceStr);
        StringBuilder str = new StringBuilder("");
        int k = 0;
        while (k < this.receiptName.length() && this.receiptName.charAt(k) != ' ') {
            str.append(this.receiptName.charAt(k++));
        }
        this.quantity = Integer.parseInt(str.toString());
        this.productName = this.receiptName.substring(k, i - 2).trim();
        this.isImport = this.productName.contains("import");
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
