package tamara.homework2;
import java.lang.*;
import java.util.*;

public class FrequencyDictionary {

    public static void main(String[] args) {
//        countWords("i want to go home but i have to study now");
    }

    public static void countWords(String string) {
        // создаем словарь, в который потом будем добавлять значения слово=повтериния
        HashMap<String, Integer> dictionaryOfWords = new HashMap<>();
        // сплитим по пробелу, чтобы получить список из слов строки
        String[] strings = string.split(" ");
        // убираем все повторы из списка, чтобы далее провести проверку и подсчет
        LinkedHashSet<String> word = new LinkedHashSet<>(List.of(strings));
        ArrayList<String> words = new ArrayList<>(word);

        // вводим счетчик и начинаем подсчет
        int count = 0;
        // первый цикл идет по списку без дубликатов
        for (int i = 0; i < words.size(); i++) {
            // второй цикл идет по списку всех слов
            for (int j = 0; j < strings.length; j++) {
                // проверяем, есть ли совпадения, если есть, то прибавляем счетчик
                if (words.get(i).equals(strings[j])) {
                    count++;
                }
            }
            // после проверки записывает в словарь ключ и значение
            dictionaryOfWords.put(words.get(i), count);
            // обнуляем счетчик
            count = 0;
        }
        // выводим окончательный результат
        System.out.println(dictionaryOfWords);

    }
}
