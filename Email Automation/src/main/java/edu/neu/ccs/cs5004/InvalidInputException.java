package edu.neu.ccs.cs5004;

/**
 * Represents invalid input command exception.
 *
 * @author Liang
 */
public class InvalidInputException extends RuntimeException {
  public InvalidInputException(String str) {
    super(str);
  }
}
