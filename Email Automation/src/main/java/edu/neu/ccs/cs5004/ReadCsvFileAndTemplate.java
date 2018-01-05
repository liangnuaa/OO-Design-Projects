package edu.neu.ccs.cs5004;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents ConvertCVS class, which convertCsv the information of cvs file to a list of maps.
 *
 * @author Liang
 */
class ReadCsvFileAndTemplate implements ReadFile {
  public List<Map<String, String>> convertCsv(String csvFile) throws FileNotFoundException {
    BufferedReader inputFile = null;
    List<Map<String, String>> res = new ArrayList<>();
    String[] header = null;

    try {
      inputFile = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile),
          StandardCharsets.UTF_8));
      String line;
      if ((line = inputFile.readLine()) != null) {
        header = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
      }

      while ((line = inputFile.readLine()) != null) {
        String[] lineArray = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        if (lineArray.length == header.length) {
          Map<String, String> map = new HashMap<>();
          for (int i = 0; i < header.length; i++) {
            map.put(header[i], lineArray[i]);
          }
          res.add(map);
        }
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

  public List<String> convertTemplate(String template) throws FileNotFoundException {
    BufferedReader inputFile = null;
    List<String> listOfString = new ArrayList<>();

    try {
      inputFile = new BufferedReader(new InputStreamReader(
          new FileInputStream(template), StandardCharsets.UTF_8));
      String line;

      while ((line = inputFile.readLine()) != null) {
        listOfString.add(line);
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
    return listOfString;
  }
}
