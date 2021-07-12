package HWork_8;

public class Logic {
    static int SIZE = 3;
    static int DOT_TO_WIN = 3;
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static boolean isGameFinished;

    public static void go() {
        isGameFinished = true;
        printMap();
        if (checkWinLines(DOT_X, DOT_TO_WIN)) {
            System.out.println("Вы победили!");
            return;
        }
        if (isFull()) {
            System.out.println("Ничья");
            return;
        }

        aiTurn();
        printMap();
        if (checkWinLines(DOT_O, DOT_TO_WIN)) {
            System.out.println("Компуктер выиграл");
            return;
        }
        if (isFull()) {
            System.out.println("Ничья");
            return;
        }

        isGameFinished = false;
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

    public static void humanTurn(int y, int x) {
        if (isSellValid(y, x)) {
            map[y][x] = DOT_X;
            go();
        }

    }

    public static void aiTurn() {
        int x, y;


        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isSellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWinLines(DOT_O, DOT_TO_WIN)) {
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }

            }

        }

//        Сбивает победную линию противника, если остался один ход до победы
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isSellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWinLines(DOT_X, DOT_TO_WIN)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }

            }

        }
//        Попытки победить самому, если осталось 2 хода для победы
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isSellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWinLines(DOT_O, DOT_TO_WIN - 1) &&
                            Math.random() < 0.5) {
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }

            }

        }
//Сбить победную линию противника, если осталось 2 хода до победы
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isSellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWinLines(DOT_X, DOT_TO_WIN - SIZE) &&
                            Math.random() < 0.5) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }

            }

        }
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
