package org.example.command;

import org.example.service.FileService;

public class SearchFileCommand implements CommandWithStringReturn {
    private FileService fileService;
    private String name;

    public SearchFileCommand(FileService fileService, String name) {
        this.fileService = fileService;
        this.name = name;
    }

    @Override
    public String execute() {
        return this.fileService.searchFile(name);
    }
}
