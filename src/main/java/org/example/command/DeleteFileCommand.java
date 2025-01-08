package org.example.command;

import org.example.service.FileService;

public class DeleteFileCommand implements Command {
    private FileService fileService;
    private String filePath;

    public DeleteFileCommand(FileService fileService, String filePath) {
        this.fileService = fileService;
        this.filePath = filePath;
    }

    @Override
    public void execute() {
        fileService.deleteFile(filePath);
    }
}
