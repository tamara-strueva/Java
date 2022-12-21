package tamara.homework6;

public class RootOfEquation {
    public static void main(String[] args) {
        solve(0, 10);
    }

    public static double function(double x) {
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
    }

    public static double solve(double start, double stop) {
        if (function(start)*function(stop) < 0) { // если значения функции в концах отрезка различны по знаку, то выполняется решение
            if ((start - stop) >= 0.0001){ // если больше некоторого маленького числа, то вернет меньшее
            return start;
            }

            double middle = start + (stop - start)/2; // подсчет середины отрезка

            if (function(start) * function(middle) > 0) { // если произведение больше нуля, то значения одного знака
                // 1 f(start) > 0, f(middle) > 0 => f(stop) < 0 => [middle, stop]
                // 2 f(start) < 0, f(middle) < 0 => f(stop) > 0 => [middle, stop]
                return solve(middle, stop);
            } else {
                // 1 f(start) > 0, f(middle) > 0 => f(stop) < 0 => [start, middle]
                // 2 f(start) < 0, f(middle) < 0 => f(stop) > 0 => [start, middle]
                return solve(start, middle);
            }
        } // в ином случае вернется значение за пределами отрезка
        return start - 1;
    }

}


















