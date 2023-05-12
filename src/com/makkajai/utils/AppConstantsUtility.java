package com.makkajai.utils;

import java.util.List;

import com.makkajai.cart.Product;
import com.makkajai.tax.TaxCalculator;

public class AppConstantsUtility {

    public static final List<TaxCalculator> taxCalculators = List.of(
            new TaxCalculator(List.of(new Product(12.49, "book", 1, "1 book at 12.49"),
                    new Product(14.99, "music CD", 1, "1 music CD at 14.99"),
                    new Product(0.85, "chocolate bar", 1, "1 chocolate bar at 0.85"))),
            new TaxCalculator(List.of(
                    new Product(10.00, "imported box of chocolates", 1, "1 imported box of chocolates at 10.00"),
                    new Product(47.5, "imported bottle of perfume", 1, "1 imported bottle of perfume at 47.50"))),
            new TaxCalculator(List.of(
                    new Product(27.99, "imported bottle of perfume", 1, "1 imported bottle of perfume at 27.99"),
                    new Product(18.99, "bottle of perfume", 1, "1 bottle of perfume at 18.99"),
                    new Product(9.75, "packet of headache pills", 1, "1 packet of headache pills at 9.75"),

                    new Product(11.25, "box of imported chocolates", 1, "1 box of imported chocolates at 11.25"))));
}
