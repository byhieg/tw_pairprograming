package org.coach.tdd.template;

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
                System.out.print(arrays[i][j] + " ");
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

}
