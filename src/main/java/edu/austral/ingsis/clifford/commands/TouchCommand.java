package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.filesystem.File;

public class TouchCommand implements Command {

  private FileSystem fileSystem;

  public TouchCommand(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public String execute(String[] args) {
    if (isInvalidInput(args)) {
      return "Invalid input";
    }
    if (!exists(args[0])) {
      fileSystem
          .getCurrentDirectory()
          .addFileSystemItem(new File(args[0], fileSystem.getCurrentDirectory()));
    }
    return "'" + args[0] + "' file created";
  }

  private boolean isInvalidInput(String[] args) {
    return (args.length != 1) || (args[0].contains("/") || args[0].contains(" "));
  }

  private boolean exists(String name) {
    return fileSystem.getCurrentDirectory().getFileSystemItems().stream()
        .anyMatch(file -> file.getName().equals(name));
  }
}
