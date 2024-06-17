package edu.austral.ingsis.clifford.filesystem;

import java.util.ArrayList;

public class Directory implements FileSystemItem {
  private ArrayList<FileSystemItem> files;
  private String name;
  private Directory parent;

  public Directory(String name, Directory parent) {
    this.name = name;
    this.files = new ArrayList<>();
    this.parent = parent;
  }

  public void addFileSystemItem(FileSystemItem file) {
    files.add(file);
    file.setParent(this);
  }

  public void removeFileSystemItem(String name) {
    for (FileSystemItem file : files) {
      if (file.getName().equals(name)) {
        files.remove(file);
        return;
      }
    }
  }

  public ArrayList<FileSystemItem> getFileSystemItems() {
    return files;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Directory getParent() {
    return parent;
  }

  @Override
  public void setParent(Directory parent) {
    this.parent = parent;
  }
}
