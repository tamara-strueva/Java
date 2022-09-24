package tamara.homework1.Shapes;

public abstract class Shape {
    private double volume;

    public double getVolume() {
        return volume;
    }
}
// только в 4 задании класс становится обстрактным, так как он не имеет собственных методов
// этот класс является основой для других фигур, нам не нужно создавать объекты класса Shape
// аналогично класс SolidOfRevolution сделаем абстрактным

