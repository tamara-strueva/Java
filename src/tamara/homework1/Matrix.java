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
        a.printOutMatrix();
    }

    public void fillInMatrix(){
        // высчитывать количество строк и столбцов
        // просить заполнить через консоль или рандом
    }

    public void printOutMatrix() {
        for(int row = 0; row < rows; row++){
            for(int column = 0; column < columns; column++){
                System.out.print(data[row][column] + " ");
            }
            System.out.println();
        }
    }

    /*
    public void additionAndSubtraction() {

    }

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
