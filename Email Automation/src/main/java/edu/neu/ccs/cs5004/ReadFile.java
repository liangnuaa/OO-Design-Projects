package edu.neu.ccs.cs5004;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 3/28/2017.
 */
public interface ReadFile {
  /**
   * Convert the information of cvs file to a list of maps.
   *
   * @param csvFile given cvs file path
   * @return a list of maps convertCsv from cvs file
   * @throws FileNotFoundException when the given file does not exist
   */
  List<Map<String, String>> convertCsv(String csvFile) throws FileNotFoundException;

  List<String> convertTemplate(String template) throws FileNotFoundException;
}
