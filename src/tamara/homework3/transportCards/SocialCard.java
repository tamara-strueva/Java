package tamara.homework3.transportCards;
import java.lang.*;
import java.util.*;

public class SocialCard extends Card{
    double payment;
    double balance;
    boolean month;

    // конструктор класса
    public SocialCard(int id, String ownerLastName, String ownerName) {
        super(id, ownerLastName, ownerName);
        this.balance = 0;
        this.payment = 500;
        this.month = false;
    }

    // метод, проверяющий, была ли карта пополнена на месяц
    public boolean checkPayedMonth() {return this.month;}

}
