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
            return "invalid input";
        }
        if (args[0].equals(".")) {
            fileSystem.setCurrentDirectory(fileSystem.getCurrentDirectory());
            return "moved to directory '" + fileSystem.getCurrentDirectory().getName() + "'";
        } else if (args[0].equals("..")) {
            fileSystem.setCurrentDirectory(fileSystem.getCurrentDirectory().getParent());
            return "moved to directory '" + fileSystem.getCurrentDirectory().getParent().getName() + "'";
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
                return "'" + args[0] + "' directory does not exist";
            } else {
                fileSystem.setCurrentDirectory(currentDirectory);
                return "moved to directory '" + currentDirectory.getName() + "'";
            }
        } else {
            for (FileSystemItem file : fileSystem.getCurrentDirectory().getFileSystemItems()) {
                if (file instanceof Directory && file.getName().equals(args[0])) {
                    fileSystem.setCurrentDirectory((Directory) file);
                    return "moved to directory '" + fileSystem.getCurrentDirectory().getName() + "'";
                }
            }
            return "'" + args[0] + "' directory does not exist";
        }
    }

    private boolean isInvalidInput(String[] args) {
        return args.length != 1;
    }
}
