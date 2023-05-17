package com.makkajai.products;

public class ReceiptProductMapper {
    private int i;
    private int k;
    private String receiptName;
    private double price;
    private int quantity;
    private String productName;
    private boolean isImport;

    public ReceiptProductMapper(String receiptName) {
        this.receiptName = receiptName;
        this.i = receiptName.length() - 1;
        this.k = 0;
        this.setPrice();
        this.setQty();
        this.setProductName();
        this.isImport = this.productName.contains("import");
    }

    private void setPrice() {
        String priceStr = "";
        while (this.i >= 0 && this.receiptName.charAt(this.i) != ' ')
            priceStr = this.receiptName.charAt(this.i--) + priceStr;
        this.price = Double.parseDouble(priceStr);
    }

    private void setQty() {
        StringBuilder str = new StringBuilder("");
        while (this.k < this.receiptName.length() && this.receiptName.charAt(this.k) != ' ') {
            str.append(this.receiptName.charAt(this.k++));
        }
        this.quantity = Integer.parseInt(str.toString());
    }

    private void setProductName() {
        this.productName = this.receiptName.substring(this.k, this.i - 2).trim();
    }

    public Product mapDTOToProduct() {
        return new Product(this.productName, this.price, this.quantity, this.isImport);
    }
}
