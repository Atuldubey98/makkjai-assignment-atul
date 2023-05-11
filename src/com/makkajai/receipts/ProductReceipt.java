package com.makkajai.receipts;

public class ProductReceipt {
    private String name;
    public String getName() {
        return name;
    }

    private String productName;

    public String getProductName() {
        return productName;
    }

    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    private double price;

    public double getPrice() {
        return price;
    }

    public ProductReceipt(String name) {
        this.name = name;

        this.setProductReceipt();
    }

    public void setProductReceipt() {
        String priceStr = "";
        int i = this.name.length() - 1;
        while (i >= 0 && this.name.charAt(i) != ' ')
            priceStr = this.name.charAt(i--) + priceStr;

        this.price = Double.parseDouble(priceStr);
        StringBuilder str = new StringBuilder("");
        int k = 0;
        while (k < this.name.length() && this.name.charAt(k) != ' ') {
            str.append(this.name.charAt(k++));
        }
        this.quantity = Integer.parseInt(str.toString());
        this.productName = this.name.substring(k, i - 2).trim();
    }

    @Override
    public String toString() {
        return "ProductReceipt [name=" + name + ", productName=" + productName + ", quantity=" + quantity + ", price="
                + price + "]";
    }
}
