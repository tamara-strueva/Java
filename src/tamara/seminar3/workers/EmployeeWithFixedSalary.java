package tamara.seminar3.workers;

public class EmployeeWithFixedSalary extends Employee {
    double salary;

    // конструктор класса
    EmployeeWithFixedSalary(double salary) {
        this.salary = salary;
    }

    // унаследованыый метод вывода среднемесячной зарплаты
    @Override
    void getAverageSalary() {
        System.out.println("Среднемесячная зарплата работника с фиксированной заработной платой: " + this.salary);
    }

    // метод возвращающий размер зарплаты, будем использовать для сравнения
    public double getSalary() {
        return this.salary;
    }
}
