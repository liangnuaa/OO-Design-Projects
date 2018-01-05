package edu.neu.ccs.cs5004;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents EnumerationProcessor Class.
 *
 * @author Liangs
 */
class EnumerationProcessor implements LineProcessor {
  static Map<Integer, Integer> map;

  public String process(String line) {
    Pattern pattern = Pattern.compile("(1?\\.)");
    Matcher matcher = pattern.matcher(line);
    String head = "";
    if (matcher.find()) {
      head = matcher.group(1);
    }
    StringBuilder res = new StringBuilder();
    LineLevel lineLevel = new LineLevel();
    int level = lineLevel.level(line);
    int index = 0;
    if (!map.containsKey(level)) {
      index = 1;
      map.put(level, 1);
    } else {
      index = map.get(level) + 1;
      map.put(level, index);
    }
    if (level % 2 == 0) {
      res.append(numberToCharacter(index));
    } else {
      res.append(index);
    }
    res.append(".");
    return line.replaceFirst(head, res.toString());
  }

  /**
   * Convert number to Character.
   * @param index to be converted
   * @return the converted result
   */
  public String numberToCharacter(int index) {
    StringBuilder stringBuilder = new StringBuilder();

    while (index > 0) {
      index--;
      char character = (char) (index % 26 + 'a');
      index /= 26;
      stringBuilder.append(character);
    }

    stringBuilder.reverse();
    return stringBuilder.toString();
  }

  /**
   * Create a new static map.
   */
  public static void createNewMap() {
    EnumerationProcessor.map = new HashMap<>();
  }
}
