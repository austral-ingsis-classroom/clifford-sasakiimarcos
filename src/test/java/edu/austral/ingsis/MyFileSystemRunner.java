package edu.austral.ingsis;

import edu.austral.ingsis.clifford.CommandLine;
import java.util.ArrayList;
import java.util.List;

public class MyFileSystemRunner implements FileSystemRunner {
  @Override
  public List<String> executeCommands(List<String> commands) {
    CommandLine cli = new CommandLine();
    ArrayList<String> output = new ArrayList<>();
    for (String command : commands) {
      output.add(cli.execute(command));
    }
    return output;
  }
}
