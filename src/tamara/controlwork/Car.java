package tamara.controlwork;

public class Car {
    String color, transmissionType;
    double maxSpeed, currentSpeed, price, length, width;

    // конструктор класса
    public Car(String color, int maxSpeed, String transmissionType, int currentSpeed, double price) {
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.transmissionType = transmissionType;
        this.currentSpeed = currentSpeed;
        this.price = price;
    }

    // метод начала движения
    public void start() {
        System.out.println("A Car started");
    }

    // метод прекращения движения
    public void stop() {
        System.out.println("A Car stopped");
    }

    // метод поворота
    public void turn(String side) {
        System.out.println("A Car turned to the " + side);
    }

    // метод ускорения (до максимальной скорости, не выше)
    public double accelerate(int speed) {
        // если текущая скорость + ускорение меньше максимальной скорости, то машина ускорится
        if (this.currentSpeed + speed < this.maxSpeed) {
            return this.currentSpeed += speed;
        } // в противном случае скорость останется прежней
        else {
            System.out.println("Impossible to accelerate!");
            return this.currentSpeed;
        }
    }

    // метод торможения, аналогичен ускорению, но разность текущей скорости и торможения не должна быть меньше нуля
    public double slowDown(int speed) {
        if (this.currentSpeed - speed >= 0) {
            return this.currentSpeed -= speed;
        }else {
            System.out.println("Current speed is lower than argument!");
            return this.currentSpeed;
        }
    }

    // методы возвращающие атрибуты

    public String getColor(){return this.color;}

    public double getMaxSpeed(){return this.maxSpeed;}

    public String getTransmissionType(){return this.transmissionType;}

    public double getCurrentSpeed(){return this.currentSpeed;}

    public double getPrice(){return this.price;}
}
