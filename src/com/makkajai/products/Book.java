package com.makkajai.products;

import java.util.ArrayList;
import java.util.List;

import com.makkajai.tax.CustomDutyTax;
import com.makkajai.tax.Tax;

public class Book extends Product {

    public Book(String receiptName) {
        super(receiptName);
    }

    @Override
    public List<Tax> getTaxes() {
        List<Tax> taxes = new ArrayList<>();
        if (super.getProductName().contains("import")) {
            taxes.add(new CustomDutyTax());
        }
        return taxes;
    }

}
