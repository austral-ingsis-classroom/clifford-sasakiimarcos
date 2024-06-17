package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;

public class RemoveCommand implements Command{
    private final FileSystem fileSystem;
    public RemoveCommand(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute(String args[]) {
        if (isInvalidInput(args)) {
            System.out.println("Invalid input");
            return;
        }
        if (args.length == 1) {
            if (!exists(args[0])) {
                System.out.println("File not found");
                return;
            }
            fileSystem.getCurrentDirectory().removeFileSystemItem(args[0]);
        } else {
            if (!exists(args[1])) {
                System.out.println("File not found");
                return;
            }
            fileSystem.getCurrentDirectory().removeFileSystemItem(args[1]);
        }
    }

    private boolean exists(String name) {
        return fileSystem.getCurrentDirectory().getFileSystemItems().stream().anyMatch(file -> file.getName().equals(name));
    }
    private boolean isInvalidInput(String[] args) {
        return (args.length != 1 && args.length != 2) || (args.length == 2 && !args[0].equals("--recursive"));
    }
}
