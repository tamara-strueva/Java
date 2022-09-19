package tamara.homework1;
import java.util.*;

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
        a.getMatrix();
        System.out.println();
//        Matrix d = new Matrix(4, 2);
//        d.setMatrix(new int[][] {{5, 3}, {6, 2}, {8, -7}, {-1, 4}});
//        d.getMatrix();
        Matrix b = new Matrix(3,4);
        b.setMatrix(new int[][] {{12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}});
        b.getMatrix();
        System.out.println();
        a.multiplyMatrixes(b);
//        System.out.println();
//        Matrix b = new Matrix(3,4);
//        b.setMatrix(new int[][] {{12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}});
//        Matrix c = new Matrix(2, 2);
//        c.setMatrix(new int[][] {{1,2}, {3,4}});
//        c.multiplyMatrixOnNumber(4);
//        a.getMatrix();
//        System.out.println("&&&");
//        b.getMatrix();
//        System.out.println("***");
//        a.addMatrix(b);
//        a.subtractMatrix(b);
    }

    public Matrix setMatrix(int[][] array){
        try {
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    data[row][column] = array[row][column];
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("\u001B[31m Введенный массив не соразмерен матрице! \u001B[0m");
        }

        return this;
    }

    public void getMatrix() {
        for(int row = 0; row < rows; row++){
            for(int column = 0; column < columns; column++){
                System.out.print(data[row][column]);
                System.out.print("\t");
            }
            System.out.println();
        }
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

    public Matrix transroseMatrix() {
        Matrix newMatrix = new Matrix(this.columns, this.rows);
        try {
            for (int column = 0; column < columns; column++) {
                for (int row = 0; row < rows; row++) {
                    newMatrix.data[column][row] = this.data[row][column];
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("\u001B[31m что-то пошло не так \u001B[0m");
        }
        newMatrix.getMatrix();
        return newMatrix;
    }

    public Matrix transrosedMatrix() {
        // для умножения, чтоб не выводился результат
        Matrix newMatrix = new Matrix(this.columns, this.rows);
        try {
            for (int column = 0; column < columns; column++) {
                for (int row = 0; row < rows; row++) {
                    newMatrix.data[column][row] = this.data[row][column];
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("\u001B[31m что-то пошло не так \u001B[0m");
        }
        return newMatrix;
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

    public void multiplyMatrixes(Matrix matrix) {
        if (this.columns == matrix.rows) {
            Matrix result = new Matrix(this.rows, matrix.columns);
            Matrix tempMatrix = matrix.transrosedMatrix();
            int[][] resultOfMultyply = new int[this.rows][matrix.columns];
            List tempResultList = new ArrayList();

            for (int row1 = 0; row1 < this.rows; row1++) { // цикл по первой матрице, по ее строкам
                for (int row2 = 0; row2 < matrix.columns; row2++) { // цикл по строкам транспонированной матрицы
                    int res = 0;
//                    System.out.println("#");
                    for (int column = 0; column < this.columns; column++) { // цикл по колонкам (они одинаковые в любом случае)
                        // сумма 1 и 1, сумма 1 и 2
                        int r = this.data[row1][column] * tempMatrix.data[row2][column];
                        res += r;
//                        System.out.println("&" + res);
                    }
                    tempResultList.add(res); // добаление значения в общий список
                }
            }

            for (int row = 0; row < result.rows; row++) {
                for (int column = 0; column < result.columns; column++) {
                    resultOfMultyply[row][column] = (int) tempResultList.get(row * result.columns + column);
                }
            }
//            System.out.println(Arrays.deepToString(resultOfMultyply));

            result.setMatrix(resultOfMultyply);
            result.getMatrix();

        }else {
            System.out.println("\u001B[31m Невозможно перемножить матрицы \u001B[0m");
        }

    }

//    public void power() {
//
//    }
}
