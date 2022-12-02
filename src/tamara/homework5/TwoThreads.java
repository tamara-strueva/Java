package tamara.homework5;

public class TwoThreads {
    public static void main(String[] args) {
        FirstThread firstThread = new FirstThread("first"); // создание первого потока и присваивание ему имени
        SecondThread secondThread = new SecondThread("second"); // создание второго потока и присваивание ему имени
        firstThread.start(); // запуск первого потока
        new Thread(secondThread).start(); // запуск второго потока
    }
}

// первый поток
class FirstThread extends Thread {
    String name;

    // конструктор первого потока, присваивающий имя
    FirstThread(String name) {
        this.name = name;
    }

    // метод, запускающий поток и выводящий его имя
    public void run() {
        System.out.println(name);
    }
}

// второй поток
class SecondThread extends Thread {
    String name;

    // конструктор второго потока, присваивающий имя
    SecondThread(String name) {
        this.name = name;
    }

    // метод, запускающий поток и выводящий его имя
    public void run() {
        System.out.println(name);
    }
}