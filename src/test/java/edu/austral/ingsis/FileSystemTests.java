package edu.austral.ingsis;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileSystemTests {

  private final FileSystemRunner runner = new MyFileSystemRunner();

  private void executeTest(List<Map.Entry<String, String>> commandsAndResults) {
    final List<String> commands = commandsAndResults.stream().map(Map.Entry::getKey).toList();
    final List<String> expectedResult = commandsAndResults.stream().map(Map.Entry::getValue).toList();

    final List<String> actualResult = runner.executeCommands(commands);

    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void test1() {
    executeTest(List.of(
            entry("ls", ""),
            entry("mkdir horace", "'horace' directory created"),
            entry("ls", "horace"),
            entry("mkdir emily", "'emily' directory created"),
            entry("ls", "horace emily"),
            entry("ls --ord=asc", "emily horace")
    ));
  }

  @Test
  void test2() {
    executeTest(List.of(
            entry("mkdir horace", "'horace' directory created"),
            entry("mkdir emily", "'emily' directory created"),
            entry("mkdir jetta", "'jetta' directory created"),
            entry("ls", "horace emily jetta"),
            entry("cd emily", "moved to directory 'emily'"),
            entry("pwd", "/emily"),
            entry("touch elizabeth.txt", "'elizabeth.txt' file created"),
            entry("mkdir t-bone", "'t-bone' directory created"),
            entry("ls", "elizabeth.txt t-bone")
    ));
  }

  @Test
  void test3() {
    executeTest(List.of(
            entry("mkdir horace", "'horace' directory created"),
            entry("mkdir emily", "'emily' directory created"),
            entry("mkdir jetta", "'jetta' directory created"),
            entry("cd emily", "moved to directory 'emily'"),
            entry("touch elizabeth.txt", "'elizabeth.txt' file created"),
            entry("mkdir t-bone", "'t-bone' directory created"),
            entry("touch elizabeth.txt", "'elizabeth.txt' file created"),
            entry("ls", "elizabeth.txt t-bone"),
            entry("rm t-bone", "cannot remove 't-bone', is a directory"),
            entry("rm --recursive t-bone", "'t-bone' removed"),
            entry("ls", "elizabeth.txt"),
            entry("rm elizabeth.txt", "'elizabeth.txt' removed"),
            entry("ls", "")
    ));
  }

  @Test
  void test4() {
    executeTest(List.of(
            entry("mkdir horace", "'horace' directory created"),
            entry("mkdir emily", "'emily' directory created"),
            entry("cd horace", "moved to directory 'horace'"),
            entry("mkdir jetta", "'jetta' directory created"),
            entry("cd ..", "moved to directory '/'"),
            entry("cd horace/jetta", "moved to directory 'jetta'"),
            entry("pwd", "/horace/jetta"),
            entry("cd /", "moved to directory '/'")
    ));
  }

  @Test
  void test5() {
    executeTest(List.of(
            entry("mkdir emily", "'emily' directory created"),
            entry("cd horace", "'horace' directory does not exist")
    ));
  }

  @Test
  void test6() {
    executeTest(List.of(
            entry("cd ..", "moved to directory '/'")
    ));
  }

  @Test
  void test7() {
    executeTest(List.of(
            entry("mkdir horace", "'horace' directory created"),
            entry("cd horace", "moved to directory 'horace'"),
            entry("touch emily.txt", "'emily.txt' file created"),
            entry("touch jetta.txt", "'jetta.txt' file created"),
            entry("ls", "emily.txt jetta.txt"),
            entry("rm emily.txt", "'emily.txt' removed"),
            entry("ls", "jetta.txt")
    ));
  }

  @Test
  void test8() {
    executeTest(List.of(
            entry("mkdir emily", "'emily' directory created"),
            entry("cd emily", "moved to directory 'emily'"),
            entry("mkdir emily", "'emily' directory created"),
            entry("touch horace.txt", "'horace.txt' file created"),
            entry("touch jetta.txt", "'jetta.txt' file created"),
            entry("ls", "emily horace.txt jetta.txt"),
            entry("rm --recursive emily", "'emily' removed"),
            entry("ls", "horace.txt jetta.txt"),
            entry("ls --ord=desc", "horace.txt jetta.txt")
    ));
  }
}
