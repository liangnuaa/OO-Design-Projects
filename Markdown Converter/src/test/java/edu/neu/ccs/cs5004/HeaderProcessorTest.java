package edu.neu.ccs.cs5004;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhang on 4/1/2017.
 */
public class HeaderProcessorTest {
  HeaderProcessor hp;

  @Before
  public void setUp() throws Exception {
    hp = new HeaderProcessor();
    HeaderProcessor.map.put(1, 2);
  }

  @Test
  public void process() throws Exception {
    String line = hp.process("#");
    System.out.println(line);
    System.out.println(HeaderProcessor.map);
  }

}