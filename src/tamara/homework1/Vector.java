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

    public String toString() {
        return "{" + x + "; " + y + "; " + z + "}";
    }

    public Vector getVector() {
        Vector v = this;
        System.out.println("{" + this.x + "; " + this.y + "; " + this.z + "}");
        return v;
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
        System.out.println("Сумма = {" + coordinateX + "; " + coordinateY + "; " + coordinateZ + "}");
        // возвращать новый вектор
    }

    // метод, вычисляющий разницу векторов
    public void subtractionOfVectors(Vector vector2) {
        double coordinateX = this.x - vector2.x;
        double coordinateY = this.y - vector2.y;
        double coordinateZ = this.z - vector2.z;
        System.out.println("Разница = {" + coordinateX + "; " + coordinateY + "; " + coordinateZ + "}");
        // возвращать новый вектор
    }

    public void massiveOfVectors(int number) {
        Vector[] massive = new Vector[number];
        for(int i = 0; i < number; i++){
            Vector v = new Vector((-50) + (int) (Math.random() * 50),
                    (-15) + (int) (Math.random() * 50),(-50) + (int) (Math.random() * 50));
            massive[i] = v;
        }
//        System.out.println(Arrays.deepToString(massive));
        for (int v = 0; v < number; v++) {
            System.out.println(massive[v].toString());
        }
    }

}

//    public static Vector[] generate(int number) {
//        Vector[] vectors = new Vector[number];
//        for (int i = 0; i < number; i++) {
//            vectors[i] = new Vector(Math.random(),Math.random(),Math.random());
//        }
//        System.out.println(Arrays.deepToString(vectors));
//        return vectors;
//    }