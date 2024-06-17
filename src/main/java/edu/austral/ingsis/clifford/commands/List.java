package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.filesystem.FileSystemItem;

public class List implements Command{

    private final FileSystem fileSystem;
    public List(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }
    @Override
    public void execute(String args[]) {

    }
}
