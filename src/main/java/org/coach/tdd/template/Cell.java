package org.coach.tdd.template;

public class Cell {
    public static final int INIT = -1;

    private int x = INIT;
    private int y = INIT;
    private boolean isExisted = false;

    public Cell() {

    }
    public boolean isExisted() {
        return isExisted;
    }

    public void setExisted(boolean existed) {
        isExisted = existed;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
