package edu.neu.ccs.cs5004;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 3/31/2017.
 */
public interface Main {
  /**
   * Given the String array command to complete required operations.
   * @param args String array
   * @throws FileNotFoundException if file is not found, throw FileNotFoundException
   */
  static void main(String[] args) throws FileNotFoundException {
    if (args == null || args.length != 2) {
      throw new InvalidCommandException("the input command should be a input "
          + "file name and output file name with their paths");
    }
    ReadFile readFile = new ReadTxt();
    List<String> content = readFile.convertFile(args[0]);
    ContentHandler contentHandler = new ContentHandler(new ArrayList<>());
    contentHandler.handle(content);
    WriteFile writeFile = new WriteToTxt();
    writeFile.writeToFile(args[1], contentHandler.getOutputContent());
  }
}
