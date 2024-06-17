package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.commands.*;
import edu.austral.ingsis.clifford.filesystem.FileSystemItem;

import java.util.Arrays;

// Receiver
public class CommandLine {

    private FileSystem fileSystem;

    public CommandLine(FileSystemItem currentItem) {
        this.fileSystem = new FileSystem();
    }

    public void parseCommand(String command) {
        String[] input = command.split(" ");
        String[] args = Arrays.copyOfRange(input, 1, input.length);
        switch (input[0]) {
            case "ls":
                new List(fileSystem).execute(args);
                break;
            case "cd":
                new ChangeDirectory(fileSystem).execute(args);
                break;
            case "touch":
                new Touch(fileSystem).execute(args);
                break;
            case "mkdir":
                new MakeDirectory(fileSystem).execute(args);
                break;
            case "rm":
                new Remove(fileSystem).execute(args);
                break;
            default:
                System.out.println("Command not found");
        }
    }

}
