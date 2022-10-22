package tamara.homework3.transportCards;
import java.lang.*;
import java.util.*;

public class StudentCard extends Card{
    double payment; // стоимость проезда на месяц
    boolean month; // был ли оплачен месяц

    // конструктор, создвет карту, у которой есть номер, владелец и баланс (изначально нулевой)
    public StudentCard(int id, String ownerLastName, String ownerName) {
        super(id, ownerLastName, ownerName);
        this.balance = 0;
        this.payment = 435;
        this.month = false;
    }

    // метод, проверяющий, была ли карта пополнена на месяц
    public boolean checkPayedMonth() {return this.month;}

}
