package org.example.controller;

import org.example.command.Command;
import org.example.command.DeleteFileCommand;
import org.example.command.ReadFileCommand;
import org.example.command.SaveFileCommand;
import org.example.encryption.AESEncryptionStrategy;
import org.example.encryption.EncryptionStrategy;
import org.example.service.EncryptionFileService;
import org.example.service.FileService;

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

    public void saveFileEncrypted(String fileName, String fileContent) {
        Command saveCommand = new SaveFileCommand(encryptionFileService, fileName, fileContent);
        saveCommand.execute();
    }

    public void readFileEncrypted(String fileName) {
        Command readFile = new ReadFileCommand(encryptionFileService, fileName);
        readFile.execute();
    }
}
