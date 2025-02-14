package org.example.controller;

import org.example.command.*;
import org.example.encryption.AESEncryptionStrategy;
import org.example.encryption.EncryptionStrategy;
import org.example.service.EncryptionFileService;
import org.example.service.FileService;

import java.util.List;

public class FileController {
    private final FileService fileService = new FileService();
    private final EncryptionStrategy encryptionStrategy = new AESEncryptionStrategy();
    private final EncryptionFileService encryptionFileService = new EncryptionFileService(fileService, encryptionStrategy);

    public void saveFile(String fileName, String fileContent) {
        Command saveCommand = new SaveFileCommand(fileService, fileName, fileContent);
        saveCommand.execute();
    }

    public void deleteFile(String fileName) {
        Command deleteCommand = new DeleteFileCommand(fileService, fileName);
        deleteCommand.execute();
    }

    public void readFile(String fileName) {
        Command readFile = new ReadFileCommand(fileService, fileName);
        readFile.execute();
    }

    public void restoreFile(String fileName) {
        Command restoreFile = new RestoreFileCommand(fileService, fileName);
        restoreFile.execute();
    }

    public void saveFileEncrypted(String fileName, String fileContent) {
        Command saveCommand = new SaveFileCommand(encryptionFileService, fileName, fileContent);
        saveCommand.execute();
    }

    public void readFileEncrypted(String fileName) {
        Command readFile = new ReadFileCommand(encryptionFileService, fileName);
        readFile.execute();
    }

    public void listFiles() {
        Command listFiles = new ListFilesCommand(fileService);
        listFiles.execute();
    }

    public String searchFile(String name) {
        CommandWithStringReturn searchFile = new SearchFileCommand(fileService, name);
        return searchFile.execute();
    }
}
