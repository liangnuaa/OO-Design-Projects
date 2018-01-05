package edu.neu.ccs.cs5004;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents CheckCommandAndGetFileName class.
 *
 * @author Liang
 */
class CheckCommandAndGetFileName {
  private List<String> command = new ArrayList<>();

  public CheckCommandAndGetFileName(String[] args) {
    if (args == null || args.length != 7) {
      throw new InvalidInputException("input command should consist of 7 parts,");
    }
    for (int i = 0; i < args.length; i++) {
      command.add(args[i]);
    }
  }

  public List<String> getCommand() {
    return command;
  }

  public void checkCommandLine() {
    if (command.contains("--email") && !command.contains("--email-template")) {
      throw new InvalidInputException(" Error: --email provided but no --email-template "
          + "was given. ");
    }
    if (command.contains("--letter") && !command.contains("--letter-template")) {
      throw new InvalidInputException(" Error: --letter provided but no "
          + "--letter-template was given.");
    }
    if (!command.contains("--output-dir")) {
      throw new InvalidInputException(" Error: should give output path");
    }
    if (!command.contains("--csv-file")) {
      throw new InvalidInputException(" Error: should give cvs file path");
    }
  }

  public String getCsvFileName() {
    return getCommand().get(getCommand().indexOf("--csv-file") + 1);
  }

  public String getOutputPath() {
    return getCommand().get(getCommand().indexOf("--output-dir") + 1);
  }

  public String getTemplateFileName() {
    for (int i = 0; i < command.size(); i++) {
      if (command.get(i).matches(".*template") && i < command.size() - 1
          && command.get(i + 1).matches(".*.txt")) {
        return command.get(i + 1);
      }
    }
    throw new InvalidInputException("template file name should follow "
        + "immediately after template command");
  }
}
