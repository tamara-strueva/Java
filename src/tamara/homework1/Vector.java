package tamara.homework1;

public class Vector {
    double x, y, z;

    // конструктор, по умолчанию все координаты = 0
    public Vector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    // конструктор класса с указанными координатами
    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void getVector() {
        System.out.println("{" + this.x + "; " + this.y + "; " + this.z + "}");
    }

    //метод, вычисляющий длину вектора
    public double calculateModule() {
        double module = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
        System.out.println("Длина вектора: " + module);
        return module;
    }

    //метод, вычисляющий скалярное произведение двух векторов
    public double calculateScalarProduct(Vector vector2) {
        double scalarProduct = this.x * vector2.x + this.y * vector2.y + this.z * vector2.z;
        System.out.println("Скалярное произведение векторов: " + scalarProduct);
        return scalarProduct;
    }

    //метод, вычисляющий векторное произведение с другим вектором
    public void calculateTheVectorProduct(Vector vector2) {
        double vectorProductX = this.y * vector2.z - this.z * vector2.y;
        double vectorProductY = this.z * vector2.x - this.x * vector2.z;
        double vectorProductZ = this.x * vector2.y - this.y * vector2.x;
        System.out.println("{" + vectorProductX + "; " + vectorProductY + "; " + vectorProductZ + "}");
        // возвращать новый вектор?
    }

    // метод, вычисляющий угол между векторами
    public void calculateAngleBetweenVectors(Vector vector2) {
        double scalarProductOfVectors = this.calculateScalarProduct(vector2);
        double moduleVector1 = this.calculateModule();
        double moduleVector2 = vector2.calculateModule();
        double cosinus = scalarProductOfVectors / (moduleVector1 * moduleVector2);
        System.out.println("Косинус между векторами: " + cosinus);
    }

    // метод, вычисляющий сумму векторов
    public void additionOfVectors(Vector vector2) {
        double coordinateX = this.x + vector2.x;
        double coordinateY = this.y + vector2.y;
        double coordinateZ = this.z + vector2.z;
        System.out.println("{" + coordinateX + "; " + coordinateY + "; " + coordinateZ + "}");
        // возвращать новый вектор
    }

    // метод, вычисляющий разницу векторов
    public void subtractionOfVectors(Vector vector2) {
        double coordinateX = this.x - vector2.x;
        double coordinateY = this.y - vector2.y;
        double coordinateZ = this.z - vector2.z;
        System.out.println("{" + coordinateX + "; " + coordinateY + "; " + coordinateZ + "}");
        // возвращать новый вектор
    }

    public static void massiveOfVectors(int number) {
        int[] massive = new int[number];
        // выведет список, в котором списками? хранятся векторы
    }

}
