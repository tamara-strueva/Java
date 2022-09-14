package tamara.homework1;

public class Vector {
    double x, y, z;

    // конструктор, по умолчанию все координаты = 0
    Vector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    // конструктор класса с указанными координатами
    Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //метод, вычисляющий длину вектора
    public double calculateModule(Vector vector) {
        double module = Math.sqrt(Math.pow(vector.x, 2) + Math.pow(vector.y, 2) + Math.pow(vector.z, 2));
        System.out.println("Длина вектора: " + module);
        return module;
    }

    //метод, вычисляющий скалярное произведение двух векторов
    public double calculateScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = vector1.x * vector2.x +
                vector1.y * vector2.y + vector1.z * vector2.z;
        System.out.println("Скалярное произведение векторов: " + scalarProduct);
        return scalarProduct;
    }

    //метод, вычисляющий векторное произведение с другим вектором
    public void calculateTheVectorProduct(Vector vector1, Vector vector2) {
        double vectorProductX = vector1.y * vector2.z - vector1.z * vector2.y;
        double vectorProductY = vector1.z * vector2.x - vector1.x * vector2.z;
        double vectorProductZ = vector1.x * vector2.y - vector1.y * vector2.x;
        System.out.println("{x = " + vectorProductX + "; y = " + vectorProductY + "; z = " + vectorProductZ + "}");
    }

    public double calculateAngleBetweenVectors(Vector vector1, Vector vector2) {
        double scalarProductOfVectors = calculateScalarProduct(vector1, vector2);
        double moduleVector1 = calculateModule(vector1);
        double moduleVector2 = calculateModule(vector2);
        double cosinus = scalarProductOfVectors / (moduleVector1 * moduleVector2);
        System.out.println("Косинус между векторами: " + cosinus);
        return cosinus;
    }

    public void additionOfVectors(Vector vector1, Vector vector2) {
        double coordinateX = vector1.x + vector2.x;
        double coordinateY = vector1.y + vector2.y;
        double coordinateZ = vector1.z + vector2.z;
        System.out.println("{" + coordinateX + "; " + coordinateY + "; " + coordinateZ + "}");
    }

    public void subtractionOfVectors(Vector vector1, Vector vector2) {
        double coordinateX = vector1.x - vector2.x;
        double coordinateY = vector1.y - vector2.y;
        double coordinateZ = vector1.z - vector2.z;
        System.out.println("{" + coordinateX + "; " + coordinateY + "; " + coordinateZ + "}");
    }

    public static void massiveOfVectors(int number) {
        int[][] massive = new int[number][3];
        // выведет список, в котором списками хранятся векторы
    }

}
