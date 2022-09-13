package tamara.homework1;

import java.util.Scanner;

public class Homework1 {

    public static void main(String[] args) {
//        task7();
//        task8();
//        task9();
//        task10();
//        task11();
//        task12();
//        task13();
        Vector a = new Vector(3,2,7);
        Vector b = new Vector(4, 5, 6);
    }

    public static void task7() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();
        float n = num % 10;
        System.out.println(n);
    }

    public static void task8() {
        // 123 --> 2
        Scanner in = new Scanner(System.in);
        System.out.print("input: ");
        int number = in.nextInt();
        if (number > 10) {
            int result = number % 100 / 10;
            System.out.println(result);
        } else {
            System.out.println("a number is less than 10");
        }
    }

     public static void task9() {
        // вытащить вторую с конца цифру
         Scanner in = new Scanner(System.in);
         System.out.print("input: ");
         int number_ = in.nextInt();
         if (number_ > 9 && number_ < 100) {
             int result_ = number_ / 10;
             System.out.println(result_);
         } else {
             System.out.println("a number has more or less than 2 symbols");
         }
     }

     public static void task10() {
         // n - 21
         Scanner in = new Scanner(System.in);
         System.out.print("input: ");
         int num = in.nextInt();
         int res = num - 21;
         System.out.println(res);
     }

     public static void task11() {
        // среднее арифметическое
         Scanner in_1 = new Scanner(System.in);
         System.out.print("input 1: ");
         int number1 = in_1.nextInt();
         Scanner in_2 = new Scanner(System.in);
         System.out.print("input 2: ");
         int number2 = in_2.nextInt();
         float arithmetic_mean = (number1 + number2) / 2;
         System.out.println("arithmetic mean = " + arithmetic_mean);
     }

    public static void task12() {
        // среднее геометрическое
        Scanner in_1_ = new Scanner(System.in);
        System.out.print("input 1: ");
        int number_1 = in_1_.nextInt();
        Scanner in_2_ = new Scanner(System.in);
        System.out.print("input 2: ");
        int number_2 = in_2_.nextInt();
        double geometric_mean = Math.sqrt(number_1 * number_2);
        System.out.println("geometric mean = " + geometric_mean);
    }

    public static void task13() {
        // расстояние между точками???????
        // почему-то выводит NaN
        Scanner in_x1 = new Scanner(System.in);
        System.out.print("input x1: ");
        float number_x1 = in_x1.nextFloat();

        Scanner in_y1 = new Scanner(System.in);
        System.out.print("input y1: ");
        float number_y1 = in_y1.nextFloat();

        Scanner in_x2 = new Scanner(System.in);
        System.out.print("input x2: ");
        float number_x2 = in_x2.nextFloat();

        Scanner in_y2 = new Scanner(System.in);
        System.out.print("input y2: ");
        float number_y2 = in_y2.nextFloat();

        double distance = Math.sqrt(Math.pow(number_x2 - number_x1, 2) - Math.pow(number_y2 - number_y1, 2));
        System.out.println("distance between points = " + distance);
    }
}
