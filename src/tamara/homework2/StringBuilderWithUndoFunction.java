package tamara.homework2;

import java.util.Stack;

public class StringBuilderWithUndoFunction {
    // интерфейс команда
    public interface Command {
        void undo();
    }

    private StringBuilder stringBuilder; // объект
    private Stack<Command> historyOfChanges = new Stack<>(); // "стопка тарелок", в которую записываем историю изменения объекта

    // конструктор класса, в котором создается основная строка
    public StringBuilderWithUndoFunction(String string) {
        stringBuilder = new StringBuilder(string);
    }

    // делегирование методов **************************************************************************************

    // добавляет строку в конец
    public StringBuilderWithUndoFunction append(String string) {
        int length = stringBuilder.length(); // берем длину строки до аппенда
        stringBuilder.append(string); // делегируем метод
        int newLength = stringBuilder.length(); // берем длину новой строки

        // создаем команду, которую поместим в стек
        Command action = new Command() {
            @Override
            public void undo() { // записываем обратное действие
                stringBuilder.delete(newLength - length + 1, newLength);
            }
        };
        historyOfChanges.add(action); // добавляем команду в стек
        return this;
    }

    // добавляет указвнную строку по индекнам начала и конца
    public StringBuilderWithUndoFunction insert(int index, String string) {
        stringBuilder.insert(index, string); // делегируем метод

        // создаем команду, которую поместим в стек
        Command action = new Command() {
            @Override
            public void undo() { // записываем обратное действие
                stringBuilder.delete(index, index + string.length());
            }
        };
        historyOfChanges.add(action); // добавляем команду в стек
        return this;
    }

    // заменяет указанный отрезок заданной строкой
    public StringBuilderWithUndoFunction replace(int start, int stop, String string) {
        String substr = stringBuilder.substring(start, stop); // берем подстроку, чтобы потом вернуть ее в команде
        stringBuilder.replace(start, stop, string); // делегируем метод

        // создаем команду, которую поместим в стек
        Command action = new Command() {
            @Override
            public void undo() { // записываем обратное действие
                stringBuilder.replace(start, start + string.length(), substr);
            }
        };
        historyOfChanges.add(action); // добавляем команду в стек
        return this;
    }

    // удаляет символ по индексу
    public StringBuilderWithUndoFunction deleteCharAt(int index) {
        char symbol = stringBuilder.charAt(index); // берем индекс, чтобы потом вернуть его в команде
        stringBuilder.deleteCharAt(index); // делегирование метода

        // создаем команду, которую поместим в стек
        Command action = new Command() {
            @Override
            public void undo() { // записываем обратное действие
                stringBuilder.insert(index, symbol);
            }
        };
        historyOfChanges.add(action); // добавляем команду в стек
        return this;
    }

    //удаляет срез от начала до конца
    public StringBuilderWithUndoFunction delete(int start, int stop) {
        String substr = stringBuilder.substring(start, stop); // берем подстроку, чтобы потом добавить ее в команде
        stringBuilder.delete(start, stop); // делегируем метод

        // создаем команду, которую поместим в стек
        Command action = new Command() {
            @Override
            public void undo() { // записываем обратное действие
                stringBuilder.insert(start, substr);
            }
        };
        historyOfChanges.add(action); // добавляем команду в стек
        return this;
    }

    // переворачивает строку
    public StringBuilderWithUndoFunction reverse() {
        stringBuilder.reverse(); // делегируем метод

        // создаем команду, которую поместим в стек
        Command action = new Command(){
            public void undo() { // записываем обратное действие
                stringBuilder.reverse();
            }
        };
        historyOfChanges.add(action);
        return this;
    }

    // метод, отменяющий последнее изменение, но по факту он вызывает обратные действия, но возвращая строку
    public void undo(){
        if(!historyOfChanges.isEmpty()){ // если в стеке есть команды, то откат назад возможен
            historyOfChanges.pop().undo();
        }else { // в ином случае выведется сообщение об ошибке
            System.out.println("History is empty!");
        }
    }

    // метод печати строки, чтобы был нормальный вывод
    public String toString() {
        return stringBuilder.toString();
    }
}
