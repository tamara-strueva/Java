package tamara.controlwork;

public class BMWX5 extends Car {
    double length, width;
    String type, drive; // легковой, грузовой или спортивный автомобиль / привод - передний или задний
    boolean isOpenRoof, hasHatch; // открывается крыша или есть люк на ней

    public BMWX5(String color, int maxSpeed, String transmissionType, int currentSpeed, double price, String drive) {
        super(color, maxSpeed, transmissionType, currentSpeed, price);
        this.length = 485.4;
        this.width = 193.3;
        this.type = "crossover";
        this.drive = drive;
        this.isOpenRoof = false;
        this.hasHatch = false;
    }

    // метод, открывающий крышу кабриолета
    public void openRoof(){
        if (!this.isOpenRoof) {
            System.out.println("This car is not cabriolet!");
        } else {
            System.out.println("The roof is opened!");
        }
    }

    // метод, открывающий люк машины
    public void openHatch(){
        if (!this.hasHatch) {
            System.out.println("This does not have a hatch!");
        } else {
            System.out.println("The hatch is opened!");
        }
    }

    // методы, возвращающие габариты

    public double getSize(){return this.width * this.length;}

    public String getType(){return this.type;}

    public String getDrive(){return this.drive;}
}
