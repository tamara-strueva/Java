package tamara.seminar3.workers;

public class EmployeesWithHourRate extends Employee{
    double rate;
    String lastName, firstName;
    int id;

    // конструктор класса
    EmployeesWithHourRate(int id, String lastName, String firstName, double rate) {
        this.rate = rate;
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
    }

    // унаследованный метод для получения среднемесячной зарплаты
    @Override
    void getAverageSalary() {
        double averageSalary = 20.8 * 8 * this.rate;
        System.out.println("Среднемесячная зарплата работника с почасовой ставкой: " + averageSalary);
    }

    public double getRate() {
        return this.rate;
    }
}
