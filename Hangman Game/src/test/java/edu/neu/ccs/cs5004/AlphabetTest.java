package edu.neu.ccs.cs5004;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import edu.neu.ccs.cs5004.testutils.TestUtils;

import static org.junit.Assert.*;

/**
 * Created by zhang on 4/9/2017.
 */
public class AlphabetTest extends TestUtils {
  Alphabet a1;
  Alphabet a2;
  Alphabet a3;
  Alphabet a4;
  Map<Character, Boolean> map;

  @Before
  public void setUp() throws Exception {
    a1 = new Alphabet();
    a2 = new Alphabet();
    a3 = new Alphabet();
    a4 = new Alphabet();
    a4.getMap().put('q', true);
    map = new HashMap<Character, Boolean>() {{
      put('a', false);
      put('b', false);
      put('c', false);
      put('d', false);
      put('e', false);
      put('f', false);
      put('g', false);
      put('h', false);
      put('i', false);
      put('j', false);
      put('k', false);
      put('l', false);
      put('m', false);
      put('n', false);
      put('o', false);
      put('p', false);
      put('q', false);
      put('r', false);
      put('s', false);
      put('t', false);
      put('u', false);
      put('v', false);
      put('w', false);
      put('x', false);
      put('y', false);
      put('z', false);
    }};
  }

  @Test
  public void setToInitialState() throws Exception {
    a1.getMap().put('a', true);
    a1.getMap().put('b', true);
    a1.getMap().put('c', true);
    a1.setToInitialState();
    Assert.assertEquals(a1.getMap(), map);
  }

  @Test
  public void setLetter() throws Exception {
    a1.setLetter('b');
    Assert.assertTrue(a1.getMap().get('b'));
  }

  @Test
  public void signUpViewer() throws Exception {
    AlphabetViewer alphabetViewer = new AlphabetDisplay(a1);
    AlphabetViewer alphabetViewer2 = new AlphabetDisplay(a1);
    a1.signUpViewer(alphabetViewer);
    a1.signUpViewer(alphabetViewer2);
    Assert.assertEquals(a1.getAlphabetViewerList().get(0), alphabetViewer);
    a1.setLetter('d');
  }

  @Test
  public void equalsAndHashCodeTest() throws Exception {
    AlphabetTest alphabetTest = new AlphabetTest();
    alphabetTest.isEqualsContractValid(a1, a2, a3, a4);
  }

  @Test
  public void toStringTest() throws Exception {
    Assert.assertEquals(a1.toString(),
        "Alphabet{map={a=false, b=false, c=false, d=false, e=false, f=false, g=false, h=false, i=false, j=false, k=false, l=false, m=false, n=false, o=false, p=false, q=false, r=false, s=false, t=false, u=false, v=false, w=false, x=false, y=false, z=false}, alphabetViewerList=[]}");
  }

}