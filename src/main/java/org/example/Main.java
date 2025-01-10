package org.example;

import org.example.controller.FileController;

public class Main {
    public static void main(String[] args) {
        FileController fileController = new FileController();

//        fileController.saveFile("example.txt", "aefuiahefuiaehufaehf");

        fileController.saveFileEncrypted("example.txt", "aefuiahefuiaehufaehf");


//        fileController.deleteFile("example.txt");
        fileController.readFile("example.txt");
        fileController.readFileEncrypted("example.txt");
    }
}