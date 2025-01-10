package org.example.service;

import org.example.encryption.EncryptionStrategy;

public class EncryptionFileService extends FileService {
    private final FileService fileService;
    private final EncryptionStrategy encryptionStrategy;

    public EncryptionFileService(FileService fileService, EncryptionStrategy encryptionStrategy) {
        this.fileService = fileService;
        this.encryptionStrategy = encryptionStrategy;
    }

    @Override
    public void saveFile(String fileName, String content) {
        String encryptedContent = encryptionStrategy.encrypt(content);
        fileService.saveFile(fileName, encryptedContent);
    }

    @Override
    public String readFile(String fileName) {
        String content = fileService.readFile(fileName);
        return encryptionStrategy.decrypt(content);
    }
}
