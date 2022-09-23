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
//        Matrix a = new Matrix(3, 4);
//        a.setMatrix(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
//        a.getMatrix();
//        System.out.println();
//        Matrix b = new Matrix(3,4);
//        b.setMatrix(new int[][] {{12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}});
//        b.getMatrix();
//        System.out.println();
//        Matrix c = new Matrix(2, 2);
//        c.setMatrix(new int[][] {{1,2}, {3,4}});
//        Matrix d = new Matrix(4, 2);
//        d.setMatrix(new int[][] {{5, 3}, {6, 2}, {8, -7}, {-1, 4}});
//        d.getMatrix();
//        Matrix e = new Matrix(2, 2);
//        e.setMatrix(new int[][] {{-2, 5}, {4, -3}});
//        a.multiplyMatrixes(b);
//        c.multiplyMatrixOnNumber(4);
//        a.addMatrix(b);
//        a.subtractMatrix(b);
//        e.powerMatrix(3);
    }

    // метод, выводящий матрицу на экран
    public void getMatrix() {
        for(int row = 0; row < rows; row++){
            for(int column = 0; column < columns; column++){
                System.out.print(data[row][column]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    // метод, заполняющий матрицу
    public void setMatrix(int[][] array){
        try {
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    data[row][column] = array[row][column];
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("\u001B[31m Введенный массив не соразмерен матрице! \u001B[0m");
        }
    }

    // метод, вычисляющий сумму матриц
    public void addMatrix(Matrix matrix2) {
        try {
            Matrix result = new Matrix(this.rows, this.columns);
            for(int row = 0; row < rows; row++) {
                for(int column = 0; column < columns; column++) {
                    result.data[row][column] = this.data[row][column] + matrix2.data[row][column];
                }
            }
            System.out.println("\u001B[32m Результат сложения матриц: \u001B[0m");
            result.getMatrix();
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("\u001B[31m Mistake! \u001B[0m");
        }

    }

    // метод, вычисляющий разницу матриц
    public void subtractMatrix(Matrix matrix2) {
        try {
            Matrix result = new Matrix(this.rows, this.columns);
            for(int row = 0; row < rows; row++) {
                for(int column = 0; column < columns; column++) {
                    result.data[row][column] = this.data[row][column] - matrix2.data[row][column];
                }
            }
            System.out.println("\u001B[32m Результат вычитания матриц: \u001B[0m");
            result.getMatrix();
        }catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("\u001B[31m Mistake! \u001B[0m");
        }

    }

    // метод, транспонирующий матрицу
    public Matrix transroseMatrix() {
        Matrix newMatrix = new Matrix(this.columns, this.rows);
        try {
            for (int column = 0; column < columns; column++) {
                for (int row = 0; row < rows; row++) {
                    newMatrix.data[column][row] = this.data[row][column];
                }
            }
            System.out.println("\u001B[32m Результат транспонирования матрицы: \u001B[0m");
            newMatrix.getMatrix();
            return newMatrix;
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("\u001B[31m Mistake! \u001B[0m");
            return this;
        }

    }

    // транспонирование матрицы для более простого умножения
    private Matrix transrose() {
        try {
            Matrix newMatrix = new Matrix(this.columns, this.rows);
            for (int column = 0; column < columns; column++) {
                for (int row = 0; row < rows; row++) {
                    newMatrix.data[column][row] = this.data[row][column];
                }
            }
            return newMatrix;
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("\u001B[31m что-то пошло не так \u001B[0m");
            return this;
        }
    }

    // метод, умножающий матрицу на число
    public void multiplyMatrixOnNumber(int number) {
        try {
            for (int column = 0; column < columns; column++) {
                for (int row = 0; row < rows; row++) {
                    this.data[row][column] = this.data[row][column] * number;
                }
            }
            System.out.println("\u001B[32m Результат умножения матрицы на число: \u001B[0m");
            this.getMatrix();
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("\u001B[31m Что-то пошло не так \u001B[0m");
        }
    }

    // метод, умножающий матрицу на матрицу
    public Matrix multiplyMatrixes(Matrix matrix) {
        // умножать матрицы можно только тогда, когда количество столбцов первой равно количеству строк второй
        if (this.columns == matrix.rows) {
            Matrix result = new Matrix(this.rows, matrix.columns);
            Matrix tempMatrix = matrix.transrose();
            int[][] resultOfMultyply = new int[this.rows][matrix.columns];
            ArrayList<Integer> tempResultList = new ArrayList<Integer>();

            // сначала запишем в присок построчно результат умножения матриц
            for (int row1 = 0; row1 < this.rows; row1++) { // цикл по первой матрице, по ее строкам
                for (int row2 = 0; row2 < matrix.columns; row2++) { // цикл по строкам транспонированной матрицы
                    int resultOfMupltiply = 0;
                    for (int column = 0; column < this.columns; column++) { // цикл по колонкам (они одинаковые в любом случае)
                        // так как вторая матрица транспонирована
                        // а по условию количество столбцов первой матрицы равно количеству строк второй
                        // здесь сумма 1 и 1, сумма 1 и 2
                        int tempResult = this.data[row1][column] * tempMatrix.data[row2][column];
                        resultOfMupltiply += tempResult;
                    }
                    tempResultList.add(resultOfMupltiply); // общий список значений результата
                }
            }

            // заполним матрцу значениями из списка
            // так как они идут по порядку, не обязательно из одномерноего массива делать двумерный
            for (int row = 0; row < result.rows; row++) {
                for (int column = 0; column < result.columns; column++) {
                    resultOfMultyply[row][column] = (int) tempResultList.get(row * result.columns + column);
                }
            }
            System.out.println("\u001B[32m Результат умножения матриц: \u001B[0m");
            result.setMatrix(resultOfMultyply);
            result.getMatrix();
            return result;

        }else {
            System.out.println("\u001B[31m Невозможно перемножить матрицы!! \u001B[0m");
            return this;
        }
    }

    // метод для внутреннего использования, без вывода промежуточного результата умножения
    private Matrix multiply(Matrix matrix) {
        if (this.columns == matrix.rows) {
            Matrix result = new Matrix(this.rows, matrix.columns);
            Matrix tempMatrix = matrix.transrose();
            int[][] resultOfMultyply = new int[this.rows][matrix.columns];
            ArrayList<Integer> tempResultList = new ArrayList<Integer>();

            for (int row1 = 0; row1 < this.rows; row1++) { // цикл по первой матрице, по ее строкам
                for (int row2 = 0; row2 < matrix.columns; row2++) { // цикл по строкам транспонированной матрицы
                    int res = 0;
                    for (int column = 0; column < this.columns; column++) { // цикл по колонкам (они одинаковые в любом случае)
                        int r = this.data[row1][column] * tempMatrix.data[row2][column];
                        res += r;
                    }
                    tempResultList.add(res); // добаление значения в общий список
                }
            }

            for (int row = 0; row < result.rows; row++) {
                for (int column = 0; column < result.columns; column++) {
                    resultOfMultyply[row][column] = (int) tempResultList.get(row * result.columns + column);
                }
            }
            result.setMatrix(resultOfMultyply);
            return result;

        }else {
            System.out.println("\u001B[31m Невозможно перемножить матрицы \u001B[0m");
            return this;
        }
    }

    // метод, возводящий матрицу в степень
    public void powerMatrix(int power) {
        // возведение матрицы в степень то же самое, что умножение матрицы на саму себя определенное количество раз
        // следовательно, возвести в степень можно только квадратную матрицу
        if (this.rows == this.columns) {
            Matrix result = this;
            int count = 1;
            while (count < power) {
                result = result.multiply(this);
                count++;
            }
            System.out.println("\u001B[32m Результат возведения матрицы в степень: \u001B[0m");
            result.getMatrix();
        }else {
            System.out.println("\u001B[31m Возвести в степень можно только квадратную матрицу \u001B[0m");
        }
    }

}