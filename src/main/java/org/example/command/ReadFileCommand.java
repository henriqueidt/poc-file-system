package org.example.command;

import org.example.service.FileService;

public class ReadFileCommand implements Command {
    private FileService fileService;
    private String filePath;
    private String fileContent;

    public ReadFileCommand(FileService fileService, String filePath) {
        this.fileService = fileService;
        this.filePath = filePath;
    }

    @Override
    public void execute() {
        String content = fileService.readFile(filePath);
        System.out.println(content);
    }
}
