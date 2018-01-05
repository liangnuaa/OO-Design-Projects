package edu.neu.ccs.cs5004;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents ReadTxt interface.
 *
 * @author Liang
 */
class ReadTxt implements ReadFile {
  public List<String> convertFile(String file) throws FileNotFoundException {
    BufferedReader inputFile = null;
    List<String> res = new ArrayList<>();
    try {
      inputFile = new BufferedReader(new InputStreamReader(new FileInputStream(file),
          StandardCharsets.UTF_8));
      String line;
      while ((line = inputFile.readLine()) != null) {
        res.add(line);
      }
    } catch (FileNotFoundException fnfe) {
      throw fnfe;
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    } finally {
      if (inputFile != null) {
        try {
          inputFile.close();
        } catch (IOException e) {
          System.out.println("Failed to close input stream in finally block");
          e.printStackTrace();
        }
      }
    }
    return res;
  }
}
