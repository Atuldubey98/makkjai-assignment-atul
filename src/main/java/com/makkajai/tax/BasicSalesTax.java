package com.makkajai.tax;

import java.util.List;

public class BasicSalesTax implements Tax {
    private final double TAX_PERCENTAGE = .10;
    public static final List<String> EXEMPTED_PRODUCTS = List.of("pill", "chocolate", "book");
    @Override
    public double calculate(double price) {
        return price * TAX_PERCENTAGE;
    }

}