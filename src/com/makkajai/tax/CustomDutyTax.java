package com.makkajai.tax;

public class CustomDutyTax implements Tax {
    private final double TAX_PERCENTAGE = .05;

    @Override
    public double calculate(double price) {
        return price * TAX_PERCENTAGE;
    }

}
