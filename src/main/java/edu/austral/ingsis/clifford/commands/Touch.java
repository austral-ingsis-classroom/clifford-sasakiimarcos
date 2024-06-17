package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.filesystem.File;

public class Touch implements Command{

    private FileSystem fileSystem;
    private String name;

    public Touch(FileSystem fileSystem, String name) {
        this.fileSystem = fileSystem;
        this.name = name;
    }

    @Override
    public void execute() {
        fileSystem.getCurrentDirectory().addFileSystemItem(new File(name));
        System.out.println("'" + name + "' file created");
    }
}
