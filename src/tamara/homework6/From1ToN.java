package tamara.homework6;

public class From1ToN {
    public static void main(String[] args) {
        System.out.println(from1ToN(5));
    }

    public static String from1ToN(int n) {
        if (n < 1) { // сразу отметаем если число меньше единицы
            return "Число не должно быть меньше единицы";
        } else if (n > 1) { // если число большеединицы, то рекурсивно выводим последовательность
            return from1ToN(n - 1) + "\n" + n;
        } // если число это 1, то просто ее выводим
        return "1";
    }
}