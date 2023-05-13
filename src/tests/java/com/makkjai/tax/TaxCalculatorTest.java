package com.makkjai.tax;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.makkajai.products.Cart;
import com.makkajai.products.Product;
import com.makkajai.tax.TaxCalculator;

public class TaxCalculatorTest {

    private List<Cart> carts;

    private class TaxCalResults {
        public double totalTax;
        public double grandTotal;
        public List<Double> salesTaxesForProducts;

        public TaxCalResults(double totalTax, double grandTotal, List<Double> salesTaxesForProducts) {
            this.totalTax = totalTax;
            this.grandTotal = grandTotal;
            this.salesTaxesForProducts = salesTaxesForProducts;
        }
    }

    private final List<TaxCalResults> results = List.of(new TaxCalResults(1.5, 29.83, List.of(12.49, 16.49, 0.85)),
            new TaxCalResults(7.65, 65.15, List.of(10.5, 54.65)),
            new TaxCalResults(6.7, 74.68, List.of(32.19, 20.89, 9.75, 11.85)));

    public TaxCalculatorTest() {

        this.carts = List.of(new Cart("1 book at 12.49\n1 music CD at 14.99\n1 chocolate bar at 0.85"),
                new Cart("1 imported box of chocolates at 10.00\n1 imported bottle of perfume at 47.50"), new Cart(
                        "1 imported bottle of perfume at 27.99\n1 bottle of perfume at 18.99\n1 packet of headache pills at 9.75\n1 box of imported chocolates at 11.25"));
    }

    @Test
    public void testTaxCalculator() {
        for (int i = 0; i < this.carts.size(); i++) {
            Cart cart = carts.get(i);
            TaxCalculator taxCalculator = new TaxCalculator();
            taxCalculator.calculateTax(cart);
            List<Product> products = cart.getProducts();
            assertEquals("Sales Tax Total", results.get(i).totalTax, taxCalculator.getTotalTax(), 0);
            assertEquals("Sales Tax Total", results.get(i).grandTotal, taxCalculator.getGrandTotal(), 0);
            for (int j = 0; j < products.size(); j++) {
                assertEquals("Product Sales Tax", results.get(i).salesTaxesForProducts.get(j),
                        products.get(j).getAmountAfterTax(), 0);
            }
        }
    }
}
