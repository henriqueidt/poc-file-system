package org.example.Storage;

abstract class FileComponent {
    protected String name;

    public FileComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void list(int spaces);

    public boolean matches(String name) {
        return this.name.contains(name);
    }
}
