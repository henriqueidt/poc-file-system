package org.example.command;

import org.example.service.FileService;

public class ListFilesCommand implements Command {
    private FileService fileService;

    public ListFilesCommand(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public void execute() {
        fileService.listFiles();
    }
}
