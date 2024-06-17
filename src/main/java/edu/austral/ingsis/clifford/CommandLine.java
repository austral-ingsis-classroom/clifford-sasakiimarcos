package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.commands.*;

import java.util.Arrays;

// Receiver
public class CommandLine {

    private FileSystem fileSystem;

    public CommandLine() {
        this.fileSystem = new FileSystem();
    }

    public String execute(String command) {
        String[] input = command.split(" ");
        String[] args = Arrays.copyOfRange(input, 1, input.length);
        switch (input[0]) {
            case "ls":
                return new ListCommand(fileSystem).execute(args);
            case "cd":
                return new ChangeDirectoryCommand(fileSystem).execute(args);
            case "touch":
                return new TouchCommand(fileSystem).execute(args);
            case "mkdir":
                return new MakeDirectoryCommand(fileSystem).execute(args);
            case "rm":
                return new RemoveCommand(fileSystem).execute(args);
            case "pwd":
                return new PrintWorkingDirectoryCommand(fileSystem).execute(args);
            default:
                return "Command not found";
        }
    }

}
