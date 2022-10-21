package tamara.seminar3.workers;

public class EmployeeWithFixedSalary extends Employee {
    double salary;
    int id;
    String lastName, firstName;

    // конструктор класса
    EmployeeWithFixedSalary(int id, String lastName, String firstName, double salary) {
        this.salary = salary;
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    // унаследованыый метод вывода среднемесячной зарплаты
    @Override
    double getAverageSalary() {
//        System.out.println("Среднемесячная зарплата работника с фиксированной заработной платой: " + this.salary);
        return this.salary;
    }

    // метод, выводящий зарплпту, для сортировки списка работников
    public double getSalary() {
        return this.salary;
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
