package edu.neu.ccs.cs5004;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created by zhang on 3/31/2017.
 */
class WriteToTxt implements WriteFile {
  public void writeToFile(String file, List<String> list) throws FileNotFoundException {
    BufferedWriter outputFile = null;
    try {
      outputFile = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream(file), StandardCharsets.UTF_8));
      for (int i = 0; i < list.size(); i++) {
        outputFile.write(list.get(i) + "\n");
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
}
