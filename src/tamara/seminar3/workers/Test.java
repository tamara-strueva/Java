package tamara.seminar3.workers;

public class Test {
    public static void main (String[] args) {
        Full f = new Full();
        f.createEmployees();
        f.getEmployees();
//        System.out.println("Сортировка от минимума к максимуму");
//        f.sortEmployeesListMinMax();
//        f.getEmployees();
//        System.out.println("Сортировка от максимума к минимуму");
        f.sortEmployeesListMaxMin();
        f.getEmployees();
//        System.out.println("first 5");
//        f.getFirst5employees();
//        System.out.println("last 3");
//        f.getLast3employees();
        f.saveFile("employees.txt");
        f.loadFile("employees.txt");
    }
}
