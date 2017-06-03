package org.coach.tdd.template;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class FizzBuzzTest {
  private FizzBuzz fb;

  @Before
  public void setUp() throws Exception {
    fb = new FizzBuzz();
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void fb() throws Exception {
    fb.fb();
  }

  @Test
  public void isFizz() throws Exception {
    assertTrue(fb.isFizz(3));
    assertFalse(fb.isFizz(15));
    assertFalse(fb.isFizz(4));
  }

  @Test(expected = RuntimeException.class)
  public void isF() throws Exception {
    fb.isFizz(-1);
  }

  @Test
  public void isBuzz() throws Exception {
    assertTrue(fb.isBuzz(5));
    assertFalse(fb.isBuzz(15));
    assertFalse(fb.isBuzz(3));
  }

  @Test
  public void isFizzBuzz() throws Exception {
    assertFalse(fb.isFizzBuzz(5));
    assertTrue(fb.isFizzBuzz(15));
    assertFalse(fb.isFizzBuzz(6));
    assertThat(fb.isBuzz(1), is(false));
  }
}
