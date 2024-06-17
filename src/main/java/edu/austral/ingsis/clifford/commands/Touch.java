package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.filesystem.File;

public class Touch implements Command{

    private FileSystem fileSystem;

    public Touch(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute(String args[]) {
        fileSystem.getCurrentDirectory().addFileSystemItem(new File(args[0]));
        System.out.println("'" + args[0] + "' file created");
    }
}
