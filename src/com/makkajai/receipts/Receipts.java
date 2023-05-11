package com.makkajai.receipts;

import java.io.File;

public class Receipts {

    private File[] directoryFiles;

    public File[] getDirectoryFiles() {
        return directoryFiles;
    }

    public Receipts(String directoryPath) {
        this.directoryFiles = new File(directoryPath).listFiles();
    }

    public String getPathForOutput(File file) {
        return file.getParent() + "/" + "output/" + "output" + file.getName();
    }
}
