package tamara.homework3.transportCards;
import java.lang.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        CashMachine cc = new CashMachine();
        MobileApplication ma = new MobileApplication();
        Terminal t = new Terminal();

        Card c = new Card(1, "jio", "vn");
//        System.out.println(c.checkBalance());
        cc.topUpBalance(c, 1000);
//        System.out.println(c.checkBalance());

        StudentCard sc = new StudentCard(2, "hfu", "hb");
        ma.payMonth(sc, 450);
//        t.paymentForTravel(sc);

        StudentCard sc1 = new StudentCard(2, "Иванов", "Иван");
        cc.payMonth(sc1, 440);
//        t.paymentForTravel(sc1);

        t.paymentForTravel(c);
        System.out.println();
        t.paymentForTravel(sc);
        System.out.println();
        t.paymentForTravel(c);
        System.out.println();
        t.paymentForTravel(sc1);
        System.out.println();
        t.paymentForTravel(c);
        System.out.println();
        t.paymentForTravel(c);
        System.out.println();
        t.getStatistic();
    }
}
