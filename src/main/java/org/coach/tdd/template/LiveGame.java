package org.coach.tdd.template;


import java.util.Random;

public class LiveGame {
    public static final int LIVE = 1;
    public static final int DEAD = 0;
    public static final int NO_CHANGE = 2;
    private static final int GAME_SIZE = 10;
    private int[][] gameMap = new int[GAME_SIZE][GAME_SIZE];
    private int[][] tmpGame = new int[GAME_SIZE][GAME_SIZE];

    public void createGameMap() {
        Random random = new Random();
        System.out.println("随机化初始状态");
        for (int i = 0; i < GAME_SIZE; i++) {
            for (int j = 0; j < GAME_SIZE; j++) {
                int status = random.nextInt(2);
                gameMap[i][j] = status;
                System.out.print(gameMap[i][j] + " ");
            }
            System.out.println();
        }
        tmpGame = gameMap;
    }

    public boolean judgeCellStatus(int x, int y) {
        return gameMap[x][y] == LIVE;
    }

    public Cell getLeftUpPosition(int x, int y) {
        Cell cell = new Cell();
        if (!isCrossBroader(x - 1, y - 1)) {
            cell.setExisted(true);
            cell.setX(x - 1);
            cell.setY(y - 1);
        }
        return cell;
    }

    public Cell getUpPosition(int x, int y) {
        Cell cell = new Cell();
        if (!isCrossBroader(x, y - 1)) {
            cell.setExisted(true);
            cell.setX(x);
            cell.setY(y - 1);
        }
        return cell;
    }

    public Cell getRightUpPosition(int x, int y) {
        Cell cell = new Cell();
        if (!isCrossBroader(x + 1, y - 1)) {
            cell.setExisted(true);
            cell.setX(x + 1);
            cell.setY(y - 1);
        }
        return cell;
    }

    public Cell getRightPosition(int x, int y) {
        Cell cell = new Cell();
        if (!isCrossBroader(x + 1, y)) {
            cell.setExisted(true);
            cell.setX(x + 1);
            cell.setY(y);
        }
        return cell;
    }

    public Cell getRightDownPosition(int x, int y) {
        Cell cell = new Cell();
        if (!isCrossBroader(x + 1, y + 1)) {
            cell.setExisted(true);
            cell.setX(x + 1);
            cell.setY(y + 1);
        }
        return cell;
    }

    public Cell getDownPosition(int x, int y) {
        Cell cell = new Cell();
        if (!isCrossBroader(x, y + 1)) {
            cell.setExisted(true);
            cell.setX(x);
            cell.setY(y + 1);
        }
        return cell;
    }

    public Cell getLeftDownPosition(int x, int y) {
        Cell cell = new Cell();
        if (!isCrossBroader(x - 1, y + 1)) {
            cell.setExisted(true);
            cell.setX(x - 1);
            cell.setY(y + 1);
        }
        return cell;
    }

    public Cell getLeftPosition(int x, int y) {
        Cell cell = new Cell();
        if (!isCrossBroader(x - 1, y)) {
            cell.setExisted(true);
            cell.setX(x - 1);
            cell.setY(y);
        }
        return cell;
    }


    public boolean isCrossBroader(int x, int y) {
        if (x < 0 || x >= GAME_SIZE || y < 0 || y >= GAME_SIZE) {
            return true;
        }
        return false;
    }

    public int doEvolution(int x, int y) {
        int liveCount = getLiveCount(x, y);
        return liveCount;
    }

    public int getLiveCount(int x, int y) {
        Cell[] cells = new Cell[8];
        int liveCount = 0;
        cells[0] = getLeftUpPosition(x, y);
        cells[1] = getUpPosition(x, y);
        cells[2] = getRightUpPosition(x, y);
        cells[3] = getRightPosition(x, y);
        cells[4] = getRightDownPosition(x, y);
        cells[5] = getDownPosition(x, y);
        cells[6] = getLeftDownPosition(x, y);
        cells[7] = getLeftPosition(x, y);
        for (int i = 0; i < 8; i++) {
            if (cells[i].isExisted() && judgeCellStatus(cells[i].getX(), cells[i].getY())) {
                liveCount++;
            }
        }
        return liveCount;
    }

    public void saveStatus(int x, int y) {
        switch (doEvolution(x, y)) {
            case LIVE:
                tmpGame[x][y] = LIVE;
                break;
            case DEAD:
                tmpGame[x][y] = DEAD;
                break;
            case NO_CHANGE:
                break;
            default:
                break;
        }
    }

    public void doMacroEvolution() {
        for (int i = 0; i < GAME_SIZE; i++) {
            for (int j = 0; j < GAME_SIZE; j++) {
                saveStatus(i, j);
            }
        }
    }

    public void finishEvolution() {
        gameMap = tmpGame;
    }

    public void startGame() {
        int times = 1;
        createGameMap();
        while (true) {
            doMacroEvolution();
            finishEvolution();
            System.out.println("第 " + times + " 次");
            Tools.printArrays(gameMap);
            Tools.doPause();
            times++;
        }
    }

    public static void main(String[] args) {
        new LiveGame().startGame();
    }
}
