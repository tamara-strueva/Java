package tamara.homework1.Shapes;

import tamara.Main;

public class Cylinder extends SolidOfRevolution{
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getVolume() {
        return Math.PI*Math.pow(radius, 2)*height;
    }
}
