package tamara.scheduler;
import tamara.scheduler.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Scheduler {
    ArrayList<Integer> listOfNumbers = generateNumbers();
    ArrayList<Task> listOfTasks = new ArrayList<>();

    private static ArrayList<Integer> generateNumbers () {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add(i+1);
        }
        return numbers;
    }

    private static int setNumber(ArrayList<Integer> list) {
        return list.get(0);
    }

    private static ArrayList<Integer> delNumber(ArrayList<Integer> list) {
        list.remove(0);
        return list;
    }

    // Создать задание (в аргументе указывается название задачи)
    public Task createTask(String name) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите описание задачи");
        Task task = new Task(name, scan.nextLine()); // с консоли считывается описание, но можно оставить пустым
        task.setNumber(setNumber(listOfNumbers));
        delNumber(listOfNumbers);
        listOfTasks.add(task);
        return task;
    }

    // Удалить задание
    public void deleteTask() {}

    // Отредактировать задание (можно отредактировать название, описание, дату выполнения)
    public void editTask() {}

    // Просмотреть список ВСЕХ заданий
    public void listOfAllTasks() {
        System.out.println("\u001B[35mСписок всех задач: \u001B[0m");
        for (int i = 0; i < listOfTasks.size(); i++) {
            int number = listOfTasks.get(i).getNumber();
            String name = listOfTasks.get(i).getName();
            String description = listOfTasks.get(i).getDescription();
            String status = listOfTasks.get(i).getStatus();
            String dateCreated = listOfTasks.get(i).getDateOfCreation();
            System.out.println("Номер: " + number + "\nНазвание: " + name + "\nОписание: " + description +
                    "\nСтатус: " + status + "\nДата создания: " + dateCreated + "\n");
        }
    }

    // Просмотреть список ВСЕХ заданий по дате создания
    public void listOfAllTasksCreated(String dateCreated) {
        System.out.println("\u001B[35mСписок всех задач: \u001B[0m");
        for (int i = 0; i < listOfTasks.size(); i++) {
            String dateOfCreation = listOfTasks.get(i).getDateOfCreation();
            if (dateOfCreation.equalsIgnoreCase(dateCreated)) {
                int number = listOfTasks.get(i).getNumber();
                String name = listOfTasks.get(i).getName();
                String description = listOfTasks.get(i).getDescription();
                String status = listOfTasks.get(i).getStatus();
                System.out.println("Номер: " + number + "\nНазвание: " + name + "\nОписание: " + description +
                        "\nСтатус: " + status + "\nДата создания: " + dateCreated + "\n");
            }
        }
    }

    // Просмотреть список ВСЕХ заданий по дате выплнения
    public void listOfAllTasksToDo(String dateToDo) {
        if (listOfTasks.size() == 0) {
            System.out.println("Список пуст!");
        }else {
            System.out.println("\u001B[35mСписок всех задач: \u001B[0m");
            for (int i = 0; i < listOfTasks.size(); i++) {
                int number = listOfTasks.get(i).getNumber();
                String name = listOfTasks.get(i).getName();
                String description = listOfTasks.get(i).getDescription();
                String status = listOfTasks.get(i).getStatus();
                String dateCreated = listOfTasks.get(i).getDateOfCreation();
                System.out.println("Номер: " + number + "\nНазвание: " + name + "\nОписание: " + description +
                        "\nСтатус: " + status + "\nДата создания: " + dateCreated + "\n");
            }
        }

    }

    // Просмотреть список ВЫПОЛНЕННЫХ заданий по дате создания
    public void listOfCompletedTasksCreated(String dateCreated) {
        if (listOfTasks.size() == 0) {
            System.out.println("Список пуст!");
        }
    }

    // Посмотреть список ВЫПОЛНЕННЫХ заданий по дате выполнения
    public void listOfCompletedTasksToDo(String dateToDo) {
        if (listOfTasks.size() == 0) {
            System.out.println("Список пуст!");
        }
    }

    // Просмотреть список НЕВЫПОЛНЕННЫХ заданий (по дате создания и выплнения)
    public void listOfUnfulfilledTasksCreated(String dateCreated) {
        if (listOfTasks.size() == 0) {
            System.out.println("Список пуст!");
        }
    }

    // Просмотреть список НЕВЫПОЛНЕННЫХ заданий (по дате создания и выплнения)
    public void listOfUnfulfilledTasksToDo(String dateToDo) {
        if (listOfTasks.size() == 0) {
            System.out.println("Список пуст!");
        }
    }

    // Просмотреть детальную информацию о задании
    public String viewDetails(Task task) {
        String info = task.getDescription();
        // в строке 0 сиволов или значение null или нет символов после удаления пробелов в начале и в конце
        if (info == null || info.length() == 0 || info.trim().isEmpty())  {
            return "Нет описания";
        } // в остальных случааях вернется описание без пробелов в начале и в конце
        return info.trim();
    }




}
