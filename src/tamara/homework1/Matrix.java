package tamara.homework1;

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
    }

    public void fillInMatrix(){
        // высчитывать количество строк и столбцов
        // просить заполнить через консоль или рандом
    }

    public void printOutMatrix() {
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                System.out.print(data[i][j] + " ");
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
