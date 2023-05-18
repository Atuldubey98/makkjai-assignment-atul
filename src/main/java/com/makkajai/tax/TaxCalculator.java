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
        return taxes.stream().map((tax) -> tax.calculate(total)).reduce(0.0,
                (element1, element2) -> element1 + element2);
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
}
