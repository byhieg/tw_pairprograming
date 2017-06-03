package org.coach.tdd.template;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by byhieg on 17/6/3. Mail to byhieg@gmail.com
 */
public class LiveGameTest {

    private LiveGame liveGame;

    @Before
    public void setUp() throws Exception {
        liveGame = new LiveGame();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldJudgeCellStatusReturnLive() throws Exception {
        assertThat(liveGame.judgeCellStatus(0, 0), is(true));
    }

    @Test
    public void shouldGetLeftUpPositionReturnLeftUpPosition() throws Exception {
        int x = liveGame.getLeftUpPosition(3, 3).getX();
        int y = liveGame.getLeftUpPosition(3, 3).getY();
        assertThat(x, is(2));
        assertThat(y, is(2));
    }

    @Test
    public void shouldGetUpPositionReturnUpPosition() throws Exception {
        int x = liveGame.getUpPosition(3, 3).getX();
        int y = liveGame.getUpPosition(3, 3).getY();
        assertThat(x, is(3));
        assertThat(y, is(2));
    }

    @Test
    public void shouldGetRightUpPositionReturnRightUpPosition() throws Exception {
        int x = liveGame.getRightUpPosition(3, 3).getX();
        int y = liveGame.getRightUpPosition(3, 3).getY();
        assertThat(x, is(4));
        assertThat(y, is(2));
    }

    @Test
    public void shouldGetRightPositionReturnRightPosition() throws Exception {
        int x = liveGame.getRightPosition(3, 3).getX();
        int y = liveGame.getRightPosition(3, 3).getY();
        assertThat(x, is(4));
        assertThat(y, is(3));
    }

    @Test
    public void shouldGetRightDownPositionReturnRightDownPosition() throws Exception {
        int x = liveGame.getRightDownPosition(3, 3).getX();
        int y = liveGame.getRightDownPosition(3, 3).getY();
        assertThat(x, is(4));
        assertThat(y, is(4));
    }

    @Test
    public void shouldGetDownPositionReturnDownPosition() throws Exception {
        int x = liveGame.getDownPosition(3, 3).getX();
        int y = liveGame.getDownPosition(3, 3).getY();
        assertThat(x, is(3));
        assertThat(y, is(4));
    }

    @Test
    public void shouldGetLeftDownPositionReturnLeftDownPosition() throws Exception {
        int x = liveGame.getLeftDownPosition(3, 3).getX();
        int y = liveGame.getLeftDownPosition(3, 3).getY();
        assertThat(x, is(2));
        assertThat(y, is(4));
    }

    @Test
    public void shouldGetLeftPositionReturnLeftPosition() throws Exception {
        int x = liveGame.getLeftPosition(3, 3).getX();
        int y = liveGame.getLeftPosition(3, 3).getY();
        assertThat(x, is(2));
        assertThat(y, is(3));
    }

    @Test
    public void shouldIsCrossBroaderReturnTrue() throws Exception {
        assertThat(liveGame.isCrossBroader(-1, -1), is(true));
        assertThat(liveGame.isCrossBroader(10, 10), is(true));
        assertThat(liveGame.isCrossBroader(0, 10), is(true));
        assertThat(liveGame.isCrossBroader(8, 10), is(true));
        assertThat(liveGame.isCrossBroader(10, 3), is(true));

    }

}
