package tamara.homework1;
import java.util.Arrays;

public class Matrix {
    int[][] data = null;
    int rows;
    int columns;

    public Matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.data = new int[rows][columns];
    }

    public static void main(String[] args){
        Matrix a = new Matrix(3, 4);
        a.setMatrix(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        Matrix b = new Matrix(3,4);
        b.setMatrix(new int[][] {{12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}});
        Matrix c = new Matrix(2, 2);
        c.setMatrix(new int[][] {{1,2}, {3,4}});
        c.multiplyMatrixOnNumber(4);
//        a.getMatrix();
//        System.out.println("&&&");
//        b.getMatrix();
//        System.out.println("***");
//        a.addMatrix(b);
//        a.subtractMatrix(b);
    }

    public Matrix setMatrix(int[][] array){
//        Matrix newMatrix = new Matrix(this.rows, this.columns);
        try {
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    data[row][column] = array[row][column];
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("!!Введенный массив не соразмерен матрице!!");
        }

        return this;
    }

    public String toString() {
        return Arrays.deepToString(this.data);
    }

    public Matrix getMatrix() {
        for(int row = 0; row < rows; row++){
            for(int column = 0; column < columns; column++){
                System.out.print(data[row][column]);
                System.out.print("\t");
            }
            System.out.println();
        }
        return this;
    }

    // метод, вычисляющий сумму матриц
    public void addMatrix(Matrix matrix2) {
        Matrix result = new Matrix(this.rows, this.columns);

        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                result.data[row][column] = this.data[row][column] + matrix2.data[row][column];
            }
        }
        result.getMatrix();
    }

    public void subtractMatrix(Matrix matrix2) {
        Matrix result = new Matrix(this.rows, this.columns);

        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                result.data[row][column] = this.data[row][column] - matrix2.data[row][column];
            }
        }
        result.getMatrix();
    }

    public void transroseMatrix() {
        Matrix newMatrix = new Matrix(this.columns, this.rows);
        try {
            for (int column = 0; column < columns; column++) {
                for (int row = 0; row < rows; row++) {
                    newMatrix.data[column][row] = this.data[row][column];
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("###");
        }
        newMatrix.getMatrix();
//        return newMatrix;
    }

    public void multiplyMatrixOnNumber(int number) {
        try {
            for (int column = 0; column < columns; column++) {
                for (int row = 0; row < rows; row++) {
                    this.data[row][column] = this.data[row][column] * number;
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("###");
        }
        this.getMatrix();
    }

//    public void multiplyMatrixes() {
//
//    }

//    public void power() {
//
//    }
}

//import java.util.Arrays;
//
//public class Matrix {
//
//    int[][] matrix;
//
//    public Matrix(int[][] matrix){
//        this.matrix = matrix;
//    }
//
//    public String toString(){
//        return Arrays.deepToString(matrix);
//    }
//
//    public Matrix sumMatrix(Matrix matrixA, Matrix matrixB){
//        Matrix result = new Matrix(new int[matrix.length][matrix.length]);
//        for (int i = 0; i < matrixA.matrix.length; i++)
//            for (int j = 0; j < matrixA.matrix.length; j++)
//                result.matrix[i][j] = matrixA.matrix[i][j] + matrixB.matrix[i][j];
//        return result;
//    }
//}