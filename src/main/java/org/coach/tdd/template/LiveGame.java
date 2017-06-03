package org.coach.tdd.template;


public class LiveGame {

    private static final int GAME_SIZE = 10;

    public boolean judgeCellStatus(int x, int y) {
        return true;
    }

    public Position getLeftUpPosition(int x, int y) {
        Position pos = new Position();
        if (!isCrossBroader(x - 1, y - 1)) {
            pos.setExisted(true);
            pos.setX(x - 1);
            pos.setY(y - 1);
        }
        return pos;
    }

    public Position getUpPosition(int x, int y) {
        Position pos = new Position();
        if (!isCrossBroader(x, y - 1)) {
            pos.setExisted(true);
            pos.setX(x);
            pos.setY(y - 1);
        }
        return pos;
    }

    public Position getRightUpPosition(int x, int y) {
        Position pos = new Position();
        if (!isCrossBroader(x + 1, y - 1)) {
            pos.setExisted(true);
            pos.setX(x + 1);
            pos.setY(y - 1);
        }
        return pos;
    }

    public Position getRightPosition(int x, int y) {
        Position pos = new Position();
        if (!isCrossBroader(x + 1, y)) {
            pos.setExisted(true);
            pos.setX(x + 1);
            pos.setY(y);
        }
        return pos;
    }

    public Position getRightDownPosition(int x, int y) {
        Position pos = new Position();
        if (!isCrossBroader(x + 1, y + 1)) {
            pos.setExisted(true);
            pos.setX(x + 1);
            pos.setY(y + 1);
        }
        return pos;
    }

    public Position getDownPosition(int x, int y) {
        Position pos = new Position();
        if (!isCrossBroader(x, y + 1)) {
            pos.setExisted(true);
            pos.setX(x);
            pos.setY(y + 1);
        }
        return pos;
    }

    public Position getLeftDownPosition(int x, int y) {
        Position pos = new Position();
        if (!isCrossBroader(x - 1, y + 1)) {
            pos.setExisted(true);
            pos.setX(x - 1);
            pos.setY(y + 1);
        }
        return pos;
    }

    public Position getLeftPosition(int x, int y) {
        Position pos = new Position();
        if (!isCrossBroader(x - 1, y)) {
            pos.setExisted(true);
            pos.setX(x - 1);
            pos.setY(y);
        }
        return pos;
    }


    public boolean isCrossBroader(int x, int y) {

        if (x < 0 || x >= GAME_SIZE || y < 0 || y >= GAME_SIZE) {
            return true;
        }
        return false;
    }

    static class Position {
        public static final int INIT = -1;

        private int x = INIT;
        private int y = INIT;
        private boolean isExisted = false;


        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position() {

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
}
