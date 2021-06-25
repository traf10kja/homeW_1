package HWork_3;

import java.util.Arrays;
import java.util.Random;

public class HomeWork_3 {
    static Random random = new Random();

    public static void main(String[] args) {

        oneZeroArray(11);
        oneZeroArray(2);
        oneZeroArray(7);

        /**Задать пустой целочисленный массив длиной 100.
         С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;*/
        int[] arrTwo = new int[100];
        int x = 1;
        for (int i = 0; i < arrTwo.length; i++) {
            arrTwo[i] = x;
            x += 1;
        }
        System.out.println(Arrays.toString(arrTwo));

        /**Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
         пройти по нему циклом, и числа меньшие 6 умножить на 2;*/
        int[] arrThree = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arrThree));
        for (int i = 0; i < arrThree.length; i++) {
            if (arrThree[i] < 6) {
                arrThree[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arrThree));

        quattro(3, 3);
        quattro(7, 7);
        quattro(10, 10);

        twoArguments(5, 7);
        twoArguments(3, 44);
        twoArguments(15, 1);

        minMaxMethod(5);
        minMaxMethod(10);
        minMaxMethod(51);


    }

    /**
     * Задать целочисленный массив, состоящий из элементов 0 и 1.
     * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     * С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    public static int[] oneZeroArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(2);
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] += 1;
            } else {
                arr[i] -= 1;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    /**
     * Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     * и с помощью цикла(-ов) заполнить его диагональные элементы единицами
     * (можно только одну из диагоналей, если обе сложно).
     * Определить элементы одной из диагоналей можно по следующему принципу:
     * индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
     */
    public static int[][] quattro(int length, int height) {
        int[][] arrQuattro = new int[length][height];
        for (int i = 0; i < arrQuattro.length; i++) {
            for (int j = 0; j < arrQuattro[i].length; j++) {
                if (i == j) {
                    arrQuattro[i][j] = 1;
                }
                if (i + j == arrQuattro.length - 1) {
                    arrQuattro[i][j] = 1;
                }
                System.out.printf("%3d ", arrQuattro[i][j]);
            }
            System.out.println();
        }
        return arrQuattro;
    }

    /**
     * Написать метод, принимающий на вход два аргумента:
     * len и initialValue, и возвращающий одномерный массив типа int длиной len,
     * каждая ячейка которого равна initialValue;
     */
    public static int[] twoArguments(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    /**
     * Задать одномерный массив и найти в нем минимальный
     * и максимальный элементы ;
     */
    public static int[] minMaxMethod(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(111) - 10;
        }
        System.out.println(Arrays.toString(arr));
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Minimum value " + min);
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Maximum value " + max);
        return arr;
    }
}

