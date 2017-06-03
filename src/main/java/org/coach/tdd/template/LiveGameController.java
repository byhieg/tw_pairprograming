package org.coach.tdd.template;

public class LiveGameController {
    public static final int LIVE = 1;
    public static final int DEAD = 0;
    public static final int LIVE_LIMIT = 3;
    public static final int NO_CHANGE_LIMIT = 2;
    private int[][] tmpMaps;

    public boolean judgeCellLived(int x, int y, int[][] maps) {
        return maps[x][y] == LIVE;
    }

    public Position getLeftUpPosition(int x, int y, int[][] maps) {
        Position position = new Position();
        if (isCrossBroader(x - 1, y - 1, maps)) {
            return position;
        }
        position.setExisted(true);
        position.setX(x - 1);
        position.setY(y - 1);
        return position;
    }

    public Position getUpPosition(int x, int y, int[][] maps) {
        Position position = new Position();
        if (isCrossBroader(x, y - 1, maps)) {
            return position;
        }
        position.setExisted(true);
        position.setX(x);
        position.setY(y - 1);
        return position;
    }

    public Position getRightUpPosition(int x, int y, int[][] maps) {
        Position position = new Position();
        if (isCrossBroader(x + 1, y - 1, maps)) {
            return position;
        }
        position.setExisted(true);
        position.setX(x + 1);
        position.setY(y - 1);
        return position;
    }

    public Position getRightPosition(int x, int y, int[][] maps) {
        Position position = new Position();
        if (isCrossBroader(x + 1, y, maps)) {
            return position;
        }
        position.setExisted(true);
        position.setX(x + 1);
        position.setY(y);
        return position;
    }

    public Position getRightDownPosition(int x, int y, int[][] maps) {
        Position position = new Position();
        if (isCrossBroader(x + 1, y + 1, maps)) {
            return position;
        }
        position.setExisted(true);
        position.setX(x + 1);
        position.setY(y + 1);
        return position;
    }

    public Position getDownPosition(int x, int y, int[][] maps) {
        Position position = new Position();
        if (isCrossBroader(x, y + 1, maps)) {
            return position;
        }
        position.setExisted(true);
        position.setX(x);
        position.setY(y + 1);
        return position;
    }

    public Position getLeftDownPosition(int x, int y, int[][] maps) {
        Position position = new Position();
        if (isCrossBroader(x - 1, y + 1, maps)) {
            return position;
        }
        position.setExisted(true);
        position.setX(x - 1);
        position.setY(y + 1);
        return position;
    }

    public Position getLeftPosition(int x, int y, int[][] maps) {
        Position position = new Position();
        if (isCrossBroader(x - 1, y, maps)) {
            return position;
        }
        position.setExisted(true);
        position.setX(x - 1);
        position.setY(y);
        return position;
    }

    public boolean isCrossBroader(int x, int y, int[][] maps) {
        int length = maps[0].length;
        int width = maps.length;
        if (x < 0 || x >= width || y < 0 || y >= length) {
            return true;
        }
        return false;
    }

    public void doEvolution(int x, int y, int[][] maps) {
        int liveCount = getLiveCount(x, y, maps);
        if (liveCount == LIVE_LIMIT) {
            tmpMaps[x][y] = LIVE;
        } else if (liveCount == NO_CHANGE_LIMIT) {
            tmpMaps[x][y] = maps[x][y];
        } else {
            tmpMaps[x][y] = DEAD;
        }
    }

    public int getLiveCount(int x, int y, int[][] maps) {
        Position[] positions = new Position[8];
        int liveCount = 0;
        positions[0] = getLeftUpPosition(x, y, maps);
        positions[1] = getUpPosition(x, y, maps);
        positions[2] = getRightUpPosition(x, y, maps);
        positions[3] = getRightPosition(x, y, maps);
        positions[4] = getRightDownPosition(x, y, maps);
        positions[5] = getDownPosition(x, y, maps);
        positions[6] = getLeftDownPosition(x, y, maps);
        positions[7] = getLeftPosition(x, y, maps);
        for (int i = 0; i < 8; i++) {
            if (positions[i].isExisted() && judgeCellLived(positions[i].getX(), positions[i].getY(), maps)) {
                liveCount++;
            }
        }
        return liveCount;
    }

    public int[][] doMacroEvolution(int[][] maps) {
        tmpMaps = new Tools().cloneArrays(maps);
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                doEvolution(i, j, maps);
            }
        }
        return tmpMaps;
    }

}
