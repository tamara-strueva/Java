package tamara.homework2;

// интерфейс слушателя с методом оповещения
interface Listenerr {
    void notify(StringBuilderWithObserve stringBuilder);
}

class StringBuilderWithObserve {
    StringBuilder stringBuilder; // основная строка
    Listenerr listener; // слушатель

    // конструктор класса
    public StringBuilderWithObserve() {
        stringBuilder = new StringBuilder("");
    }

    // метод уведомления об изменениях
    public void notifyAboutChanges() {
        // если есть хоть 1 слушатель, то оповещения будут приходить
        if(listener != null) {
            listener.notify(this);
        }
    }

    // создание слушателя, в качестве аргумента передается класс, который наследует интерфейс
    public void setListener(Listener listener) {
        this.listener = listener;
    }

    // делегировать методы

    public StringBuilderWithObserve append(String string) {
        stringBuilder.append(string); // делегирование метода
        notifyAboutChanges(); // оповещение слушателей
        return this;
    }

    public StringBuilderWithObserve insert(int index, String string) {
        stringBuilder.insert(index, string); // делегирование метода
        notifyAboutChanges();
        return this;
    }

    public StringBuilderWithObserve replace(int start, int stop, String string) {
        stringBuilder.replace(start, stop, string); // делегирование метода
        notifyAboutChanges(); // оповещение слушателей
        return this;
    }

    public StringBuilderWithObserve deleteCharAt(int index) {
        stringBuilder.deleteCharAt(index); // делегирование метода
        notifyAboutChanges(); // оповещение слушателей
        return this;
    }

    public StringBuilderWithObserve delete(int start, int stop) {
        stringBuilder.delete(start, stop); // делегирование метода
        notifyAboutChanges(); // оповещение слушателей
        return this;
    }

    public String toString() {
        return stringBuilder.toString();
    }

}

// создание слушателя, он создается в методе setListener, без него ничего выводиться не будет
class Listener implements Listenerr {
    @Override
    // уведоьление об изменениях определенного объекта
    public void notify(StringBuilderWithObserve stringBuilder) {
        System.out.println("\u001B[35mWe have some changes:\u001B[0m\n" + stringBuilder.toString());
    }
}

// основной класс, в котором заодно запускается проверка, потому что в одном файле надо было написать
public class StringBuilderObserveTest {
    public static void main(String[] args) {
        StringBuilderWithObserve s = new StringBuilderWithObserve();
        s.setListener(new Listener());
        s.append("hello");
        s.append(", ");
        s.append("world");
        s.insert(6, " my");
    }
}