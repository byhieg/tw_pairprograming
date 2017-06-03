package org.coach.tdd.template;

/**
 * Created by byhieg on 17/6/3.
 * Mail to byhieg@gmail.com
 */
public class Tools {

    private static int time = 1000 * 10;

    public static void printArrays(int[][] arrays) {
        int length = arrays.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(arrays[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int getPauseTime() {
        return time;
    }

    public static void setPauseTime(int expectTime) {
        time = expectTime;
    }

    public static void doPause() {
        try {
            Thread.sleep(getPauseTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
