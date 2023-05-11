package com.makkajai.receipts;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.makkajai.cart.Cart;

public class ReadReceipts extends Receipts {
    private List<Cart> carts;

    public List<Cart> getCarts() {
        return carts;
    }

    private ReadFileData readFileData;

    public ReadReceipts(String directoryPath) {
        super(directoryPath);
        this.readFileData = new ReadFileData();
        this.carts = new ArrayList<>();
        this.initilize();
    }

    private void initilize() {
        File directoryFiles[] = super.getDirectoryFiles();
        try {
            for (File file : directoryFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    String productsReceipt = readFileData.readFileData(file.getPath());
                    File newFile = new File(super.getPathForOutput(file));
                    newFile.getParentFile().mkdirs();
                    newFile.createNewFile();
                    Cart cart = new Cart();
                    cart.setCartProducts(productsReceipt);
                    this.carts.add(cart);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
