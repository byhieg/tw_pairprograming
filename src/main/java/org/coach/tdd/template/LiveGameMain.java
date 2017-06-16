package org.coach.tdd.template;

import java.util.Random;
import java.util.Scanner;

public class LiveGameMain implements IGame {

    private LiveGameController controller;
    private Tools tool;
    private int gameLengthSize;
    private int gameWidthSize;

    private int[][] gameMap;


    public LiveGameMain() {
        controller = new LiveGameController();
        tool = new Tools();
    }

    @Override
    public void initGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("开始游戏");
        System.out.println("选择随机化或者指定初始状态，0表示随机化，1表示从终端输入");
        int choose = sc.nextInt();
        System.out.println("输入棋盘长度");
        setGameLengthSize(sc.nextInt());
        System.out.println("输入棋盘宽度");
        setGameWidthSize(sc.nextInt());
        System.out.println("输入进化周期");
        tool.setPauseTime(sc.nextInt());
        startGameWithRequest(choose);
    }

    public void startGameWithRequest(int code) {
        switch (code) {
            case 0:
                createGameMap();
                break;
            case 1:
                System.out.println("输入0，表示死亡，输入1表示存活");
                inputGameMaps(1);
                break;
            default:
                System.out.println("输入错误");

        }

        startGame();
    }

    @Override
    public void startGame() {
        int times = 1;
        System.out.println("第 0 次");
        tool.printArrays(gameMap);
        while (true) {
            int[][] result = controller.doMacroEvolution(gameMap);
            tool.cloneArrays(result, gameMap);
            System.out.println("第 " + times + " 次");
            tool.printArrays(gameMap);
            try {
                tool.doPause();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            times++;
        }
    }

    @Override
    public void createGameMap() {
        Random random = new Random();
        gameMap = new int[gameWidthSize][gameLengthSize];
        for (int i = 0; i < gameWidthSize; i++) {
            for (int j = 0; j < gameLengthSize; j++) {
                int status = random.nextInt(2);
                gameMap[i][j] = status;
            }
        }
    }

    @Override
    public void inputGameMaps(int from) {
        gameMap = new int[gameWidthSize][gameLengthSize];
        switch (from) {
            case 1:
                consleInput();
                break;

            default:
                break;
        }
    }


    private void consleInput() {
        Scanner scanner = new Scanner(System.in);
        gameMap = new int[][]{
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,1,1,1,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},

        };
//        for (int i = 0; i < gameWidthSize; i++) {
//            for (int j = 0; j < gameLengthSize; j++) {
//                int status = scanner.nextInt();
//                gameMap[i][j] = status;
//            }
//        }
    }


    public static void main(String[] args) {
        new LiveGameMain().initGame();
    }


    public int getGameLengthSize() {
        return gameLengthSize;
    }

    public void setGameLengthSize(int gameLengthSize) {
        this.gameLengthSize = gameLengthSize;
    }

    public int getGameWidthSize() {
        return gameWidthSize;
    }

    public void setGameWidthSize(int gameWidthSize) {
        this.gameWidthSize = gameWidthSize;
    }

}
