package com.makkajai.receipts;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.makkajai.tax.TaxCalculator;

public class WriteReceipts extends Receipts {
    private List<TaxCalculator> taxCalculators;

    private ReadFileData readFileData;

    public WriteReceipts(String directoryPath, List<TaxCalculator> taxCalculators) {
        super(directoryPath);
        this.taxCalculators = taxCalculators;
        this.readFileData = new ReadFileData();
    }

    public void writeReceipts() {

        File directoryFiles[] = super.getDirectoryFiles();
        int i = 0;
        for (File file : directoryFiles) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                final String calculations = "Sales Taxes: " + " "
                        + taxCalculators.get(i).getTotalTax() + "\n" + "Sales Total: " + " "
                        + taxCalculators.get(i).getGrandTotal();
                String productsReceipt = readFileData.readFileData(file.getPath()) + calculations;
                try {
                    final FileWriter fileWriter = new FileWriter(
                            super.getPathForOutput(file),
                            false);
                    fileWriter.append(productsReceipt);
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
                i++;
            }
        }

    }
}
