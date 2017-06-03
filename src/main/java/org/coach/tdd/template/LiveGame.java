package org.coach.tdd.template;

import java.util.Random;
import java.util.Scanner;

public class LiveGame implements IGame {

    private LiveGameController controller;
    private Tools tool;
    private int gameLengthSize;


    private int gameWidthSize;


    private int[][] gameMap;
    private int[][] tmpGame;


    public LiveGame() {
        controller = new LiveGameController();
        tool = new Tools();
    }

    @Override
    public void initGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("开始游戏");
        System.out.println("输入棋盘长度");
        setGameLengthSize(sc.nextInt());
        System.out.println("输入棋盘宽度");
        setGameWidthSize(sc.nextInt());
        System.out.println("输入进化周期");
        tool.setPauseTime(sc.nextInt());
        System.out.println("选择随机化或者指定初始状态，0表示随机化，1表示指定");
        int choose = sc.nextInt();
        startGameWithRequest(choose);
    }

    public void startGameWithRequest(int code) {
        switch (code) {
            case 0:
                createGameMap();
                break;
            case 1:
                System.out.println("输入0，表示死亡，输入1表示存活");
                inputGameMaps();
                break;
            default:
                System.out.println("输入错误");

        }

        startGame();
    }

    @Override
    public void startGame() {
        int times = 1;
        while (true) {
            controller.doMacroEvolution(tmpGame);
            tool.cloneArrays(tmpGame, gameMap);
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
        System.out.println("随机化初始状态");
        gameMap = new int[gameWidthSize][gameLengthSize];
        tmpGame = new int[gameWidthSize][gameLengthSize];
        for (int i = 0; i < gameWidthSize; i++) {
            for (int j = 0; j < gameLengthSize; j++) {
                int status = random.nextInt(2);
                gameMap[i][j] = status;
                tmpGame[i][j] = status;
            }
        }
    }

    @Override
    public void inputGameMaps() {
        gameMap = new int[gameWidthSize][gameLengthSize];
        tmpGame = new int[gameWidthSize][gameLengthSize];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < gameWidthSize; i++) {
            for (int j = 0; j < gameLengthSize; j++) {
                int status = scanner.nextInt();
                gameMap[i][j] = status;
                tmpGame[i][j] = status;
            }
        }
    }


    public static void main(String[] args) {
        new LiveGame().initGame();
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
