package urise.webapp;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        File dir = new File("com\\urise\\webapp");
        printDirectoryDeeply(dir, false);
    }

    public static void printDirectoryDeeply(File dir, boolean indent) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (indent) {
                        System.out.println("    " + "File: " + file.getName());
                    } else {
                        System.out.println("File: " + file.getName());
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Folder: " + file.getName());
                    printDirectoryDeeply(file, true);
                }
            }
        }
    }
}