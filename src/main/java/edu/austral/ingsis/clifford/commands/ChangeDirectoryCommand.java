package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.filesystem.Directory;
import edu.austral.ingsis.clifford.filesystem.FileSystemItem;

public class ChangeDirectoryCommand implements Command{
    private final FileSystem fileSystem;

    public ChangeDirectoryCommand(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public String execute(String[] args) {
        if (isInvalidInput(args)) {
            return "Invalid input";
        }
        if (args[0].equals(".")) {
            fileSystem.setCurrentDirectory(fileSystem.getCurrentDirectory());
            return "Moved to directory: '" + fileSystem.getCurrentDirectory().getName() + "'";
        } else if (args[0].equals("..")) {
            fileSystem.setCurrentDirectory(fileSystem.getCurrentDirectory().getParent());
            return "Moved to directory: '" + fileSystem.getCurrentDirectory().getParent().getName() + "'";
        } else if (args[0].contains("/")) {
            Directory currentDirectory = fileSystem.getRoot();
            String[] directories = args[0].split("/");
            for (String directory : directories) {
                for (FileSystemItem file : currentDirectory.getFileSystemItems()) {
                    if (file instanceof Directory && file.getName().equals(directory)) {
                        currentDirectory = (Directory) file;
                        break;
                    }
                }
            }
            if (!currentDirectory.equals(directories[directories.length - 1])) {
                return "Directory not found";
            } else {
                fileSystem.setCurrentDirectory(currentDirectory);
                return "Moved to directory: '" + currentDirectory.getName() + "'";
            }
        } else {
            for (FileSystemItem file : fileSystem.getCurrentDirectory().getFileSystemItems()) {
                if (file instanceof Directory && file.getName().equals(args[0])) {
                    fileSystem.setCurrentDirectory((Directory) file);
                    return "Moved to directory: '" + fileSystem.getCurrentDirectory().getName() + "'";
                }
            }
            return "Directory not found";
        }
    }

    private boolean isInvalidInput(String[] args) {
        return args.length != 1;
    }
}
