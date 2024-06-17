package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.commands.Command;
import edu.austral.ingsis.clifford.filesystem.Directory;
import edu.austral.ingsis.clifford.filesystem.FileSystemItem;

public class FileSystem {
    // Receiver
    private Directory currentDirectory;

    public FileSystem() {
        currentDirectory = new Directory("home");
    }

    public void setCurrentDirectory(Directory currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    public Directory getCurrentDirectory() {
        return currentDirectory;
    }

}
