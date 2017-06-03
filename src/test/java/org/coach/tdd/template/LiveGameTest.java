package org.coach.tdd.template;

import static org.coach.tdd.template.LiveGame.LIVE;
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
        liveGame.createGameMap();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldJudgeCellStatusReturnLive() throws Exception {
        assertThat(liveGame.judgeCellStatus(0, 0), is(false));
        assertThat(liveGame.judgeCellStatus(1, 1), is(true));
    }

    @Test
    public void shouldGetLeftUpPositionReturnLeftUpPosition() throws Exception {
        int x = liveGame.getLeftUpPosition(1, 1).getX();
        int y = liveGame.getLeftUpPosition(1, 1).getY();
        assertThat(x, is(0));
        assertThat(y, is(0));
    }

    @Test
    public void shouldGetUpPositionReturnUpPosition() throws Exception {
        int x = liveGame.getUpPosition(1, 1).getX();
        int y = liveGame.getUpPosition(1, 1).getY();
        assertThat(x, is(1));
        assertThat(y, is(0));
    }

    @Test
    public void shouldGetRightUpPositionReturnRightUpPosition() throws Exception {
        int x = liveGame.getRightUpPosition(1, 1).getX();
        int y = liveGame.getRightUpPosition(1, 1).getY();
        assertThat(x, is(2));
        assertThat(y, is(0));
    }

    @Test
    public void shouldGetRightPositionReturnRightPosition() throws Exception {
        int x = liveGame.getRightPosition(1, 1).getX();
        int y = liveGame.getRightPosition(1, 1).getY();
        assertThat(x, is(2));
        assertThat(y, is(1));
    }

    @Test
    public void shouldGetRightDownPositionReturnRightDownPosition() throws Exception {
        int x = liveGame.getRightDownPosition(1, 1).getX();
        int y = liveGame.getRightDownPosition(1, 1).getY();
        assertThat(x, is(2));
        assertThat(y, is(2));
    }

    @Test
    public void shouldGetDownPositionReturnDownPosition() throws Exception {
        int x = liveGame.getDownPosition(1, 1).getX();
        int y = liveGame.getDownPosition(1, 1).getY();
        assertThat(x, is(1));
        assertThat(y, is(2));
    }

    @Test
    public void shouldGetLeftDownPositionReturnLeftDownPosition() throws Exception {
        int x = liveGame.getLeftDownPosition(1, 1).getX();
        int y = liveGame.getLeftDownPosition(1, 1).getY();
        assertThat(x, is(0));
        assertThat(y, is(2));
    }

    @Test
    public void shouldGetLeftPositionReturnLeftPosition() throws Exception {
        int x = liveGame.getLeftPosition(1, 1).getX();
        int y = liveGame.getLeftPosition(1, 1).getY();
        assertThat(x, is(0));
        assertThat(y, is(1));
    }

    @Test
    public void shouldIsExistedReturnFalse() throws Exception {
        assertThat(liveGame.getLeftUpPosition(0, 0).isExisted(), is(false));
        assertThat(liveGame.getLeftPosition(0, 0).isExisted(), is(false));
    }

    @Test
    public void shouldIsCrossBroaderReturnTrue() throws Exception {
        assertThat(liveGame.isCrossBroader(-1, -1), is(true));
        assertThat(liveGame.isCrossBroader(-1, 2), is(true));
        assertThat(liveGame.isCrossBroader(3, 3), is(true));
        assertThat(liveGame.isCrossBroader(1, 3), is(true));
        assertThat(liveGame.isCrossBroader(0, 3), is(true));
    }

    @Test
    public void shouldIsCrossBroaderReturnFalse() throws Exception {
        assertThat(liveGame.isCrossBroader(2, 2), is(false));

    }

    @Test
    public void shouldGetLiveCountReturnThree() throws Exception {
//        assertThat(liveGame.getLiveCount(1, 2), is(3));
        assertThat(liveGame.getLiveCount(0, 1), is(3));

    }

    @Test
    public void shouldGetLiveCountReturnTwo() throws Exception {
        assertThat(liveGame.getLiveCount(0, 2), is(2));
    }


    @Test
    public void shouldDoEvolution() throws Exception {
        liveGame.doEvolution(0, 1);
        assertThat(liveGame.getTmpGame()[0][1], is(LIVE));
    }


    @Test
    public void shouldDoMacroEvolution() throws Exception {
        liveGame.doMacroEvolution();
    }

    @Test
    public void shouldFinishEvolution() throws Exception {
        liveGame.finishEvolution();
    }

    @Test
    public void shouldStartGame() throws Exception {
        liveGame.startGame();
    }
}
