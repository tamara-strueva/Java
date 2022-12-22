package tamara.homework6;

import java.util.*;

public class IsInMassive {
    public static void main(String[] args) {
        int[] massive = new int[100000000];
        for (int i = 0; i < 100000000; i++) {
            massive[i] = i + 1;
        }

        long startTime1 = System.currentTimeMillis();
        System.out.println(enumeration(massive, 96889));
        long time1 = System.currentTimeMillis() - startTime1;
        System.out.println("1: " + time1 + " миллисекунд");

        long startTime2 = System.currentTimeMillis();
        System.out.println(binarySearch(massive, 96889));
        long time2 = System.currentTimeMillis() - startTime1;
        System.out.println("2: " + time2 + " миллисекунд");
    }

    public static int enumeration(int[] massive, int element) {
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch (int[] massive, int element) {
        int beginning = 0;
        int end = massive.length - 1;
        Arrays.sort(massive);

        while (beginning <= end) {
            int middle = (beginning + end) / 2;
//            massive[middle];
            if (massive[middle] < element) {
                beginning = middle + 1;
            } else if (massive[middle] > element) {
                end = middle - 1;
            }
            return middle;
        }
        System.out.println("Совпадение не найдено");
        return -1;
    }
}
