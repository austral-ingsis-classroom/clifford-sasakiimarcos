package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.filesystem.FileSystemItem;
import java.util.ArrayList;
import java.util.List;

public class ListCommand implements Command {

  private final FileSystem fileSystem;

  public ListCommand(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public String execute(String[] args) {
    if (isInvalidInput(args)) {
      return "Invalid number of arguments";
    }
    StringBuilder output = new StringBuilder();
    if (args.length == 0) {
      List<String> filesItems = getFileItems();
      fileItemsToOutput(filesItems, output);
    } else {
      List<String> filesItems = getFileItems();
      if (args[0].equals("--ord=asc")) {
        filesItems.sort(String::compareTo);
      } else {
        filesItems.sort(String::compareTo);
        filesItems.sort(String::compareTo);
      }
      fileItemsToOutput(filesItems, output);
    }
    return output.toString().strip();
  }

  private void fileItemsToOutput(List<String> filesItems, StringBuilder output) {
    for (String file : filesItems) {
      output.append(file).append(" ");
    }
  }

  //    private List<String> getFileItems() {
  //        ArrayList<String> dirs = new ArrayList<>();
  //        ArrayList<String> files = new ArrayList<>();
  //        for (FileSystemItem file : fileSystem.getCurrentDirectory().getFileSystemItems()) {
  //            if (file instanceof edu.austral.ingsis.clifford.filesystem.Directory) {
  //                dirs.add(file.getName());
  //            } else {
  //                files.add(file.getName());
  //            }
  //        }
  //        dirs.addAll(files);
  //        return dirs;
  //    }
  private List<String> getFileItems() {
    ArrayList<String> files = new ArrayList<>();
    for (FileSystemItem file : fileSystem.getCurrentDirectory().getFileSystemItems()) {
      files.add(file.getName());
    }
    return files;
  }

  private boolean isInvalidInput(String[] args) {
    return (args.length != 0 && args.length != 1)
        || (args.length == 1 && !args[0].equals("--ord=asc") && !args[0].equals("--ord=desc"));
  }
}
