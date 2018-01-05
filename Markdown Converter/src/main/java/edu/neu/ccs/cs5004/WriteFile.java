package edu.neu.ccs.cs5004;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Represents WriteFile interface.
 *
 * @author Liang
 */
public interface WriteFile {
  /**
   * Write the content of list of Strings to output file.
   * @param file given file name
   * @param list the list of Strings need to be write to the file
   * @throws FileNotFoundException if file is not found, throw FileNotFoundException
   */
  void writeToFile(String file, List<String> list) throws FileNotFoundException;
}
