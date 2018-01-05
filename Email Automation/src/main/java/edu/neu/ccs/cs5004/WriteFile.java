package edu.neu.ccs.cs5004;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 3/28/2017.
 */
public interface WriteFile {
  /**
   * Populate new line to output file.
   *
   * @param line from template
   * @return new line to be populated to output file
   */
  String populateLine(String line, Map<String, String> map);

  void populateOneFile(Map<String, String> map, List<String>
      listOfString, String output) throws FileNotFoundException;

  void populate(List<Map<String, String>> listOfMap, List<String>
      listOfString, String output) throws FileNotFoundException;
}
