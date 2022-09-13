package tamara.homework1;

public class Vector {
    int x, y, z;

    // конструктор, если не указать координаты - по умолчанию 0
    Vector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    // конструктор класса
    Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    void main(String[] args) {

    }

    //метод, вычисляющий длину вектора
    void calculateLength() {
        double length = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        System.out.println("Длина вектора: " + length);
    }

    //метод, вычисляющий скалярное произведение двух векторов
    void calculateScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = vector1.x * vector2.x +
                vector1.y * vector2.y + vector1.z * vector2.z;
        System.out.println("Скалярное произведение векторов: " + scalarProduct);
    }

    //метод, вычисляющий векторное произведение с другим вектором
    void calculateTheVectorProduct(Vector vector1, Vector vector2) {
        double vectorProductX = vector1.y * vector2.z - vector1.z * vector2.y;
        double vectorProductY = vector1.z * vector2.x - vector1.x * vector2.z;
        double vectorProductZ = vector1.x * vector2.y - vector1.y * vector2.x;
        System.out.println("x = " + vectorProductX + " y = " + vectorProductY + " z = " + vectorProductZ);
    }

    void calculateAngleBetweenVectors(Vector vector1, Vector vector2) {
        // сделать, чтоб методы возвращали значения
    }

}
