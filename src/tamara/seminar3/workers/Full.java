package tamara.seminar3.workers;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Full {
    ArrayList<Employee> employees = new ArrayList<>();

    // создание работников для проверки методов, чтобы не создавать в конструкторе каждый раз
    public void createEmployees() {
        employees.add(new EmployeesWithHourRate(1, "Иванов", "Иван", 500));
        employees.add(new EmployeeWithFixedSalary(2, "Петров", "Петр", 50000));
        employees.add(new EmployeesWithHourRate(3, "Сидоров", "Андрей", 210));
        employees.add(new EmployeeWithFixedSalary(4, "Копылов", "Юрий", 50000));
        employees.add(new EmployeesWithHourRate(5, "Авросимова", "Ксения", 456));
        employees.add(new EmployeeWithFixedSalary(6, "Иванова", "Мария", 100000));
        employees.add(new EmployeesWithHourRate(7, "Корнев", "Даниил", 700));
        employees.add(new EmployeeWithFixedSalary(8, "Биляева", "Ольга", 48900));
        employees.add(new EmployeesWithHourRate(9, "Андропова", "Татьяна", 119));
        employees.add(new EmployeeWithFixedSalary(10, "Морозова", "Морозко", 200000));
    }

    public void getEmployees() {
        System.out.println();
        System.out.print("[");
        // проходим циклом по списку с работниками
        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i); // берется элемент из списка
            int id = emp.getId();
            String lastName = emp.getLastName();
            String firstName = emp.getFirstName();
            double salary = emp.getAverageSalary();
            System.out.println("[" + id + ", " + lastName + ", " + firstName + ", " + salary + "]; ");
            System.out.print("]");
        }
    }

    public void sortEmployeesListMinMax() {
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                if (emp1.getAverageSalary() > emp2.getAverageSalary()){
                    return 1; //возвращает положительное целое число, первый аргумент больше второго
                }else if (emp1.getAverageSalary() == emp2.getAverageSalary()){
                    return 0; //возвращает ноль, первый аргумент равен второму
                }else {
                    return -1; //возвращает отрицательное целое число, первый аргумент меньше второго
                }
            }
        });
    }

    public void sortEmployeesListMaxMin() {
        // сортировка по зарплате от максимума к минимуму, которая не меняет имена местами, если зарплаты равны
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                if (emp1.getAverageSalary() > emp2.getAverageSalary()) {
                    return -1;
                } else if (emp1.getAverageSalary() == emp2.getAverageSalary()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        // сортировка по списку с убыванием зарплат
        for (int i = 0; i < employees.size()-1; i++) {
            Employee emp1 = employees.get(i);
            Employee emp2 = employees.get(i+1);
            // поменяет местами работников в списке,
            // если их зарплаты равны и их фамилии стоят не в алфавитном порядке
            if (emp1.getAverageSalary() == emp2.getAverageSalary() &&
                    emp1.getLastName().compareTo(emp2.getLastName()) > 0) {
                Collections.swap(employees, i, i+1);
            }
        }
    }

    public void getFirst5employees(){
        for (int i = 0; i < 5; i++) {
            Employee emp = employees.get(i);
            String lastName = emp.getLastName();
            String firstName = emp.getFirstName();
            System.out.println((i+1) + " " + lastName + " " + firstName);
        }
    }

    public void getLast3employees() {
        for (int i = employees.size()-1; i > employees.size()-4; i--) {
            Employee emp = employees.get(i);
            String lastName = emp.getLastName();
            String firstName = emp.getFirstName();
            System.out.println((i+1) + " " + lastName + " " + firstName);
        }
    }

    // записывает в файл, каждый раз заново
    public void saveFile (String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (int i = 0; i < employees.size(); i++) {
                Employee emp = employees.get(i); // берется элемент из списка
                int id = emp.getId();
                String lastName = emp.getLastName();
                String firstName = emp.getFirstName();
                double salary = emp.getAverageSalary();
                writer.write("id: " + id + ", first name: " + firstName + ", last name: " + lastName +
                        ", salary: " + salary + "; \n");

            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // читает файл
    public void loadFile (String fileName){
        try (FileReader reader = new FileReader(fileName)){
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}