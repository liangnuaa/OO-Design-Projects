package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.testutils.TestUtils;

import static org.junit.Assert.*;

/**
 * Created by zhang on 4/9/2017.
 */
public class GuessTest extends TestUtils {
  Guess g1;
  Guess g2;
  Guess g3;
  Guess g4;

  @Before
  public void setUp() throws Exception {
    g1 = new Guess(6);
    g2 = new Guess(6);
    g3 = new Guess(6);
    g4 = new Guess(7);
  }

  @Test
  public void setToInitialState() throws Exception {
    g1.setToInitialState(8);
    Assert.assertEquals(g1.getRemainingTimes(), new Integer(8));
  }

  @Test
  public void signUpViewer() throws Exception {
    KeyWord keyWord = new KeyWord("dog");
    GuessViewer guessViewer = new GuessTimeDisplay(g1, keyWord);
    GuessViewer guessViewer2 = new GuessTimeDisplay(g1, keyWord);
    g1.signUpViewer(guessViewer);
    g1.signUpViewer(guessViewer2);
    Assert.assertEquals(g1.getViewerList().get(0), guessViewer);
    g1.decreaseTime();
  }

  @Test
  public void decreaseTime() throws Exception {
    g1.decreaseTime();
    Assert.assertEquals(g1.getRemainingTimes(), new Integer(5));
  }

  @Test
  public void equalsAndHashCodeTest() throws Exception {
    GuessTest guessTest = new GuessTest();
    guessTest.isEqualsContractValid(g1, g2, g3, g4);
  }

  @Test
  public void toStringTest() throws Exception {
    Assert.assertEquals(g1.toString(), "Guess{remainingTimes=6, viewerList=[]}");
  }

  @Test(expected = IllegalArgumentException.class)
  public void InvalidTest() throws Exception {
    g1 = new Guess(-1);
  }
}