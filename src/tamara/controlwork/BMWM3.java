package tamara.controlwork;

public class BMWM3 extends Car{
    double length, width;
    String type, drive; // легковой, грузовой или спортивный автомобиль / привод - передний или задний
    boolean isOpenRoof, hasHatch; // открывается крыша или есть люк на ней

    public BMWM3(String color, int maxSpeed, String transmissionType, int currentSpeed, double price, String drive) {
        super(color, maxSpeed, transmissionType, currentSpeed, price);
        this.length = 467.1;
        this.width = 187.7;
        this.type = "sport car";
        this.drive = drive;
        this.isOpenRoof = false;
        this.hasHatch = true;
    }

    // метод, открывающий крышу кабриолета
    public void openRoof(){
        if (!this.isOpenRoof) {
            System.out.println("This car is not cabriolet!");
        } else {
            System.out.println("The roof is opened!");
        }
    }

    // метод, открывающий люк
    public void openHatch(){
        if (!this.hasHatch) {
            System.out.println("This does not have a hatch!");
        } else {
            System.out.println("The hatch is opened!");
        }
    }

    // методы, возвращающие параметры

    public double getSize(){return this.width * this.length;}

    public String getType(){return this.type;}

    public String getDrive(){return this.drive;}

}
