package tamara.seminar1;

import java.util.Scanner;

public class Seminar1 {

    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
        //task4_1();
        //task4_2();
        //task5();
        //task6();
    }

    // вывести строку
    public static void task1() {
        System.out.println("hello world");
    }

    // вывести число
    public static void task2() {
        int a = 17;
        System.out.println(a);
    }

    //  увеличить число на 1
    public static void task3() {
        int a1 = 10;
        System.out.println("a = " + a1);
        int b1 = ++a1;
        int c1 = a1 + 1;
        a1 += 1;
        System.out.println(b1);
        System.out.println(a1);
        System.out.println(c1);
    }

    public static void task4_1() {
        int x = 9;
        int y = 7;
        int temp = x;
        x = y;
        y = temp;
        System.out.println(x);
        System.out.println(y);
    }

    public static void task4_2() {
        int x = 8;
        int y = 7;
        y -= x;
        x += y;
        y = x-y;
        System.out.println(x);
        System.out.println(y);
    }

    public static void task5() {
        int a = 3;
        int b = 4;
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        System.out.println(c);
    }

    public static void task6() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();
        float n = num % 10;
        System.out.println(n);
    }
}
