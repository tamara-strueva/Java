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
        return this.salary;
    }

    // метод, возвращающий ID
    @Override
    public int getId() {
        return this.id;
    }

    // метод, возвращающий фамилию
    @Override
    public String getLastName() {
        return this.lastName;
    }

    // метод, возвращающий имя
    @Override
    public String getFirstName() {
        return this.firstName;
    }
}
