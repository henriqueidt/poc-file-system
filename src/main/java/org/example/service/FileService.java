package org.example.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileService {
    private static final String STORAGE_DIR = "./storage";

    private String getFilePath(String fileName) {
        return Paths.get(STORAGE_DIR, fileName).toString();
//        return STORAGE_DIR + "/" + fileName;
    }

    public void saveFile(String fileName, String content) {
        String filePath = getFilePath(fileName);
        File directory = new File(STORAGE_DIR);

        if(!directory.exists()) {
            directory.mkdirs();
        }

        try(FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("File saved to: " + filePath);

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public void deleteFile(String fileName) {
        String filePath = getFilePath(fileName);

        try {
            Files.deleteIfExists(Paths.get(filePath));
            System.out.println("File deleted: " + filePath);
        } catch (IOException e) {
            System.out.println("Error deleting file: " + e.getMessage());
        }
    }

    public String readFile(String fileName) {
        String filePath = getFilePath(fileName);
        try {
            return Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }


}
