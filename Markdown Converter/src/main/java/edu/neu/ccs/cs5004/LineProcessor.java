package edu.neu.ccs.cs5004;

/**
 * Represents lineProcessor interface.
 *
 * @author Liang
 */
public interface LineProcessor {
  /**
   * Do procession to the line.
   *
   * @param line to be processed
   * @return the new line after procession
   */
  String process(String line);
}
