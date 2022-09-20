package tamara.homework1.Shapes;

public class Box {
    private double volume;

    public Box(double volume) {
        this.volume = volume;
    }

    public boolean add(Shape shape) {
        this.volume -= shape.getVolume();
        return this.volume >= 0;
    }
}
