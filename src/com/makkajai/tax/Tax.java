package com.makkajai.tax;

//Basisalestax and custom duty will implement this interface for all the props;
public interface Tax {
    public final double TAX_PERCENTAGE = 0;

    public double calculate(double price);
}
