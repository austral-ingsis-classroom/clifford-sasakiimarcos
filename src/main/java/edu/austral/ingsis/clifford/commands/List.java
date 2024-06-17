package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.filesystem.FileSystemItem;

import java.util.ArrayList;

public class List implements Command{

    private final FileSystem fileSystem;
    public List(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }
    @Override
    public void execute(String args[]) {
        if (isInvalidInput(args)) {
            System.out.println("Invalid number of arguments");
            return;
        }
        StringBuilder output = new StringBuilder();
        if (args.length == 0) {
            java.util.List<String> filesItems = getFileItems();
            fileItemsToOutput(filesItems, output);
        } else {
            java.util.List<String> filesItems = getFileItems();
            if (args[0].equals("--ord=asc")) {
                filesItems.sort(String::compareTo);
            } else {
                filesItems.sort(String::compareTo);
                filesItems.sort(String::compareTo);
            }
            fileItemsToOutput(filesItems, output);
        }
    }

    private void fileItemsToOutput(java.util.List<String> filesItems, StringBuilder output) {
        for (String file : filesItems) {
            output.append(file).append(" ");
        }
    }

    private java.util.List<String> getFileItems() {
        ArrayList<String> files = new ArrayList<>();
        for (FileSystemItem file : fileSystem.getCurrentDirectory().getFileSystemItems()) {
            files.add(file.getName());
        }
        return files;
    }

    private boolean isInvalidInput(String[] args) {
        return (args.length != 0 && args.length != 1) || (args.length == 1 && !args[0].equals("--ord=asc") && !args[0].equals("--ord=desc"));
    }
}
