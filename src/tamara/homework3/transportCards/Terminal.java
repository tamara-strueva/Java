package tamara.homework3.transportCards;
import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Terminal {
    ArrayList<String> statistics = new ArrayList<>();

    // метод оплаты проезда, в аргументе карта, которой платят
    public void paymentForTravel(Card card) {
        //проверка класса
        Class clas = card.getClass();

        // если класс не социальной карты, то списывается оплата за один проезд
        if (clas == Card.class) {
            double balance = card.balance;
            if (balance > 51) {
                card.balance -= 51;
                statistics.add("прошли");
                statistics.add("разовая");
                statistics.add("поездка");
                System.out.println("\u001B[32m Успешно! \u001B[0m");
                System.out.println("Остаток на балансе:" + card.checkBalance());
            } else {
                System.out.println("\u001B[31m Недостаточно средств! Пополните баланс! \u001B[0m");
            }
            // если карта является одной из социальных, то идет проверка оплаты проезда на месяц
        } else if (clas == StudentCard.class) {
            if (((StudentCard) card).checkPayedMonth()) {
                statistics.add("прошли");
                System.out.println("\u001B[32m Успешно! \u001B[0m");
            } else {
                System.out.println("\u001B[31m Пополните карту на месяц \u001B[0m");
            }
        } else if (clas == SchoolCard.class) {
            if (((SchoolCard) card).checkPayedMonth()) {
                statistics.add("прошли");
                System.out.println("\u001B[32m Успешно! \u001B[0m");
            } else {
                System.out.println("\u001B[31m Пополните карту на месяц \u001B[0m");
            }
        } else if (clas == SocialCard.class) {
            if (((SocialCard) card).checkPayedMonth()) {
                statistics.add("прошли");
                System.out.println("\u001B[32m Успешно! \u001B[0m");
            } else {
                System.out.println("\u001B[31m Пополните карту на месяц \u001B[0m");
            }
        }
    }

    public void getStatistic() {
        int count1 = 0; // проходимость
        float count2 = 0; // поштучные
        int income = 0; // заработок на поштучных проездах

        // проходим по списку и вычисляем соунты и заработок
        for (int i = 0; i < statistics.size(); i++) {
            if (Objects.equals(statistics.get(i), "прошли")) {
                count1 += 1;
            }else if (Objects.equals(statistics.get(i), "разовая")) {
                count2 += 1;
            }else if (Objects.equals(statistics.get(i), "поездка")) {
                income += 51;
            }
        }

        // высчитать процент разовых поездок по отношению к проходимости, всего проходов и доход терминала
        double relation = (count2/count1)*100;
        String result = String.format("%.2f", relation);
        System.out.println("Процент отношения разовых поездок ко всем: " + result + "%");
        System.out.println("Всего проходов через терминал: " + count1);
        System.out.println("Терминал заработал: " + income + "руб.");
    }

}
