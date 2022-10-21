package tamara.seminar3.workers;

public class EmployeesWithHourRate extends Employee{
    double rate;
    int id;
    String lastName, firstName;

    // конструктор класса
    EmployeesWithHourRate(int id, String lastName, String firstName, double rate) {
        this.rate = rate;
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    // унаследованный метод для получения среднемесячной зарплаты
    @Override
    double getAverageSalary() {
        double averageSalary = 20.8 * 8 * this.rate;
//        System.out.println("Среднемесячная зарплата работника с почасовой ставкой: " + averageSalary);
        return averageSalary;
    }

    // метод, выводящий зарплпту, для сортировки списка работников
    public double getSalary() {
        return 20.8 * 8 * this.rate;
    }

    public int getId() {
        return this.id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }
}
