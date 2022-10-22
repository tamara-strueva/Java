package tamara.homework3.transportCards;
import java.lang.*;
import java.util.*;

public class MobileApplication {
    public void topUpBalance(Card card, double amount) {
        card.balance += amount;
        System.out.println("\u001B[31m Баланс успешно пополнен. \u001B[0m");
    }

    public boolean payMonth(Card card, double amount) {
        // сначала проверяем класс
        Class clas = card.getClass();
        // проверка на то, что карта является одной из социальных
        if(clas == SchoolCard.class || clas == SocialCard.class || clas == StudentCard.class) {
            // пополнение карты на месяц, если средств достаточно
            if (amount >= 435 && clas == StudentCard.class) {
                System.out.println("\u001B[32m Пополнено на месяц! \u001B[0m");
                return ((StudentCard) card).month = true;
            } else if  (amount >= 435 && clas == SocialCard.class) {
                System.out.println("\u001B[32m Пополнено на месяц! \u001B[0m");
                return ((SocialCard) card).month = true;
            } else if (amount >= 435 && clas == SchoolCard.class) {
                System.out.println("\u001B[32m Пополнено на месяц! \u001B[0m");
                return ((SchoolCard) card).month = true;
            } else {
                System.out.println("\u001B[31m Недостаточно средств, проезд на месяц не пополнен \u001B[0m");
            }
            //вывод сообщения об ошибке, если средств недостаточно
        }else {
            System.out.println("\u001B[31m Что-то пошло не так! \u001B[0m");
            return false;
        }
        return true;
    }

}
