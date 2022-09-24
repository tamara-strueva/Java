package tamara.homework1.Shapes;

public class Ball extends SolidOfRevolution {
    public Ball(double radius) {
        this.radius = radius;
    }

    public double geVolume() {
        return 4.0/3*Math.PI*Math.pow(radius, 3);
    }
}
