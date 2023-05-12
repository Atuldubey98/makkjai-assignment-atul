package com.makkajai.tax;

import java.util.List;

import com.makkajai.cart.Product;

public class TaxCalculator {
    private double totalTax = 0;

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    private double grandTotal = 0;

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    private double total = 0;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public TaxCalculator(List<Product> products) {

        for (Product product : products) {
            List<Tax> taxes = product.getTaxes();
            final double productTotal = product.getPrice() * product.getQuantity();
            taxes.forEach(tax -> {
                this.totalTax += tax.calculate(productTotal);
            });
            this.totalTax = this.roundOffTotalToZeroFive(this.totalTax);
            this.total += productTotal;
        }
        this.grandTotal = roundOffTotal();
    }

    private double roundOffTotal() {
        return Math.round((this.total + this.totalTax) * 100.0) / 100.0;
    }

    public double roundOffTotalToZeroFive(double amount) {
        return Math.ceil(amount * 20.0) / 20.0;
    }
}
