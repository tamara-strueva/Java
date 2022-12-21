package tamara.scheduler;

import java.text.ParseException;
import java.util.*;

public class SchedulerTest {

    public static void main(String[] args) throws ParseException {
        Scheduler mySchedule = new Scheduler(); // создание планнера для вызова его методов
        Scanner scanner = new Scanner(System.in);
        while (true)  { // цикл, предлагающий выбор действия с планнером
            System.out.println("\u001B[33mВыберете действие \u001B[0m" + // вывод предлагаемых действий
                    "\n  1 - СОЗДАТЬ задание" +
                    "\n  2 - УДАЛИТЬ задание" +
                    "\n  3 - РЕДАКТИРОВАТЬ задание" +
                    "\n  4 - посмотреть список ВСЕХ заданий" +
                    "\n  5 - посмотреть список ВЫПОЛНЕННЫХ заданий" +
                    "\n  6 - посмотреть список НЕВЫПОЛНЕННЫХ заданий" +
                    "\n  7 - посмотреть детальную ИНФОРМАЦИЮ о задании" +
                    "\n \u001B[36mВведите ЧИСЛО: \u001B[0m");
            int choice = 0; // объявление переменной
            try{
                choice = scanner.nextInt(); // просьба ввести свой выбор (цифрой)

            if (choice == 1) { // создать задание
                scanner.nextLine(); // техническая строка, чтобы после ввода числа ожидался ввод строки
                System.out.println("\u001B[36mВведите НАЗВАНИЕ новой задачи: \u001B[0m");
                String newName = scanner.nextLine(); // вызов метода
                mySchedule.createTask(newName);

            } else if (choice == 2) { // удалить задание
                scanner.nextLine(); // техническая строка, чтобы после ввода числа ожидался ввод строки
                System.out.println("Хотите посмотреть список Ваших задач? \u001B[36m[Д/Н]: \u001B[0m"); // предварительный просмотр для упрощения работы и выбора
                String answer = scanner.nextLine(); // ожидание ввода выбора
                if (answer.equalsIgnoreCase("д")) {
                    mySchedule.listOfAllTasks(); // вызов метода, который выводит все задачи
                } else if (!answer.equalsIgnoreCase("н")) {
                    System.out.println("\u001B[31mЧто-то пошло не так, попробуйте снова! \u001B[0m"); // сообщение о некорректном вводе
                }
                if (mySchedule.listOfTasks.size() != 0) {
                    System.out.println("\u001B[36mВведите НАЗВАНИЕ задачи, которую хотите удалить: \u001B[0m");
                    String taskName = scanner.nextLine(); // ожидание ввода имени задачи для вызова метода
                    mySchedule.deleteTaskByName(taskName); // вызов метода
                }


            } else if (choice == 3) { // редактировать задание (введите название)
                scanner.nextLine(); // техническая строка, чтобы после ввода числа ожидался ввод строки
                System.out.println("Хотите посмотреть список Ваших задач? \u001B[36m[Д/Н]: \u001B[0m"); // предварительный просмотр для упрощения работы и выбора
                String answer = scanner.nextLine(); // ожидание ввода выбора
                if (answer.equalsIgnoreCase("д")) {
                    mySchedule.listOfAllTasks(); // вызов метода, который выводит все задачи
                } else if (!answer.equalsIgnoreCase("н")) {
                    System.out.println("\u001B[31mЧто-то пошло не так, попробуйте снова! \u001B[0m"); // сообщение о некорректном вводе
                    continue;
                }
                if (mySchedule.listOfTasks.size() != 0) {
                    System.out.println("\u001B[36mВведите НАЗВАНИЕ задачи, которую хотите редактировать: \u001B[0m");
                    String taskName = scanner.nextLine(); // ожидание ввода
                    mySchedule.editTask(taskName); // вызов метода
                }


            } else if (choice == 4) { // посмотреть список всех задач (1 абсолютно 2 по дате создания 3 по дате выполнения)
                scanner.nextLine(); // техническая строка, чтобы после ввода числа ожидался ввод строки
                System.out.println("Вы хотите посмотреть " +
                        "\n  1 - список ВСЕХ задач, созданных ранее" +
                        "\n  2 - список задач ПО ДАТЕ СОЗДАНИЯ" +
                        "\n  3 - список задач ПО ДАТЕ ВЫПОЛНЕНИЯ" +
                        "\n \u001B[36mВведите ЧИСЛО: \u001B[0m");
                try {
                    int answer = scanner.nextInt();
                    if (answer == 1) {
                        mySchedule.listOfAllTasks();
                    } else if (answer == 2) {
                        scanner.nextLine(); // техническая строка, чтобы после ввода числа ожидался ввод строки
                        System.out.println("\u001B[36mВведите ДАТУ: \u001B[0m (формат дд/мм/гггг)");
                        String date = scanner.nextLine(); // ожидание ввода
                        mySchedule.listOfAllTasksCreated(date); // вызов метода
                    } else if (answer == 3) {
                        scanner.nextLine(); // техническая строка, чтобы после ввода числа ожидался ввод строки
                        System.out.println("\u001B[36mВведите ДАТУ: \u001B[0m (формат дд/мм/гггг)");
                        String date = scanner.nextLine(); // ожидание ввода
                        mySchedule.listOfAllTasksToDo(date); // вызов метода
                    }
                } catch (InputMismatchException exception) { // обработка исключения, если будет введена строка, а не число
                    System.out.println("\u001B[31mВведите число! \u001B[0m"); // сообщение о некорректном вводе
                }


            } else if (choice == 5) { // посмотреть список выполненных заданий (1 абсолютно 2 по дате создания 3 по дате выполнения)
                scanner.nextLine(); // техническая строка, чтобы после ввода числа ожидался ввод строки
                System.out.println("Вы хотите посмотреть " +
                        "\n  1 - список ВСЕХ задач, созданных ранее" +
                        "\n  2 - список задач ПО ДАТЕ СОЗДАНИЯ" +
                        "\n  3 - список задач ПО ДАТЕ ВЫПОЛНЕНИЯ" +
                        "\n \u001B[36mВведите число: \u001B[0m");
                try {
                    int answer = scanner.nextInt();
                    if (answer == 1) {
                        mySchedule.listOfAllCompletedTasks();
                    } else if (answer == 2) {
                        scanner.nextLine(); // техническая строка, чтобы после ввода числа ожидался ввод строки
                        System.out.println("\u001B[36mВведите ДАТУ: \u001B[0m (формат дд/мм/гггг)");
                        String date = scanner.nextLine();
                        mySchedule.listOfCompletedTasksCreated(date); // вызов метода
                    } else if (answer == 3) {
                        scanner.nextLine(); // техническая строка, чтобы после ввода числа ожидался ввод строки
                        System.out.println("\u001B[36mВведите ДАТУ: \u001B[0m (формат дд/мм/гггг)");
                        String date = scanner.nextLine();
                        mySchedule.listOfCompletedTasksToDo(date); // вызов метода
                    }
                } catch (InputMismatchException exception) { // обработка исключения, если будет введена строка, а не число
                    System.out.println("\u001B[31mВведите число! \u001B[0m"); // сообщение о некорректном вводе
                }


            } else if (choice == 6) { // посмотреть список невыполненных заданий (1 абсолютно 2 по дате создания 3 по дате выполнения)
                scanner.nextLine(); // техническая строка, чтобы после ввода числа ожидался ввод строки
                System.out.println("Вы хотите посмотреть " +
                        "\n  1 - список ВСЕХ задач, созданных ранее" +
                        "\n  2 - список задач ПО ДАТЕ СОЗДАНИЯ" +
                        "\n  3 - список задач ПО ДАТЕ ВЫПОЛНЕНИЯ" +
                        "\n \u001B[36mВведите число: \u001B[0m");
                try {
                    int answer = scanner.nextInt();
                    if (answer == 1) {
                        mySchedule.listOfAllUnfulfilledTasks();
                    } else if (answer == 2) {
                        scanner.nextLine(); // техническая строка, чтобы после ввода числа ожидался ввод строки
                        System.out.println("\u001B[36mВведите ДАТУ: \u001B[0m (формат дд/мм/гггг)");
                        String date = scanner.nextLine();
                        mySchedule.listOfUnfulfilledTasksCreated(date); // вызов метода
                    } else if (answer == 3) {
                        scanner.nextLine(); // техническая строка, чтобы после ввода числа ожидался ввод строки
                        System.out.println("\u001B[36mВведите ДАТУ: \u001B[0m (формат дд/мм/гггг)");
                        String date = scanner.nextLine();
                        mySchedule.listOfUnfulfilledTasksToDo(date); // вызов метода
                    }
                } catch (InputMismatchException exception) { // обработка исключения, если будет введена строка, а не число
                    System.out.println("\u001B[31mВведите число! \u001B[0m"); // сообщение о некорректном вводе
                }


            } else if (choice == 7) { // посмотреть детальную информацию о задании
                scanner.nextLine(); // техническая строка, чтобы после ввода числа ожидался ввод строки
                System.out.println("Хотите посмотреть список Ваших задач? \u001B[36m[Д/Н]: \u001B[0m"); // предварительный просмотр для упрощения работы и выбора
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("д")) {
                    mySchedule.listOfAllTasks(); // вызов метода, который выводит все задачи
                } else if (!answer.equalsIgnoreCase("н")) {
                    System.out.println("\u001B[31mЧто-то пошло не так, попробуйте снова! \u001B[0m"); // сообщение о некорректном вводе
                }
                if (mySchedule.listOfTasks.size() != 0) {
                    System.out.println("\u001B[36mВведите НАЗВАНИЕ задачи, описание которой холите посмотреть: \u001B[0m");
                    String taskName = scanner.nextLine();
                    mySchedule.getDetails(taskName); // вызов метода
                }

            } else {
                System.out.println("\u001B[31mЧто-то пошло не так, попробуйте снова! \u001B[0m"); // сообщение о некорректном вводе
            }

            }catch (InputMismatchException exception) { // обработка исключения, если будет введена строка, а не число
                System.out.println("\u001B[31mВведите число! \u001B[0m"); // сообщение о некорректном вводе
                scanner.nextLine();
            }
        }
    }
}
