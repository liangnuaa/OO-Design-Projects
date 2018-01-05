package edu.neu.ccs.cs5004.MainBBTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import edu.neu.ccs.cs5004.InvalidInputException;
import edu.neu.ccs.cs5004.Main;

import static org.junit.Assert.*;

/**
 * Created by zhang on 3/27/2017.
 */
public class MainBBTest {
  @Test
  public void mainTestEmail() throws Exception {
    String commandEmail = "--email --email-template email-template.txt --output-dir emails --csv-file theater-company-members.csv";
    Main.main(commandEmail.split(" "));
  }

  @Test
  public void mainTestLetter() throws Exception {
    String commandLetter = "--letter --letter-template email-template.txt --output-dir Letter --csv-file theater-company-members.csv";
    Main.main(commandLetter.split(" "));
  }

  // --letter provided, but no --letter-template command
  @Test(expected = InvalidInputException.class)
  public void mainTestError1() throws Exception {
    String command = "--letter --email-template email-template.txt --output-dir emails --csv-file theater-company-members.csv";
    Main.main(command.split(" "));
  }

  //command should have 7 parts
  @Test(expected = InvalidInputException.class)
  public void mainTestError2() throws Exception {
    String command = "--letter-template email-template.txt --output-dir emails --csv-file theater-company-members.csv";
    Main.main(command.split(" "));
  }

  // --email provided, but no --email-template command
  @Test(expected = InvalidInputException.class)
  public void mainTestError3() throws Exception {
    String command = "--email --letter-template email-template.txt --output-dir emails --csv-file theater-company-members.csv";
    Main.main(command.split(" "));
  }

  //output-dir not provided
  @Test(expected = InvalidInputException.class)
  public void mainTestError7() throws Exception {
    String command = "--letter --letter-template email-template.txt --dir emails --csv-file theater-company-members.csv";
    Main.main(command.split(" "));
  }

  //--csv-file not provided
  @Test(expected = InvalidInputException.class)
  public void mainTestError8() throws Exception {
    String command = "--letter --letter-template email-template.txt --output-dir emails --csv theater-company-members.csv";
    Main.main(command.split(" "));
  }

  //--csv-file not provided
  @Test(expected = InvalidInputException.class)
  public void mainTestError9() throws Exception {
    String command = "--email --email-template --output-dir emails --csv-file theater-company-members.csv email-template.txt";
    Main.main(command.split(" "));
  }

  //command is null
  @Test(expected = InvalidInputException.class)
  public void mainTestError10() throws Exception {
    String[] command = null;
    Main.main(command);
  }

  @Test(expected = FileNotFoundException.class)
  public void mainTestError4() throws Exception {
    String command = "--letter --letter-template email-template.txt --output-dir emails --csv-file members.csv";
    Main.main(command.split(" "));
  }

  @Test(expected = FileNotFoundException.class)
  public void mainTestError5() throws Exception {
    String command = "--letter --letter-template template.txt --output-dir emails --csv-file theater-company-members.csv";
    Main.main(command.split(" "));
  }

  @Test(expected = FileNotFoundException.class)
  public void mainTestError6() throws Exception {
    String commandEmail = "--email --email-template email-template.txt --output-dir C:\\Users\\noexist\\Desktops\\output --csv-file theater-company-members.csv";
    Main.main(commandEmail.split(" "));
  }
}
