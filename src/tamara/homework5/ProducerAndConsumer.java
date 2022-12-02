package tamara.homework5;

public class ProducerAndConsumer {
    public static void main(String[] args) {
        Market market = new Market(1000); // создание рынка вместимостью 1000
        Producer producer = new Producer(market); // создание производителя
        Consumer consumer = new Consumer(market); // создание потребителя
        producer.start(); // запуск производства
        consumer.start(); // запуск потребления
    }
}

// класс общего буфера (рынок), где производитель производит, а потребитель потребляет)
class Market {
    private int numberOfProducts = 0; // количество товаров, по умолчанию пусто
    int size; // вместительность рынка

    Market(int size) {
        this.size = size;
    }

    // метод, который забирает товар с рынка
    public synchronized void get() {
        // пока количество товоров 0, ждет
        while (numberOfProducts < 1) {
            try {
                wait();
            } catch (InterruptedException exception) {
                System.out.println("На складе пусто");
            }
        }
        // в другом случае, убирает по один товару и выводит сообщение
        numberOfProducts--;
        System.out.println("Покупатель купил один товар");
        System.out.println("Количество товаров на складе: " + numberOfProducts);
        notify();
    }

    // метод, который добавляет товар на рынок
    public synchronized void put() {
        // пока рынок наполнен, ждет
        while (numberOfProducts >= size) {
            try {
                wait();
            } catch (InterruptedException exception) {
                System.out.println("На складе переизбыток товара");
            }
        }
        // если место есть, прибавляет по одному товару и выводит сообщение
        numberOfProducts++;
        System.out.println("\u001B[32mПроизводитель добавил один товар\u001B[0m");
        System.out.println("Количество товаров на складе: " + numberOfProducts);
        notify();
    }
}

// поток производителя
class Producer extends Thread {
    Market market; // общий буфер

    // конструктор производителя, определяет рынок, на который тот будет поставлять товар
    Producer(Market market){
        this.market = market;
    }

    // метод запуска производства, вызывает метод рынка, который добавляет товар
    public void run() {
        for(int i = 0; i < market.size; i++) {
            market.put();
        }
    }
}

// поток потребителя
class Consumer extends Thread {
    Market market;

    // конструктор потребителя, который определяет рынок, на котором тот будет приобретать товар
    Consumer(Market market) {
        this.market = market;
    }

    // метод запуска потребления, вызвает метод рынка, который забирает товар
    public void run() {
        for(int i = 0; i < market.size; i++) {
            market.get();
        }
    }
}
