package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.filesystem.Directory;

public class MakeDirectory implements Command {
    private final FileSystem fileSystem;
    private final String name;

    public MakeDirectory(FileSystem fileSystem, String name) {
        this.fileSystem = fileSystem;
        this.name = name;
    }

    @Override
    public void execute() {
        fileSystem.getCurrentDirectory().addFileSystemItem(new Directory(name));
    }
}
