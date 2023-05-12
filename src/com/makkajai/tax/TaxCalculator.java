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
            double totalTax = 0;
            for (Tax tax : taxes) {
                this.totalTax += tax.calculate(productTotal);
                totalTax += tax.calculate(productTotal);
            }
            final double tax = totalTax == 0 ? 0 : roundOffTotalToZeroFive(totalTax);
            product.setTotalAfterTax(roundOffTotal(tax + product.getPrice()));
            this.totalTax = this.roundOffTotalToZeroFive(this.totalTax);
            this.total += productTotal;
        }
        this.grandTotal = roundOffTotal(this.total + this.totalTax);
    }

    private double roundOffTotal(double totalAmount) {
        return Math.round(totalAmount * 100.0) / 100.0;
    }

    public double roundOffTotalToZeroFive(double amount) {
        return Math.ceil(amount * 20.0) / 20.0;
    }
}
