package edu.neu.ccs.cs5004;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Represents ReadFile interface.
 *
 * @author Liang
 */
public interface ReadFile {
  /**
   * Convert the content to a list of string.
   * @param file to be read
   * @return a list of string
   * @throws FileNotFoundException if file is not found, throw FileNotFoundException
   */
  List<String> convertFile(String file) throws FileNotFoundException;
}
