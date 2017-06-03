package org.coach.tdd.template;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class LiveGameMainControllerTest {


    private LiveGameController liveGameController;
    private int[][] maps = new int[][]{
            {0, 0, 1},
            {0, 1, 1},
            {0, 1, 1}
    };

    @Before
    public void setUp() throws Exception {
        liveGameController = new LiveGameController();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldJudgeCellStatusReturnLive() throws Exception {
        assertThat(liveGameController.judgeCellLived(0, 0, maps), is(false));
        assertThat(liveGameController.judgeCellLived(1, 1, maps), is(true));
    }

    @Test
    public void shouldGetLeftUpPositionReturnLeftUpPosition() throws Exception {
        int x = liveGameController.getLeftUpPosition(1, 1, maps).getX();
        int y = liveGameController.getLeftUpPosition(1, 1, maps).getY();
        assertThat(x, is(0));
        assertThat(y, is(0));
    }

    @Test
    public void shouldGetUpPositionReturnUpPosition() throws Exception {
        int x = liveGameController.getUpPosition(1, 1, maps).getX();
        int y = liveGameController.getUpPosition(1, 1, maps).getY();
        assertThat(x, is(1));
        assertThat(y, is(0));
    }

    @Test
    public void shouldGetRightUpPositionReturnRightUpPosition() throws Exception {
        int x = liveGameController.getRightUpPosition(1, 1, maps).getX();
        int y = liveGameController.getRightUpPosition(1, 1, maps).getY();
        assertThat(x, is(2));
        assertThat(y, is(0));
    }

    @Test
    public void shouldGetRightPositionReturnRightPosition() throws Exception {
        int x = liveGameController.getRightPosition(1, 1, maps).getX();
        int y = liveGameController.getRightPosition(1, 1, maps).getY();
        assertThat(x, is(2));
        assertThat(y, is(1));
    }

    @Test
    public void shouldGetRightDownPositionReturnRightDownPosition() throws Exception {
        int x = liveGameController.getRightDownPosition(1, 1, maps).getX();
        int y = liveGameController.getRightDownPosition(1, 1, maps).getY();
        assertThat(x, is(2));
        assertThat(y, is(2));
    }

    @Test
    public void shouldGetDownPositionReturnDownPosition() throws Exception {
        int x = liveGameController.getDownPosition(1, 1, maps).getX();
        int y = liveGameController.getDownPosition(1, 1, maps).getY();
        assertThat(x, is(1));
        assertThat(y, is(2));
    }

    @Test
    public void shouldGetLeftDownPositionReturnLeftDownPosition() throws Exception {
        int x = liveGameController.getLeftDownPosition(1, 1, maps).getX();
        int y = liveGameController.getLeftDownPosition(1, 1, maps).getY();
        assertThat(x, is(0));
        assertThat(y, is(2));
    }

    @Test
    public void shouldGetLeftPositionReturnLeftPosition() throws Exception {
        int x = liveGameController.getLeftPosition(1, 1, maps).getX();
        int y = liveGameController.getLeftPosition(1, 1, maps).getY();
        assertThat(x, is(0));
        assertThat(y, is(1));
    }

    @Test
    public void shouldIsExistedReturnFalse() throws Exception {
        assertThat(liveGameController.getLeftUpPosition(0, 0, maps).isExisted(), is(false));
        assertThat(liveGameController.getLeftPosition(0, 0, maps).isExisted(), is(false));
    }

    @Test
    public void shouldIsCrossBroaderReturnTrue() throws Exception {
        assertThat(liveGameController.isCrossBroader(-1, -1, maps), is(true));
        assertThat(liveGameController.isCrossBroader(-1, 2, maps), is(true));
        assertThat(liveGameController.isCrossBroader(3, 3, maps), is(true));
        assertThat(liveGameController.isCrossBroader(1, 3, maps), is(true));
        assertThat(liveGameController.isCrossBroader(0, 3, maps), is(true));
    }

    @Test
    public void shouldIsCrossBroaderReturnFalse() throws Exception {
        assertThat(liveGameController.isCrossBroader(2, 2, maps), is(false));

    }

    @Test
    public void shouldGetLiveCountReturnThree() throws Exception {
//        assertThat(liveGameController.getLiveCount(1, 2), is(3));
        assertThat(liveGameController.getLiveCount(0, 1, maps), is(3));

    }

    @Test
    public void shouldGetLiveCountReturnTwo() throws Exception {
        assertThat(liveGameController.getLiveCount(0, 2, maps), is(2));
    }


    @Test
    public void shouldDoEvolution() throws Exception {
        liveGameController.doEvolution(0, 1, maps);
    }


    @Test
    public void shouldDoMacroEvolution() throws Exception {
        liveGameController.doMacroEvolution(maps);
    }

}
