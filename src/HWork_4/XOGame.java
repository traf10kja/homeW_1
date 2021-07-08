package HWork_4;

import java.util.Random;
import java.util.Scanner;

public class XOGame {
    static final int SIZE = 3;
    static final int DOT_TO_WIN = 3;
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {


        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkWinLines(DOT_X, DOT_TO_WIN)) {
                System.out.println("Вы победили!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();
            if (checkWinLines(DOT_O, DOT_TO_WIN)) {
                System.out.println("Компуктер выиграл");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
        }

    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%c ", map[i][j]);
                ;
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("input Y X");
            y = sc.nextInt() - 1;
            x = sc.nextInt() - 1;
        } while (!isSellValid(y, x));
        map[y][x] = DOT_X;
    }

    public static void aiTurn() {
        int x, y;
        do {

            y = random.nextInt(SIZE);
            x = random.nextInt(SIZE);
        } while (!isSellValid(y, x));
        map[y][x] = DOT_O;
    }

    public static boolean isSellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

//    public static boolean checkWin(char c) {
//
//        if (map[0][0] == c && map[0][1] == c && map[0][2] == c) {
//            return true;
//        }
//        if (map[1][0] == c && map[1][1] == c && map[1][2] == c) {
//            return true;
//        }
//        if (map[2][0] == c && map[2][1] == c && map[2][2] == c) {
//            return true;
//        }
//
//        if (map[0][0] == c && map[1][0] == c && map[2][0] == c) {
//            return true;
//        }
//        if (map[0][1] == c && map[1][1] == c && map[2][1] == c) {
//            return true;
//        }
//        if (map[0][2] == c && map[1][2] == c && map[2][2] == c) {
//            return true;
//        }
//
//        if (map[0][0] == c && map[1][1] == c && map[2][2] == c) {
//            return true;
//        }
//        if (map[0][2] == c && map[1][1] == c && map[2][0] == c) {
//            return true;
//        }
//
//        return false;
//
//    }

    static boolean checkLine(int dy, int dx, int vy, int vx, char dot, int dotsToWin) {
        if (dx + vx * (dotsToWin - 1) > SIZE - 1 || dy + vy * (dotsToWin - 1) > SIZE - 1 ||
                dy + vy * (dotsToWin - 1) < 0) {
            return false;
        }
        for (int i = 0; i < dotsToWin; i++) {
            if (map[dy + i * vy][dx + i * vx] != dot) {
                return false;
            }

        }
        return true;
    }

    static boolean checkWinLines(char dot, int dotsToWin) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, dot, dotsToWin) ||
                        checkLine(i, j, 1, 0, dot, dotsToWin) ||
                        checkLine(i, j, 1, 1, dot, dotsToWin) ||
                        checkLine(i, j, -1, 1, dot, dotsToWin)) {
                    return true;
                }

            }

        }
        return false;
    }

}

