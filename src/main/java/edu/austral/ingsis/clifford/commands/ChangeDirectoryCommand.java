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
    public void execute(String args[]) {
        if (isInvalidInput(args)) {
            System.out.println("Invalid input");
            return;
        }
        if (args[0].equals(".")) {
            fileSystem.setCurrentDirectory(fileSystem.getCurrentDirectory());
        } else if (args[0].equals("..")) {
            fileSystem.setCurrentDirectory(fileSystem.getCurrentDirectory().getParent());
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
                System.out.println("Directory not found");
            } else {
                fileSystem.setCurrentDirectory(currentDirectory);
            }
        } else {
            for (FileSystemItem file : fileSystem.getCurrentDirectory().getFileSystemItems()) {
                if (file instanceof Directory && file.getName().equals(args[0])) {
                    fileSystem.setCurrentDirectory((Directory) file);
                    return;
                }
            }
            System.out.println("Directory not found");
        }
    }

    private boolean isInvalidInput(String[] args) {
        return args.length != 1;
    }
}
