package edu.austral.ingsis.clifford.filesystem;

import java.util.ArrayList;

public class Directory implements FileSystemItem {
    private ArrayList<FileSystemItem> files;
    private String name;
    public Directory(String name) {
        this.name = name;
        this.files = new ArrayList<>();
    }

    public void addFileSystemItem(FileSystemItem file) {
        files.add(file);
    }

    @Override
    public String getName() {
        return name;
    }
}
