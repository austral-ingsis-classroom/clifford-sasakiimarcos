package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;

public class RemoveCommand implements Command{
    private final FileSystem fileSystem;
    public RemoveCommand(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute(String args[]) {

    }
}
