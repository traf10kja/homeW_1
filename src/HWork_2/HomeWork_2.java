package HWork_2;

public class HomeWork_2 {
    public static void main(String[] args) {
        System.out.println(twoNumbers(10, 15));
        System.out.println(twoNumbers(10, 5));
        System.out.println(twoNumbers(9, 11));

        positiveOrNegative(4);
        positiveOrNegative(-2);
        positiveOrNegative(0);

        System.out.println(magicPositiveOrNegative(10));
        System.out.println(magicPositiveOrNegative(-7));
        System.out.println(magicPositiveOrNegative(0));

        strPlusNumber("Bingo", 5);
        strPlusNumber("Bongo", 7);
        strPlusNumber("Jimbo", 1);

        System.out.println(year(2100));
        System.out.println(year(2096));
        System.out.println(year(2024));

    }

    public static boolean twoNumbers(int a, int b) {
        if (a + b >= 10 && a + b <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void positiveOrNegative(int x) {
        if (x >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }


    }

    public static boolean magicPositiveOrNegative(int y) {
        if (y >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void strPlusNumber(String str, int z) {
        for (int i = 0; i < z; i++) {
            System.out.print(str + " ");

        }
        System.out.println();
    }

    public static boolean year(int g) {
        if (g % 4 == 0 || g % 400 == 0){
            if (g % 100 == 0) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

}
