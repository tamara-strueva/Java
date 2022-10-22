package tamara.homework3.transportCards;
import java.lang.*;

public class Card {
    double payment;
    int id;
    String ownerLastName, ownerName;
    double balance;

    // конструктор, создвет карту, у которой есть номер, владелец и баланс (изначально нулевой)
    public Card(int id, String ownerLastName, String ownerName) {
        this.id = id;
        this.ownerLastName = ownerLastName;
        this.ownerName = ownerName;
        this.balance = 0;
        this.payment = 51;
    }

    public int getId() {return this.id;}

    public String getOwnerLastName() {return ownerLastName;}

    public String getOwnerName() {return this.ownerName;}

    public double checkBalance() {return this.balance;}

    public double getPayment() {return this.payment;}

}
