package com.makkajai.tax;

public interface Tax {
    public final double TAX_PERCENTAGE = 0;

    public double calculate(double price);
}
