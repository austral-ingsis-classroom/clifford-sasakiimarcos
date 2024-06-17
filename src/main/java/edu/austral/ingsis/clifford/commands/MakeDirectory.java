package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.filesystem.Directory;

public class MakeDirectory implements Command {
    private final FileSystem fileSystem;

    public MakeDirectory(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute(String[] args) {
        fileSystem.getCurrentDirectory().addFileSystemItem(new Directory(args[0]));
    }
}
