package com.makkajai.tax;

import java.util.List;

import com.makkajai.products.Cart;
import com.makkajai.products.Product;

public class TaxCalculator {
    private double totalTax;
    private double grandTotal;

    public double getGrandTotal() {
        return grandTotal;
    }

    public double getTotalTax() {
        return totalTax;
    }

    private double getProductTax(List<Tax> taxes, double total) {
        double productTax = 0;
        for (Tax tax : taxes) {
            productTax += tax.calculate(total);
        }
        return productTax;
    }

    private double roundOffTotal(double totalAmount) {
        return Math.round(totalAmount * 100.0) / 100.0;
    }

    private double roundOffTotalToZeroFive(double amount) {
        return Math.ceil(amount * 20.0) / 20.0;
    }

    public void calculateTax(Cart cart) {
        for (Product product : cart.getProducts()) {
            double productTax = this
                    .roundOffTotalToZeroFive(this.getProductTax(product.getTaxes(), product.getTotal()));
            product.setAmountAfterTax(roundOffTotal(productTax + product.getTotal()));
            this.totalTax += productTax;
            this.totalTax = this.roundOffTotalToZeroFive(this.totalTax);
            this.grandTotal += product.getTotal();
        }
        this.grandTotal += this.totalTax;
        this.grandTotal = roundOffTotal(this.grandTotal);
    }

    @Override
    public String toString() {
        return "Sales Taxes: " + " "
                + String.format("%.2f", this.totalTax) + "\n" + "Sales Total: " + " "
                + String.format("%.2f", this.grandTotal) + "\n";
    }
}
