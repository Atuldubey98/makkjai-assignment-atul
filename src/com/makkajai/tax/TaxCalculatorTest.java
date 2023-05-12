package com.makkajai.tax;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.makkajai.utils.AppConstantsUtility;

public class TaxCalculatorTest {
    private class TaxWithGrand {
        public double expectedSalesTax;
        public double expectedGT;
        public List<Double> totalAfterTax;

        public TaxWithGrand(double expectedSalesTax, double expectedGT) {
            this.expectedSalesTax = expectedSalesTax;
            this.expectedGT = expectedGT;
            this.totalAfterTax = new ArrayList<>();
        }

    }

    private List<TaxWithGrand> getListofGrands() {

        TaxWithGrand taxWithGrand1 = new TaxWithGrand(1.5, 29.83);
        TaxWithGrand taxWithGrand2 = new TaxWithGrand(7.65, 65.15);
        TaxWithGrand taxWithGrand3 = new TaxWithGrand(6.7, 74.68);
        taxWithGrand1.totalAfterTax = List.of(12.49, 16.49, 0.85);
        taxWithGrand2.totalAfterTax = List.of(10.5, 54.65);
        taxWithGrand3.totalAfterTax = List.of(32.19, 20.89, 9.75, 11.85);
        return List.of(taxWithGrand1, taxWithGrand2,
                taxWithGrand3);
    }

    private List<TaxCalculator> taxCalculators;

    public TaxCalculatorTest() {
        this.taxCalculators = AppConstantsUtility.taxCalculators;
    }

    @Test
    public void testSalesTax() {
        int i = 0;
        List<TaxWithGrand> results = this.getListofGrands();
        for (TaxCalculator taxCalculator : this.taxCalculators) {
            assertEquals("Sales Tax", results.get(i).expectedSalesTax, taxCalculator.getTotalTax(), 0);
            assertEquals("Grand Total", results.get(i).expectedGT, taxCalculator.getGrandTotal(), 0);
            List<Double> taxesOfProducts = taxCalculator.getProducts().stream()
                    .map(productsList -> productsList.getTotalAfterTax()).collect(Collectors.toList());
            for (int j = 0; j < taxesOfProducts.size(); j++) {
                assertEquals("After calculation tax over price", results.get(i).totalAfterTax.get(j),
                        taxesOfProducts.get(j),
                        0);
            }
            i++;
        }
    }

}
