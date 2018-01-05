package edu.neu.ccs.cs5004;

import java.io.FileNotFoundException;

/**
 * Represents the main class, which accept the command and get other method to<br>
 * complete the operation.
 *
 * @author Liang
 */
public interface Main {
  /**
   * Main method of the interface.
   *
   * @param args input command
   * @throws FileNotFoundException when file is not found
   */
  static void main(String[] args) throws FileNotFoundException {
    CheckCommandAndGetFileName cmd = new CheckCommandAndGetFileName(args);
    cmd.checkCommandLine();

    String cvsFile = cmd.getCsvFileName();
    String outputPath = cmd.getOutputPath();
    String templateFile = cmd.getTemplateFileName();

    ReadAndWrite raw = new ReadAndWrite(cvsFile, outputPath, templateFile);
    raw.operate();
  }
}
