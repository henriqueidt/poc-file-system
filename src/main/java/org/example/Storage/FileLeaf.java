package org.example.Storage;

public class FileLeaf extends FileComponent {
    private String content;

    public FileLeaf(String name) {
        super(name);
        this.content = "";
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public void list(int spaces) {
        System.out.println(" ".repeat(spaces) + "- file: " + name);
    }
}
