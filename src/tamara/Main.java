package tamara;

import tamara.homework1.Matrix;

public class Main {
    public static void main(String[] args) {
        Matrix a = new Matrix(3, 4);
//        Matrix b = new Matrix(3, 4);
        a.setMatrix(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        a.getMatrix();
        System.out.print("&&&");
        a.transroseMatrix();
//        b.setMatrix(new int[][] {{12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}});
//        b.getMatrix();
//        a.addMatrix(b);
//        System.out.println(a.toString());
//        a.addMatrix(b);
    }
}