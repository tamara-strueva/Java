package tamara.homework1.Shapes;

public class Ball extends SolidOfRevolution {
    public Ball(double radius) {
        this.radius = radius;
    }

    public double geVolume() {
        return 4.0/3*Math.PI*Math.pow(radius, 3);
    }
}
// только в 4 задании класс становится обстрактным, так как он не имеет собственных методов
// этот класс является основой для других фигур, нам не нужно создавать объекты класса Shape
// аналогично класс SolidOfRevolution сделаем абстрактным
