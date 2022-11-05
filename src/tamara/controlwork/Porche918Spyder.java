package tamara.controlwork;

public class Porche918Spyder extends Car {
    double length, width;
    String type, drive; // легковой, грузовой или спортивный автомобиль / привод - передний или задний
    boolean isOpenRoof, hasHatch; // открывается крыша или есть люк на ней

    public Porche918Spyder(String color, int maxSpeed, String transmissionType, int currentSpeed, double price, String drive) {
        super(color, maxSpeed, transmissionType, currentSpeed, price);
        this.length = 464.5;
        this.width = 194.0;
        this.type = "hybrid supercar";
        this.drive = drive;
        this.isOpenRoof = true;
        this.hasHatch = false;
    }

    // метод, открывающий крышу кабриолета
    public void openRoof(){
        if(isOpenRoof) {
            System.out.println("The roof is opened!");
        }else {
            System.out.println("This car is not cabriolet!");
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

    // методы, возвращающие параметры

    public double getSize(){return this.width * this.length;}

    public String getType(){return this.type;}

    public String getDrive(){return this.drive;}
}
