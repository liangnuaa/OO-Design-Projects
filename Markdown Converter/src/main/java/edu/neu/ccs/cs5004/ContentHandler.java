package edu.neu.ccs.cs5004;

import java.util.List;

/**
 * Represents ContentHandler class.
 *
 * @author Liang
 */
class ContentHandler {
  private List<String> outputContent;
  private LineProcessor lineProcessor;

  public ContentHandler(List<String> list) {
    outputContent = list;
  }

  /**
   * Getter for 'outputContent'.
   *
   * @return the outputContent
   */
  public List<String> getOutputContent() {
    return outputContent;
  }

  /**
   * Do procession to each string of the list according to their categories.
   *
   * @param content list of Strings to be processed.
   */
  public void handle(List<String> content) {
    for (int i = 0; i < content.size(); i++) {
      if (isHeader(content.get(i))) {
        lineProcessor = new HeaderProcessor();
        outputContent.add(lineProcessor.process(content.get(i)));
        continue;
      }

      if (isItemization(content.get(i))) {
        if (i < content.size() - 1 && isNextLineLegal(content.get(i), content.get(i + 1))) {
          lineProcessor = new ItemizationProcessor();
        }
        outputContent.add(lineProcessor.process(content.get(i)));
        continue;
      }

      if (isEnumeration(content.get(i))) {
        if (i < content.size() - 1 && isNextLineLegal(content.get(i), content.get(i + 1))) {
          lineProcessor = new EnumerationProcessor();
        }
        if (i == 0 || content.get(i - 1).trim().isEmpty()) {
          EnumerationProcessor.createNewMap();
        }
        outputContent.add(lineProcessor.process(content.get(i)));
        continue;
      }

      lineProcessor = new DummyProcessor();
      outputContent.add(lineProcessor.process(content.get(i)));
    }
  }

  /**
   * Check if a line belong to header.
   *
   * @param line to be checked
   * @return true if the line is a head, otherwise false
   */
  public Boolean isHeader(String line) {
    return line.matches("#+.*");
  }

  /**
   * Check if a line belong to itemization.
   *
   * @param line to be checked
   * @return true if the line is a itemization, otherwise false
   */
  public Boolean isItemization(String line) {
    return line.matches("^ *(\\+|\\*|\\-).*");
  }

  /**
   * Check if a line belong to enumeration.
   *
   * @param line to be checked
   * @return true if the line is a enumeration, otherwise false
   */
  public Boolean isEnumeration(String line) {
    return line.matches("^ *1?\\..*");
  }

  /**
   * Check if next line is valid.
   *
   * @param line1 the current line
   * @param line2 the next line to be checked
   * @return true if the next line if valid, otherwise false
   */
  public Boolean isNextLineLegal(String line1, String line2) {
    if (line2.trim().isEmpty()) {
      return true;
    }
    LineLevel lineLevel = new LineLevel();
    int level1 = lineLevel.level(line1);
    int level2 = lineLevel.level(line2);
    if (isEnumeration(line1)) {
      if (isEnumeration(line2)) {
        if (Math.abs(level1 - level2) > 1) {
          throw new InvalidContentException("you should not skip nesting level");
        }
      } else if (isItemization(line2)) {
        if (level1 == level2) {
          throw new InvalidContentException("you cannot switch one style of list to"
              + "another at the same level");
        }
        if (Math.abs(level1 - level2) > 1) {
          throw new InvalidContentException("you should not skip nesting level");
        }
      }
    } else if (isItemization(line1) && Math.abs(level1 - level2) > 1) {
      throw new InvalidContentException("you should not skip nesting level");
    }
    return true;
  }
}
