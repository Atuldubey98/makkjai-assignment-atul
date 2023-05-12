package com.makkajai.products;

import java.util.ArrayList;
import java.util.List;

import com.makkajai.tax.BasicSalesTax;
import com.makkajai.tax.CustomDutyTax;
import com.makkajai.tax.Tax;

public class Other extends Product {

    public Other(String receiptName) {
        super(receiptName);
    }

    @Override
    public List<Tax> getTaxes() {
        List<Tax> taxes = new ArrayList<>();
        taxes.add(new BasicSalesTax());
        if (super.isImport()) {
            taxes.add(new CustomDutyTax());
        }
        return taxes;
    }

}
