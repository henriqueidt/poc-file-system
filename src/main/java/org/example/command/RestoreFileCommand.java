package org.example.command;

import org.example.service.FileService;

public class RestoreFileCommand implements Command {
    private FileService fileService;
    private String filePath;

    public RestoreFileCommand(FileService fileService, String filePath) {
        this.fileService = fileService;
        this.filePath = filePath;
    }

    @Override
    public void execute() {
        fileService.restoreFile(filePath);
    }
}
