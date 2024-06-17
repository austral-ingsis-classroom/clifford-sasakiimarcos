package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.filesystem.Directory;
import edu.austral.ingsis.clifford.filesystem.FileSystemItem;

public class PrintWorkingDirectoryCommand implements Command{
    private final FileSystem fileSystem;

    public PrintWorkingDirectoryCommand(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }
    @Override
    public void execute(String[] args) {
        if (isInvalidInput(args)) {
            System.out.println("Invalid input");
            return;
        }
        System.out.println(fileSystem.getCurrentDirectory().getName());
    }

    private String BuildPath(String name) {
        StringBuilder pwd = new StringBuilder();
        pwd.append(fileSystem.getCurrentDirectory().getName());
        if (name.equals("/")) {
            return pwd.toString();
        }
        for (FileSystemItem fileSystemItem : fileSystem.getRoot().getFileSystemItems()) {
            if (fileSystemItem instanceof Directory) {
                StringBuilder path = recursiveBuildPath((Directory) fileSystemItem, name);
                if (path != null) {
                    pwd.append(path);
                }
            }
        }
        return pwd.toString();
    }

    private StringBuilder recursiveBuildPath(Directory directory, String name) {
        if (directory.getName().equals(name)) {
            return new StringBuilder(directory.getName());
        }
        for (FileSystemItem fileSystemItem : fileSystem.getRoot().getFileSystemItems()) {
            if (fileSystemItem instanceof Directory) {
                StringBuilder path = recursiveBuildPath((Directory) fileSystemItem, name);
                if (path != null) {
                    return new StringBuilder(directory.getName()).append("/").append(path);
                }
            }
        }
        return null;
    }

    private boolean isInvalidInput(String[] args) {
        return args.length != 0;
    }
}
