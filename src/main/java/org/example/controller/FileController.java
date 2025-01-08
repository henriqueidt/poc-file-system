package org.example.controller;

import org.example.command.Command;
import org.example.command.DeleteFileCommand;
import org.example.command.ReadFileCommand;
import org.example.command.SaveFileCommand;
import org.example.service.FileService;

public class FileController {
    private final FileService fileService = new FileService();

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
}
