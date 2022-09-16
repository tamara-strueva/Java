package tamara.homework1;

public class Matrix {
    private int[][] data = null;
    private int rows;
    private int columns;

    Matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.data = new int[rows][columns];
    }

    public static void main(String[] args){
        Matrix a = new Matrix(3, 4);
        //a.getMatrix();
        Matrix b = new Matrix(3, 4);
        a.addMatrix(b);
    }

    public void setMatrix(){
        // высчитывать количество строк и столбцов
        // просить заполнить через консоль или рандом
    }

    public int getMatrix() {
        for(int row = 0; row < rows; row++){
            for(int column = 0; column < columns; column++){
                System.out.print(data[row][column] + " ");
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
