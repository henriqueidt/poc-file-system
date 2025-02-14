package org.example;

import org.example.controller.FileController;

public class Main {
    public static void main(String[] args) {
        FileController fileController = new FileController();

//        fileController.saveFile("example.txt", "aefuiahefuiaehufaehf");

        fileController.saveFileEncrypted("example.txt", "aefuiahefuiaehufaehf");


        fileController.readFile("example.txt");
        fileController.readFileEncrypted("example.txt");
        fileController.deleteFile("example.txt");
        fileController.restoreFile("example.txt");

        fileController.listFiles();

        String fileName = fileController.searchFile("example");
        System.out.println(fileName + " found");
    }
}