package edu.neu.ccs.cs5004;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * Represents ReadAndWrite class.
 *
 * @author Liang
 */
public class ReadAndWrite {
  private String cvsFile;
  private String outputPath;
  private String templateFile;

  /**
   * Create a new ReadAndWrite class.
   *
   * @param cvsFile      cvs file path
   * @param outputPath   output path
   * @param templateFile template file path
   */
  public ReadAndWrite(String cvsFile, String outputPath, String templateFile) {
    this.cvsFile = cvsFile;
    this.outputPath = outputPath;
    this.templateFile = templateFile;
  }

  /**
   * Read from template and csv file and write to output file.
   *
   * @throws FileNotFoundException when csv file or output file is not found
   */
  public void operate() throws FileNotFoundException {
    ReadCsvFileAndTemplate convert = new ReadCsvFileAndTemplate();
    Populate populate = new Populate();
    List<Map<String, String>> listOfMap;
    List<String> listOfString;
    try {
      listOfMap = convert.convertCsv(cvsFile);
      listOfString = convert.convertTemplate(templateFile);
    } catch (FileNotFoundException fnfe) {
      throw fnfe;
    }

    try {
      populate.populate(listOfMap, listOfString, outputPath);
    } catch (FileNotFoundException fnfe) {
      throw fnfe;
    }
  }
}
