package com.makkajai.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadConsole {
    private int numberOfCarts;

    private static Scanner sc;
    static {
        sc = new Scanner(System.in);
    }

    public List<String> getInput() {
        System.out.println("Please enter number of carts :");
        numberOfCarts = Integer.parseInt(sc.nextLine());
        List<String> cartsList = new ArrayList<>();
        for (int i = 0; i < numberOfCarts; i++) {
            System.out.println("Enter receipts for cart " + (i + 1));
            String productReceipts = takeInputAndInitilizeProduct();
            cartsList.add(productReceipts);
        }
        sc.close();
        return cartsList;
    }

    private String takeInputAndInitilizeProduct() {
        StringBuilder productReceipts = new StringBuilder();
        System.out.println("Enter the number of products :");
        final int numberOfProducts = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfProducts; i++) {
            System.out.println("Enter receipt " + (i + 1) + " for cart like [quantity name price] :");
            String productReceipt = sc.nextLine();
            productReceipts.append(i == numberOfProducts - 1 ? productReceipt : productReceipt + "\n");
        }
        return productReceipts.toString();
    }
}
