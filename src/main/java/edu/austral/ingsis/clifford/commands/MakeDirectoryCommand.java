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
        if (isInvalidInput(args)) {
            System.out.println("Invalid input");
            return;
        }
        fileSystem.getCurrentDirectory().addFileSystemItem(new Directory(args[0], fileSystem.getCurrentDirectory()));
    }

    private boolean isInvalidInput(String[] args) {
        return (args.length != 1) || (args[0].contains("/") || args[0].contains(" "));
    }
}
