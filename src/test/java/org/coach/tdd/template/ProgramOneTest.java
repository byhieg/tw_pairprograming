package org.coach.tdd.template;

import static org.junit.Assert.assertArrayEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProgramOneTest {

  private ProgramOne one;

  @Before
  public void setUp() throws Exception {
    one = new ProgramOne();
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testOdd() throws Exception {
    assertFalse(one.isOdd(10));
    assertTrue(one.isOdd(9));
    assertTrue(one.isOdd(-1));
  }

  @Test
  public void testEven() throws Exception {
    assertTrue(one.isEven(10));
    assertFalse(one.isEven(9));
  }

  @Test
  public void testCreateList() throws Exception {
    int[] targer = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    one.createList(one.getList());
    assertArrayEquals(targer, one.getList());
  }
}
