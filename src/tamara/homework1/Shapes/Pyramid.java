package tamara.homework1.Shapes;

public class Pyramid extends Shape {
    private double s;
    private double h;

    public Pyramid(double s, double h) {
        this.s = s;
        this.h = h;
    }

    public double getVolume(){
        return 1.0/3*s*h;
    }
}
