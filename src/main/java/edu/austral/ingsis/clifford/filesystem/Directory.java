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
    public void removeFileSystemItem(String name) {
        for (FileSystemItem file : files) {
            if (file.getName().equals(name)) {
                files.remove(file);
                return;
            }
        }
    }

    public ArrayList<FileSystemItem> getFileSystemItems() {
        return files;
    }

    @Override
    public String getName() {
        return name;
    }
}
