package edu.neu.ccs.cs5004;

import org.junit.Assert;

/**
 * Created by zhang on 3/29/2017.
 */
public class ItemizationProcessorTest {
  String line1;
  String line2;
  String line3;

  @org.junit.Before
  public void setUp() throws Exception {
    line1 = "+ itemization list, second element ";
    line2 = "  - itemization list, second element ";
    line3 = "    * itemization list, second element ";
  }

  @org.junit.Test
  public void process() throws Exception {
    ItemizationProcessor i = new ItemizationProcessor();
    line1 = i.process(line1);
    line2 = i.process(line2);
    line3 = i.process(line3);
    Assert.assertEquals(line1, "* itemization list, second element ");
    Assert.assertEquals(line2, "  * itemization list, second element ");
    Assert.assertEquals(line3, "    * itemization list, second element ");
  }

}