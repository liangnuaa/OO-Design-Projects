package edu.neu.ccs.cs5004;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents HeaderProcessor class.
 *
 * @author Liang
 */
class HeaderProcessor implements LineProcessor {
  public static Map<Integer, Integer> map = new HashMap<>();

  public String process(String line) {
    Pattern pattern = Pattern.compile("(#+)");
    Matcher matcher = pattern.matcher(line);
    String head = "";
    if (matcher.find()) {
      head = matcher.group(1);
    }
    StringBuilder res = new StringBuilder();
    for (int i = head.length() - 1; i >= 0; i--) {
      if (!map.containsKey(i + 1)) {
        res.insert(0, 1);
        map.put(i + 1, 1);
      } else {
        if (i + 1 == head.length()) {
          res.insert(0, map.get(i + 1) + 1);
          map.put(i + 1, map.get(i + 1) + 1);
        } else {
          res.insert(0, map.get(i + 1));
        }
      }
      if (i + 1 != 1) {
        res.insert(0, '.');
      }
    }
    return line.replaceFirst(head, res.toString());
  }
}
