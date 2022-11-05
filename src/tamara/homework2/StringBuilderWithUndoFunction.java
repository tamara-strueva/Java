package tamara.homework2;

public class StringBuilderWithUndoFunction {
    public static void main(String[] args) {
        StringBuilderWithUndoFunction s = new StringBuilderWithUndoFunction("hello, ");
        s.append(" world");
        System.out.println("&& " + s);
    }

    // интерфейс команда

    public interface Command {
        void undo();
    }

    private StringBuilder stringBuilder; // делегат

    // стек<команда>

    // конструктор класса
    public StringBuilderWithUndoFunction(String string) {
        stringBuilder = new StringBuilder(string);
    }


    // делегирование методов

    public void append(String s) {
        int length = stringBuilder.length();
        stringBuilder.append(s);
        int newLength = stringBuilder.length();

//        Command c = new Command() {
//            @Override
//            public void undo() {
//
//            }
//        };
    }

}
