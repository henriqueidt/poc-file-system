package org.example.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileService {
    private static final String STORAGE_DIR = "./storage";
    private static final String GARBAGE_DIR = "./garbage";

    private String getFilePath(String fileName, boolean isGarbage) {
        return Paths.get(isGarbage ? GARBAGE_DIR : STORAGE_DIR, fileName).toString();
//        return Paths.get(, fileName).toString();
//        return STORAGE_DIR + "/" + fileName;
    }

    public void saveFile(String fileName, String content) {
        String filePath = getFilePath(fileName, false);
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
        String filePath = getFilePath(fileName, true);
        String garbagePath = getFilePath(fileName, false);

        try {
//            Files.deleteIfExists(Paths.get(filePath));
            Files.move(Paths.get(garbagePath), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File deleted: " + filePath);
        } catch (IOException e) {
            System.out.println("Error deleting file: " + e.getMessage());
        }
    }

    public String readFile(String fileName) {
        String filePath = getFilePath(fileName, false);
        try {
            return Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    public void restoreFile(String fileName) {
        String garbagePath = getFilePath(fileName, true);
        String fileDestinationPath = getFilePath(fileName, false);

        try {
            Files.move(Paths.get(garbagePath), Paths.get(fileDestinationPath), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File restored: " + fileDestinationPath);
        } catch (NoSuchFileException e) {
            System.out.println("File not found in garbage: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error restoring file: " + e.getMessage());
        }
    }


}
