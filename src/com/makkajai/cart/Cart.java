package com.makkajai.cart;

import java.util.ArrayList;
import java.util.List;

import com.makkajai.receipts.ProductReceipt;

public class Cart {
    private List<Product> cartProducts;

    public List<Product> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(String productsReceipt) {
        String receipt = productsReceipt.trim();
        String productReciepts[] = receipt.split("\n");
        for (String productReciept : productReciepts) {
            ProductReceipt pr = new ProductReceipt(productReciept);
            Product product = new Product(pr.getPrice(), pr.getProductName(), pr.getQuantity(), pr.getName());
            this.cartProducts.add(product);
        }
    }

    public Cart() {
        this.cartProducts = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Cart [cartProducts=" + cartProducts + "]";
    }
}
