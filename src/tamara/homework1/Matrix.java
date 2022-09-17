package tamara.homework1;
import java.util.Arrays;

public class Matrix {
    int[][] data = null;
    int rows;
    int columns;

    Matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.data = new int[rows][columns];
    }

    public static void main(String[] args){
        Matrix a = new Matrix(3, 4);
        Matrix b = new Matrix(3, 4);
        a.setMatrix(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}});
        a.getMatrix();
//        System.out.println(a.toString());
//        a.addMatrix(b);
    }

    public Matrix setMatrix(int[][] array){
        Matrix newMatrix = new Matrix(this.rows, this.columns);

        try {
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    newMatrix.data[row][column] = array[row][column];
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("!!Введенный массив не соразмерен матрице!!");
        }

        return newMatrix;
    }

    public String toString() {
        return Arrays.deepToString(this.data);
    }

    public int getMatrix() {
        for(int row = 0; row < rows; row++){
            for(int column = 0; column < columns; column++){
                System.out.print(data[row][column]);
                System.out.print("\t");
            }
            System.out.println();
        }
        return this.data[this.rows][this.columns];
    }

    // метод, вычисляющий сумму матриц
    public void addMatrix(Matrix matrix2) {
        Matrix result = new Matrix(this.rows, this.columns);

        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                result.data[row][column] = this.data[row][column] + matrix2.data[row][column];
            }
        }
        System.out.println(result.getMatrix());
    }
/*
    public void multiplyOnNumber() {

    }

    public void multiplyMatrixes() {

    }

    public void transrose() {

    }

    public void power() {

    }
    */
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