package tamara.homework2;
import java.lang.*;
import java.util.*;

public class ArrayListVSLinkedList {

    public static void main(String[] args) {
        LinkedList();
        ArrayList();
    }

    public static void ArrayList() {
        ArrayList<Integer> lst1 = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            lst1.add((1) + (int) (Math.random() * 1000));
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            lst1.get((int) (Math.random() * 99999));
        }
        System.out.println(System.currentTimeMillis() - startTime + " миллисекунд");
    }

    public static void LinkedList() {
        LinkedList<Integer> lst2 = new LinkedList<>();

        for (int i = 0; i < 1000000; i++) {
            lst2.add((1) + (int) (Math.random() * 1000));
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            lst2.get((int) (Math.random() * 99999));
        }
        System.out.println(System.currentTimeMillis() - startTime + " миллисекунд");
    }


}
