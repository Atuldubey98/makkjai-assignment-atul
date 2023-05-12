package com.makkajai.receipts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileData {
    public String readFileData(String pathname) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader buffer = new BufferedReader(
                new FileReader(pathname))) {
            String str;
            while ((str = buffer.readLine()) != null) {
                content.append(str).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
