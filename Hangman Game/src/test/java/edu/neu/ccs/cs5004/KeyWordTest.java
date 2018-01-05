package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.testutils.TestUtils;

import static org.junit.Assert.*;

/**
 * Created by zhang on 4/9/2017.
 */
public class KeyWordTest extends TestUtils {
  KeyWord k1;
  KeyWord k2;
  KeyWord k3;
  KeyWord k4;

  @Before
  public void setUp() throws Exception {
    k1 = new KeyWord("dog");
    k2 = new KeyWord("dog");
    k3 = new KeyWord("dog");
    k4 = new KeyWord("cat");
  }

  @Test
  public void setToInitialState() throws Exception {
    k1.getBooleanList().set(1, true);
    k1.setToInitialState("dog");
    Assert.assertEquals(k1, k2);
  }

  @Test
  public void isContain() throws Exception {
    Assert.assertTrue(k1.isContain('o'));
  }

  @Test
  public void changeCharacterState() throws Exception {
    k1.changeCharacterState('d');
    Assert.assertTrue(k1.getBooleanList().get(0));
  }

  @Test
  public void isWin() throws Exception {
    Assert.assertFalse(k1.isWin());
    k2.changeCharacterState('d');
    k2.changeCharacterState('o');
    k2.changeCharacterState('g');
    Assert.assertTrue(k2.isWin());
  }

  @Test
  public void signUpViewer() throws Exception {
    KeyWordViewer keyWordViewer = new KeyWordDisplay(k1);
    KeyWordViewer keyWordViewer2 = new KeyWordDisplay(k1);
    k1.signUpViewer(keyWordViewer);
    k1.signUpViewer(keyWordViewer2);
    Assert.assertEquals(k1.getViewerList().get(0), keyWordViewer);
    k1.changeCharacterState('d');
  }

  @Test
  public void equalsAndHashCodeTest() throws Exception {
    KeyWordTest keyWordTest = new KeyWordTest();
    keyWordTest.isEqualsContractValid(k1, k2, k3, k4);
  }

  @Test
  public void toStringTest() throws Exception {
    Assert.assertEquals(k1.toString(), "KeyWord{wordList=[d, o, g], viewerList=[], booleanList=[false, false, false]}");

  }

  @Test(expected = IllegalArgumentException.class)
  public void InvalidTest() throws Exception {
    k1 = new KeyWord("");
  }

}