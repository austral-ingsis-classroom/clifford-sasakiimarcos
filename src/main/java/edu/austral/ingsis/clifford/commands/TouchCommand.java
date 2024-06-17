package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.filesystem.File;

public class TouchCommand implements Command{

    private FileSystem fileSystem;

    public TouchCommand(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute(String args[]) {
        if (isInvalidInput(args)) {
            System.out.println("Invalid input");
            return;
        }
        fileSystem.getCurrentDirectory().addFileSystemItem(new File(args[0], fileSystem.getCurrentDirectory()));
        System.out.println("'" + args[0] + "' file created");
    }

    private boolean isInvalidInput(String[] args) {
        return (args.length != 1) || (args[0].contains("/") || args[0].contains(" "));
    }

}
