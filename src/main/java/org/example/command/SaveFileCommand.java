package org.example.command;

import org.example.service.FileService;

public class SaveFileCommand implements Command {
    private FileService fileService;
    private String filePath;
    private String fileContent;

    public SaveFileCommand(FileService fileService, String filePath, String fileContent) {
        this.fileService = fileService;
        this.filePath = filePath;
        this.fileContent = fileContent;
    }

    @Override
    public void execute() {
        fileService.saveFile(filePath, fileContent);
    }
}
