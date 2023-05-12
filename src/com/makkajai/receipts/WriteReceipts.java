package com.makkajai.receipts;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.makkajai.cart.Cart;
import com.makkajai.tax.TaxCalculator;

public class WriteReceipts extends Receipts {
    private List<TaxCalculator> taxCalculators;
    private List<Cart> carts;

    public WriteReceipts(String directoryPath, List<TaxCalculator> taxCalculators, List<Cart> carts) {
        super(directoryPath);
        this.carts = carts;
        this.taxCalculators = taxCalculators;
    }

    public String cartProductsReceipt(Cart cart) {
        StringBuilder productsReceipt = new StringBuilder("");
        cart.getCartProducts().forEach(product -> {
            productsReceipt.append(product.getQuantity() + " ");
            productsReceipt.append(product.getName() + ": ");
            productsReceipt.append(product.getTotalAfterTax() + "\n");
        });
        return productsReceipt.toString();
    }

    public void writeReceipts() {

        File directoryFiles[] = super.getDirectoryFiles();
        int i = 0;
        for (File file : directoryFiles) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                final String calculations = "Sales Taxes: " + " "
                        + taxCalculators.get(i).getTotalTax() + "\n" + "Sales Total: " + " "
                        + taxCalculators.get(i).getGrandTotal();
                String productsReceipt = this.cartProductsReceipt(this.carts.get(i)) + calculations;
                try {
                    final FileWriter fileWriter = new FileWriter(
                            super.getPathForOutput(file),
                            false);
                    fileWriter.append(productsReceipt);
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
                i++;
            }
        }

    }
}
