package org.coach.tdd.template;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by byhieg on 17/6/3.
 * Mail to byhieg@gmail.com
 */
public class ToolsTest {
    private Tools tools;
    private int[][] testArrays = new int[][]{
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0}
    };

    @Before
    public void setUp() throws Exception {
        tools = new Tools();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void printArrays() throws Exception {
        tools.printArrays(testArrays);
    }

    @Test
    public void getPauseTime() throws Exception {
        assertThat(tools.getPauseTime(), is(1000));
    }

    @Test
    public void setPauseTime() throws Exception {
        tools.setPauseTime(1000);
    }

    @Test
    public void doPause() throws Exception {
        tools.doPause();
    }

}
