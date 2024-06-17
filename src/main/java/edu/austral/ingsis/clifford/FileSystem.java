package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.filesystem.Directory;
import edu.austral.ingsis.clifford.filesystem.FileSystemItem;

public class FileSystem {
    // Receiver
    private Directory currentDirectory;
    private Command command;

    public FileSystem(Command command) {
        currentDirectory = new Directory("/");
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }

    public void setCurrentDirectory(Directory currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    public Directory getCurrentDirectory() {
        return currentDirectory;
    }

}
