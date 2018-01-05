package edu.neu.ccs.cs5004;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhang on 4/1/2017.
 */
public class MainTest {
  String[] args1;
  String[] args2;
  String[] args3;
  String[] args4;
  String[] args5;
  String[] args6;
  String[] args7;

  @Before
  public void setUp() throws Exception {
    args1 = new String[]{"input1.txt", "output1.txt"};
    args2 = new String[]{"input2.txt", "output2.txt"};
    args3 = new String[]{"input3.txt", "output3.txt"};
    args4 = new String[]{"input4.txt"};
    args5 = new String[]{"input5.txt", "output5.txt"};
    args6 = new String[]{"input6.txt", "output6.txt"};
    args7 = new String[]{"input7.txt", "output7.txt"};
  }

  @Test
  public void mainTest1() throws Exception {
    Main.main(args1);
  }

  @Test
  public void mainTest2() throws Exception {
    Main.main(args2);
  }

  @Test(expected = InvalidContentException.class)
  public void mainTest3() throws Exception {
    Main.main(args3);
  }

  @Test(expected = InvalidCommandException.class)
  public void mainTest4() throws Exception {
    Main.main(args4);
  }

  @Test(expected = InvalidContentException.class)
  public void mainTest5() throws Exception {
    Main.main(args5);
  }

  @Test(expected = InvalidContentException.class)
  public void mainTest6() throws Exception {
    Main.main(args6);
  }

  @Test(expected = InvalidContentException.class)
  public void mainTest7() throws Exception {
    Main.main(args7);
  }
}