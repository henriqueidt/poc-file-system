package org.example.Storage;

import java.util.ArrayList;
import java.util.List;

public class FolderComposite extends FileComponent {
    private final List<FileComponent> childComponents = new ArrayList<>();

    public FolderComposite(String name) {
        super(name);
    }

    public void add(FileComponent component) {
        childComponents.add(component);
    }

    public void remove(FileComponent component) {
        childComponents.remove(component);
    }

    @Override
    public void list(int spaces) {
        System.out.println(" ".repeat(spaces) + "+ folder: " + name);
        for (FileComponent component : childComponents) {
            component.list(spaces + 4);
        }
    }
}
