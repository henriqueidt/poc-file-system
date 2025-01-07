package org.example.command;

import org.example.service.FileService;

public class SaveFileCommand implements Command {
    private FileService fileService;
    private String filePath;

    public SaveFileCommand(FileService fileService, String filePath) {
        this.fileService = fileService;
        this.filePath = filePath;
    }

    @Override
    public void execute() {
        fileService.saveFile(filePath);
    }
}
