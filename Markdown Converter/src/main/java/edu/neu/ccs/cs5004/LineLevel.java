package edu.neu.ccs.cs5004;

/**
 * Represents the LineLevel class.
 *
 * @author Liang
 */
class LineLevel {
  /**
   * Get the level of given line.
   *
   * @param line given line
   * @return the level of given line
   */
  public int level(String line) {
    int index = 0;
    while (line.charAt(index) == ' ') {
      index++;
    }
    if (index != 0 && index % 2 != 0) {
      throw new InvalidContentException("the space before list or enumeration "
          + "should be even number");
    }
    return index / 2 + 1;
  }
}
