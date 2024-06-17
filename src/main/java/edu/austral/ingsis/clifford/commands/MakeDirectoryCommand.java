package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.filesystem.Directory;

public class MakeDirectoryCommand implements Command {
  private final FileSystem fileSystem;

  public MakeDirectoryCommand(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public String execute(String[] args) {
    if (isInvalidInput(args)) {
      return "Invalid input";
    }
    fileSystem
        .getCurrentDirectory()
        .addFileSystemItem(new Directory(args[0], fileSystem.getCurrentDirectory()));
    return "'" + args[0] + "' directory created";
  }

  private boolean isInvalidInput(String[] args) {
    return (args.length != 1) || (args[0].contains("/") || args[0].contains(" "));
  }
}
