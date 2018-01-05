package edu.neu.ccs.cs5004;

/**
 * Represents ItemizationProcessor class.
 *
 * @author Liang
 */
class ItemizationProcessor implements LineProcessor {
  public String process(String line) {
    for (int i = 0; i < line.length(); i++) {
      if (line.charAt(i) == '*' || line.charAt(i) == '+' || line.charAt(i) == '-') {
        line = line.substring(0, i) + '*' + line.substring(i + 1);
        break;
      }
    }
    return line;
  }
}
