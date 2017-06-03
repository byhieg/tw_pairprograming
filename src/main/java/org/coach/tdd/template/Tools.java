package org.coach.tdd.template;

import static org.coach.tdd.template.LiveGameController.LIVE;

/**
 * Created by byhieg on 17/6/3.
 * Mail to byhieg@gmail.com
 */
public class Tools {

    private static int time = 1000;

    public void printArrays(int[][] arrays) {
        int length = arrays.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (arrays[i][j] == LIVE) {
                    System.out.print("■ ");
                } else {
                    System.out.print("□ ");
                }
            }
            System.out.println();
        }
    }

    public int getPauseTime() {
        return time;
    }

    public void setPauseTime(int expectTime) {
        time = expectTime;
    }

    public void doPause() throws InterruptedException {
        Thread.sleep(getPauseTime());

    }

    public void cloneArrays(int[][] src, int[][] des) {
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src[i].length; j++) {
                des[i][j] = src[i][j];
            }
        }
    }

    public int[][] cloneArrays(int[][] src) {
        int[][] des = new int[src.length][src[0].length];
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src[i].length; j++) {
                des[i][j] = src[i][j];
            }
        }
        return des;
    }

}
