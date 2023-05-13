package com.makkajai.products;

import java.util.ArrayList;
import java.util.List;

import com.makkajai.tax.CustomDutyTax;
import com.makkajai.tax.Tax;

public class Food extends Product {
    public Food(String recieiptName) {
        super(recieiptName);
    }

    @Override
    public List<Tax> getTaxes() {
        List<Tax> taxes = new ArrayList<>();
        if (super.isImport()) {
            taxes.add(new CustomDutyTax());
        }
        return taxes;
    }

}
