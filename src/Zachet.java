import java.util.Random;

public class Zachet {
    public static void main(String[] args) {
        Artur artur = new Artur();
        Semen semen = new Semen();
        Danil danil = new Danil();

        artur.start();
        semen.start();
        danil.start();
    }
}

class Artur extends Thread {
    public void run() {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            int point = (1) + (int) (Math.random() * 11);
//            System.out.println("артур " + point);

            if (point == 10) {
                count += point;
                System.out.println("\u001B[32mМеткий выстрел!\u001B[0m");
            } else if (point == 9 || point == 8) {
                count += point;
                System.out.println("\u001B[33mНеплохо\u001B[0m");
            } else if (point > 4 && point < 8) {
                count += point;
                System.out.println("\u001B[36mТак себе\u001B[0m");
            } else {
                System.out.println("\u001B[31mМазила!\u001B[0m");
            }
//            try {
//                sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }

        if (count < 10) {
            System.out.println("Общее число очков Артура: " + "0" + count);
        }else {
            System.out.println("Общее число очков Артура: " + count);
        }
    }
}

class Semen extends Thread {
    public void run() {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            int point = (1) + (int) (Math.random() * 11);
//            System.out.println("семен " + point);

            if (point == 10) {
                count += point;
                System.out.println("\u001B[32mМеткий выстрел!\u001B[0m");
            } else if (point == 9 || point == 8) {
                count += point;
                System.out.println("\u001B[33mНеплохо\u001B[0m");
            } else if (point > 4 && point < 8) {
                count += point;
                System.out.println("\u001B[36mТак себе\u001B[0m");
            } else {
                System.out.println("\u001B[31mМазила!\u001B[0m");
            }
//            try {
//                sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }


        if (count < 10) {
            System.out.println("Общее число очков Семена: " + "0" + count);
        }else {
            System.out.println("Общее число очков Семена: " + count);
        }
    }
}

class Danil extends Thread {
    public void run() {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            int point = (1) + (int) (Math.random() * 11);
//            System.out.println("данил " + point);

            if (point == 10) {
                count += point;
                System.out.println("\u001B[32mМеткий выстрел!\u001B[0m");
            } else if (point == 9 || point == 8) {
                count += point;
                System.out.println("\u001B[33mНеплохо\u001B[0m");
            } else if (point > 4 && point < 8) {
                count += point;
                System.out.println("\u001B[36mТак себе\u001B[0m");
            } else {
                System.out.println("\u001B[31mМазила!\u001B[0m");
            }
//            try {
//                sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }


        if (count < 10) {
            System.out.println("Общее число очков Данила: " + "0" + count);
        }else {
            System.out.println("Общее число очков Данила: " + count);
        }
    }
}
