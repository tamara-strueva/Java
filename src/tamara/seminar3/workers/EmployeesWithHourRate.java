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
    double getAverageSalary() {return 20.8 * 8 * this.rate;}

    // метод, возвращающий ID
    @Override
    public int getId() {return this.id;}

    // метод, возвращающий фамилию
    @Override
    public String getLastName(){return this.lastName;}

    // метод, возвращающий имя
    @Override
    public String getFirstName() {return this.firstName;}

}
