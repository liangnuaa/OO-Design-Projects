package edu.neu.ccs.cs5004;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create the Populate class.
 *
 * @author Liang
 */
class Populate implements WriteFile {
  public void populate(List<Map<String, String>> listOfMap, List<String>
      listOfString, String output) throws FileNotFoundException {
    for (int i = 0; i < listOfMap.size(); i++) {
      populateOneFile(listOfMap.get(i), listOfString, output + i);
    }
  }

  public void populateOneFile(Map<String, String> map, List<String>
      listOfString, String output) throws FileNotFoundException {
    BufferedWriter outputFile = null;

    try {
      outputFile = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream(output), StandardCharsets.UTF_8));
      String line;

      for (int i = 0; i < listOfString.size(); i++) {
        line = populateLine(listOfString.get(i), map);
        outputFile.write(line + "\n");
      }
    } catch (FileNotFoundException fnfe) {
      throw fnfe;
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    } finally {
      if (outputFile != null) {
        try {
          outputFile.close();
        } catch (IOException e) {
          System.out.println("Failed to close input stream in finally block");
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * Populate new line to output file.
   *
   * @param line from template
   * @return new line to be populated to output file
   */
  public String populateLine(String line, Map<String, String> map) {
    Pattern pattern = Pattern.compile("\\[\\[[^\\]]*\\]\\]");
    Matcher matcher = pattern.matcher(line);
    while (matcher.find()) {
      if (map.containsKey("\"" + matcher.group().substring(2,
          matcher.group().length() - 2) + "\"")) {
        line = line.replace(matcher.group(), map.get("\""
            + matcher.group().substring(2, matcher.group().length() - 2) + "\""));
      }
    }
    return line;
  }
}
