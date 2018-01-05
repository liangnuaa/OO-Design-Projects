package edu.neu.ccs.cs5004;

/**
 * Represents invalid command exception.
 *
 * @author Liang
 */
public class InvalidContentException extends RuntimeException {
  public InvalidContentException(String str) {
    super(str);
  }
}
