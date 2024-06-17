package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.filesystem.Directory;

public class MakeDirectoryCommand implements Command {
    private final FileSystem fileSystem;

    public MakeDirectoryCommand(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute(String[] args) {
        fileSystem.getCurrentDirectory().addFileSystemItem(new Directory(args[0]));
    }
}
