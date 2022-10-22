package tamara.homework3.transportCards;
import java.lang.*;
import java.util.*;

public class SchoolCard extends Card{
    double payment;
    double balance;
    boolean month;

    public SchoolCard(int id, String ownerLastName, String ownerName) {
        super(id, ownerLastName, ownerName);
        this.balance = 0;
        this.payment = 435;
        this.month = false;
    }

    // метод, проверяющий, была ли карта пополнена на месяц
    public boolean checkPayedMonth() {return this.month;}
}
