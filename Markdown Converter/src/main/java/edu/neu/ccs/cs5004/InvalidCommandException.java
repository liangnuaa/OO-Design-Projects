package edu.neu.ccs.cs5004;

/**
 * Represents invalid command exception.
 *
 * @author Liang
 */
public class InvalidCommandException extends RuntimeException {
  public InvalidCommandException(String str) {
    super(str);
  }
}
