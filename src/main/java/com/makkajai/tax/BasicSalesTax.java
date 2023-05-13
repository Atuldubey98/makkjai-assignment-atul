package com.makkajai.tax;

public class BasicSalesTax implements Tax {
    private final double TAX_PERCENTAGE = .10;

    @Override
    public double calculate(double price) {
        return price * TAX_PERCENTAGE;
    }

}