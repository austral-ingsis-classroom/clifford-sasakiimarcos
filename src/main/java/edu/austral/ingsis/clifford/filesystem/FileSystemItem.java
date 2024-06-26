package edu.austral.ingsis.clifford.filesystem;

public interface FileSystemItem {
  String getName();

  Directory getParent();

  void setParent(Directory parent);
}
