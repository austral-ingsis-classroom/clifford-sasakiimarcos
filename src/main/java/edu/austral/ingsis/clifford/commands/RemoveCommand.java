package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;

public class RemoveCommand implements Command{
    private final FileSystem fileSystem;
    public RemoveCommand(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public String execute(String[] args) {
        if (isInvalidInput(args)) {
            return "Invalid input";
        }
        if (args.length == 1) {
            if (!exists(args[0])) {
                return "File not found";
            }
            fileSystem.getCurrentDirectory().removeFileSystemItem(args[0]);
            return args[0] + " removed";
        } else {
            if (!exists(args[1])) {
                return "File not found";
            }
            fileSystem.getCurrentDirectory().removeFileSystemItem(args[1]);
            return args[1] + " removed";
        }
    }

    private boolean exists(String name) {
        return fileSystem.getCurrentDirectory().getFileSystemItems().stream().anyMatch(file -> file.getName().equals(name));
    }
    private boolean isInvalidInput(String[] args) {
        return (args.length != 1 && args.length != 2) || (args.length == 2 && !args[0].equals("--recursive"));
    }
}
