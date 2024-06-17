package edu.austral.ingsis.clifford.filesystem;

public class File implements FileSystemItem {
    private String name;
    private Directory parent;

    public File(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Directory getParent() {
        return parent;
    }
}
