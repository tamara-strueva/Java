package tamara.scheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Scheduler {
    ArrayList<Integer> listOfNumbers = generateNumbers();
    ArrayList<Task> listOfTasks = new ArrayList<>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

// 3 приватных статических метода для генерации уникальных номеровзаданий
    // генерация списка чисел
    private static ArrayList<Integer> generateNumbers () {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add(i+1);
        }
        return numbers;
    }
    // добавление первого элемента (добавит первый элемент из списка)
    private static int setNumber(ArrayList<Integer> list) {
        return list.get(0);
    }
    // удаление первого элемента
    private static ArrayList<Integer> delNumber(ArrayList<Integer> list) {
        list.remove(0);
        return list;
    }


    // Создать задание (в аргументе указывается название задачи)
    public void createTask(String name) throws ParseException {
        System.out.println("Хотите ли Вы добавить дату выполнения сейчас? \u001B[36m[Д/Н]: \u001B[0m"); // задавать ли дату выполнения сейчас или установить позже, отредактировав задачу
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine(); // ожидание ответа
        if (answer.equalsIgnoreCase("д") ) { // создание задание с датой выполнения
            while (true) { // цикл, который попросит заново ввести дату, если она уже прошла
                System.out.println("\u001B[36mВведите ДАТУ выполнения:\u001B[0m (формат дд/мм/гггг)");
                String date = scan.nextLine();
                try {
                    // проверка даты, чтобы нельхя было установить дату раньше сегодняшней
                    Date dateToCheck = dateFormat.parse(date); // фотматирование даты выполнения, установленной в задании
                    Calendar calendar = Calendar.getInstance(); // создание календаря
                    calendar.setTime(new Date()); // установка в календаре текущей даты
                    calendar.set(Calendar.HOUR_OF_DAY, -24); // вычет суток, чтобы сегодняшнюю дату можно было установить
                    Date todayNoTime = calendar.getTime(); // перевод текущей даты без суток в нужный тип данных для сравнения
                    if (dateToCheck.after(todayNoTime)) { // если дата сегодня и позже, то задание успешно создастся
                        System.out.println("\u001B[36mВведите ОПИСАНИЕ задачи: \u001B[0m (если хотите оставить пустым, нажмите ENTER)");
                        String desc = scan.nextLine();
                        Task task = new Task(name, desc, date); // с консоли считывается описание, но можно оставить пустым
                        task.setNumber(setNumber(listOfNumbers)); // изменение номера задания, которое по умолчанию 0
                        delNumber(listOfNumbers);
                        listOfTasks.add(task); // добавление нового задания в список заданий
                        System.out.println("\u001B[32mЗадача успешно создана! \u001B[0m \n"); // сообщение об успешном создании задания
                        break;
                    } else {
                        System.out.println("\u001B[31mДата не должна быть раньше сегодня! \u001B[0m \n"); // сообщение об ошибке при попытке задать прошедшую дату
                    }
                } catch (ParseException e) {
                    System.out.println("\u001B[31mНекорректный ввод даты! \u001B[0m \n"); // обработка исключения при ошибочном вводе даты
                }

            }

        } else if (answer.equalsIgnoreCase("н")) { // создание задания без даты выолнения (будет пустая строка)
            System.out.println("\u001B[36mВведите описание задачи \u001B[0m (если хотите оставить пустым, нажмите ENTER)");
            Task task = new Task(name, scan.nextLine(), ""); // с консоли считывается описание, но можно оставить пустым
            task.setNumber(setNumber(listOfNumbers)); // изменение номера задания, которое по умолчанию 0
            delNumber(listOfNumbers);
            listOfTasks.add(task); // добавление задание в список заданий
            System.out.println("\u001B[32mЗадача успешно создана! \u001B[0m \n");
        } else { // сообщение об ощибке при некорректном вводе
            System.out.println("\u001B[31mНекорректный ввод, попробуйте снова! \u001B[0m");
        }
    }

    // Удалить задание по его названию (может удалить несколько заданий, потому что имена могут быть одинаковыми)
    public ArrayList<Task> deleteTaskByName(String name) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Task> tasks = new ArrayList<>(); // вспомогательный список, если несклько задач с одинаковыми названиями
        for (int i = 0; i < listOfTasks.size(); i++) {
            if (listOfTasks.get(i).getName().equalsIgnoreCase(name)) {
                tasks.add(listOfTasks.get(i));
            }
        }

        Task task = null;
        if (tasks.size() == 0) { // если вспомогательный список пустой, то нет задач с таким именем
            System.out.println("\u001B[31mСовпадений не найдено \u001B[0m");
            return listOfTasks;
        } else if (tasks.size() == 1) { // если нашлось 1 совпадение, то его мы и искали в общем списке
            task = tasks.get(0);
        } else { // если же совпадений оказалось больше, то их выведут и предложат выбор
            System.out.println("\u001B[32mСписок совпадений: \u001B[0m"); // вывод списка совпадений (как и вывод всех задач)
            for (int i = 0; i < tasks.size(); i++) { // итерация по списку
                int number = tasks.get(i).getNumber(); // номер задания
                String taskName = tasks.get(i).getName(); // название задания
                String description = tasks.get(i).getDescription(); // описание
                String status = tasks.get(i).getStatus(); // статус
                if (status.equalsIgnoreCase("не выполнено")) { // если задание не выполнено, выведет красным
                    status = "\u001B[31mне выполнено\u001B[0m";
                } else if (status.equalsIgnoreCase("выполнено")) { // если задание выполнено, выведет зеленым
                    status = "\u001B[32mвыполнено\u001B[0m";
                }
                String dateCreated = tasks.get(i).getDateOfCreation(); // дата создания
                String dateDo = tasks.get(i).getDateToComplete(); // дата выполнения
                if (dateDo == null) { // если дата не установлена, так и выведет
                    dateDo = "Дата не установлена";
                }
                System.out.println("Номер: " + number + "\nНазвание: " + taskName + "\nОписание: " + description +
                        "\nСтатус: " + status + "\nДата создания: " + dateCreated + "\nДата выполнения: " +
                        dateDo + "\n");
            }

            try {
                System.out.println("\u001B[36mВведите номер задачи, которую хотите редактировать: \u001B[0m");
                int choice = scan.nextInt();
                boolean check = true;
                for (int item = 0; item < tasks.size(); item++) {
                    if (tasks.get(item).getNumber() == choice) {
                        task = tasks.get(item); // выбрано нужное задание
                        check = false;
                        break;
                    }
                }
                if (check) {
                    System.out.println("\u001B[31m ");
                }
            } catch (
                    InputMismatchException exception) { // если при выборе задания было введено не число, выведет сообщение об ошибке
                System.out.println("\u001B[31mВведите число! \u001B[0m");
            }
        }
        listOfTasks.remove(task);
        System.out.println("\u001B[32mЗадача успешно удалена! \u001B[0m \n");
        return listOfTasks;
    }

    // Отредактировать задание (можно отредактировать название, описание, дату выполнения)
    public void editTask(String name) throws ParseException { // сначало вопрос, что Вы хотите изменить
        Scanner scan = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>(); // вспомогательный список, если несклько задач с одинаковыми названиями (аналогично с удалением)
        for (int i = 0; i < listOfTasks.size(); i++) {
            if (listOfTasks.get(i).getName().equalsIgnoreCase(name)) {
                tasks.add(listOfTasks.get(i));
            }
        }

        Task task = null;
        if (tasks.size() == 0) { // если вспомогательный список пустой, то нет задач с таким именем
            System.out.println("\u001B[31mСовпадений не найдено \u001B[0m");
            return;
        } else if (tasks.size() == 1) { // если нашлось 1 совпадение, то его мы и искали в общем списке
            task = tasks.get(0);
        } else { // если же совпадений оказалось больше, то их выведут и предложат выбор
            System.out.println("\u001B[32mСписок совпадений: \u001B[0m");
            for (int i = 0; i < tasks.size(); i++) {
                int number = tasks.get(i).getNumber();
                String taskName = tasks.get(i).getName();
                String description = tasks.get(i).getDescription();
                String status = tasks.get(i).getStatus();
                if (status.equalsIgnoreCase("не выполнено")) {
                    status = "\u001B[31mне выполнено\u001B[0m";
                } else if (status.equalsIgnoreCase("выполнено")) {
                    status = "\u001B[32mвыполнено\u001B[0m";
                }
                String dateCreated = tasks.get(i).getDateOfCreation();
                String dateDo = tasks.get(i).getDateToComplete();
                if (dateDo == null) {
                    dateDo = "Дата не установлена";
                }
                System.out.println("Номер: " + number + "\nНазвание: " + taskName + "\nОписание: " + description +
                        "\nСтатус: " + status + "\nДата создания: " + dateCreated + "\nДата выполнения: " +
                        dateDo + "\n");
            }

            try {
                System.out.println("\u001B[36mВведите номер задачи, которую хотите редактировать: \u001B[0m");
                int choice = scan.nextInt();
                boolean check = true;
                for (int item = 0; item < tasks.size(); item++) {
                    if (tasks.get(item).getNumber() == choice) {
                        task = tasks.get(item); // выбрано нужное задание
                        check = false;
                        break;
                    }
                }
                if (check) {
                    System.out.println("\u001B[31m ");
                }
            } catch (InputMismatchException exception) { // если при выборе задания было введено не число, выведет сообщение об ошибке
                System.out.println("\u001B[31mВведите число! \u001B[0m");
            }
        }
        System.out.println("Что Вы хотите изменить? \n 1 - описание \n 2 - название \n 3 - статус " +
                "\n 4 - дату выполнения \n\u001B[36mВведите цифру: \u001B[0m");

        try { // ввод выбора и обработка исключения при некорректном вводе
            int option = scan.nextInt();

            if (option == 1) { // редактировать описание
                scan.nextLine();
                String desc = task.getDescription();
                System.out.println("Нынешнее описание: " + desc); // вывод описания для сравнения
                System.out.println("\u001B[36mВведите новое описание задачи: \u001B[0m");
                String newDescription = scan.nextLine();
                task.setDescription(newDescription); // установка нового описания (полностью меняет прошлое)
                System.out.println("\u001B[32mОписание успешно изменено! \u001B[0m \n");

            } else if (option == 2) { // редактировать название
                scan.nextLine();
                System.out.println("\u001B[36mВведите новое название задачи: \u001B[0m");
                String newName = scan.nextLine();
                task.setName(newName); // установка нового названия
                System.out.println("\u001B[32mНазвание задачи успешно изменено! \u001B[0m \n");

            } else if (option == 3) { // редактировать статус
                scan.nextLine();
                String nowStatus = task.getStatus();
                String s = null;
                if (nowStatus.equalsIgnoreCase("не выполнено")) {
                    s = "\u001B[31mне выполнено\u001B[0m";
                } else if (nowStatus.equalsIgnoreCase("выполнено")) {
                    s = "\u001B[32mвыполнено\u001B[0m";
                }
                System.out.println("Нынешний статус: " + s); // вывод установленного статуса
                System.out.println("Хотите его изметить? \n1 - да \n2 - нет \n \u001B[36mВведите число: \u001B[0m");
                int choice = scan.nextInt(); // хотите ли поменять статус?
                if (choice == 1) { // если хотите поменять статус - установится второе
                    if (nowStatus.equalsIgnoreCase("не выполнено")) {
                        String newStatus = "выполнено";
                        task.setStatus(newStatus);
                        System.out.println("\u001B[32mСтатус успешно изменен! \u001B[0m \n");
                    } else if (nowStatus.equalsIgnoreCase("выполнено")) {
                        String newStatus = "не выполнено";
                        task.setStatus(newStatus);
                        System.out.println("\u001B[32mСтатус успешно изменен! \u001B[0m \n");
                    }
                } else { // если ввод некоорректный, выведет сообщение
                    System.out.println("\u001B[31mНекорректный ввод, повторите снова! \u001B[0m");
                }

            } else if (option == 4) { // редактировать дату выполнения
                scan.nextLine();
                String date = task.getDateToComplete();
                Date now = new Date();
                System.out.println("Запланированная дата: " + date); // вывод заплпнированной даты
                System.out.println("Хотите ее изметить? \n1 - да \n2 - нет \n \u001B[36mВведите число: \u001B[0m");
                try {
                    int choice = scan.nextInt();
                    if (choice == 1) { // если хотите изменить
                        scan.nextLine();
                        System.out.println("\u001B[36mВведите новую дату\u001B[0m (формат дд/мм/гггг):");
                        String newDate = scan.nextLine(); // ввод новой даты

                        Date dateToCheck = dateFormat.parse(newDate); // проверка, чтобы дата была в будущем
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(now);
                        calendar.set(Calendar.HOUR_OF_DAY, -24);
                        Date todayNoTime = calendar.getTime();

                        if (dateToCheck.after(todayNoTime)) { // если корректная дата, то она поменяется
                            task.setDateToComplete(newDate);
                        } else { // в ином случае выведет сообщение об ошибке
                            System.out.println("\u001B[31mДата не должна быть раньше сегодня! \u001B[0m");
                        }

                    } else if (!(choice == 2)) { // при некорректном вводе (хотите ли вы изменить дату) сообщение об ошибке
                        System.out.println("\u001B[31mНекорректный ввод, повторите снова! \u001B[0m");
                    }
                } catch (InputMismatchException exception) { // обработка исключения
                    System.out.println("\u001B[31mВведите число! \u001B[0m");
                }
            } else {
                System.out.println("\u001B[31mЧто-то пошло не так, попробуйте снова! \u001B[0m");
            }
        } catch (InputMismatchException exception) { // обработка исключения
            System.out.println("\u001B[31mВведите число! \u001B[0m");
        }
    }

// вывод списка заданий (всех или по дате) аналогичен выводу в методе удаления задания при совпадениях

    // Просмотреть список ВСЕХ заданий
    public void listOfAllTasks() {
        if (listOfTasks.size() == 0) { // нечего выводить, если список пуст
            System.out.println("\u001B[31mСписок пуст! \u001B[0m");
        } else {
            System.out.println("\u001B[35mСписок всех задач: \u001B[0m");
            for (int i = 0; i < listOfTasks.size(); i++) {
                int number = listOfTasks.get(i).getNumber();
                String name = listOfTasks.get(i).getName();
                String description = listOfTasks.get(i).getDescription();
                String status = listOfTasks.get(i).getStatus();
                if (status.equalsIgnoreCase("не выполнено")) {
                    status = "\u001B[31mне выполнено\u001B[0m";
                } else if (status.equalsIgnoreCase("выполнено")) {
                    status = "\u001B[32mвыполнено\u001B[0m";
                }
                String dateCreated = listOfTasks.get(i).getDateOfCreation();
                String dateDo = listOfTasks.get(i).getDateToComplete();
                if (dateDo == null) {
                    dateDo = "Дата не установлена";
                }
                System.out.println("Номер: " + number + "\nНазвание: " + name + "\nОписание: " + description +
                        "\nСтатус: " + status + "\nДата создания: " + dateCreated + "\nДата выполнения: " +
                        dateDo + "\n");
            }
        }
    }

    // Просмотреть список ВСЕХ заданий по дате создания
    public void listOfAllTasksCreated(String dateCreated) {
        if (listOfTasks.size() == 0) {
            System.out.println("\u001B[31mСписок пуст! \u001B[0m");
        }else {
            System.out.println("\u001B[35mСписок всех задач по дате создания: \u001B[0m");
            for (int i = 0; i < listOfTasks.size(); i++) {
                String dateOfCreation = listOfTasks.get(i).getDateOfCreation();
                if (dateOfCreation.equalsIgnoreCase(dateCreated)) { // проверка на совпадение даты создания и введенной
                    int number = listOfTasks.get(i).getNumber();
                    String name = listOfTasks.get(i).getName();
                    String description = listOfTasks.get(i).getDescription();
                    String status = listOfTasks.get(i).getStatus();
                    if (status.equalsIgnoreCase("не выполнено")) {
                        status = "\u001B[31mне выполнено\u001B[0m";
                    } else if (status.equalsIgnoreCase("выполнено")) {
                        status = "\u001B[32mвыполнено\u001B[0m";
                    }
                    System.out.println("Номер: " + number + "\nНазвание: " + name + "\nОписание: " + description +
                            "\nСтатус: " + status + "\nДата создания: " + dateCreated + "\n");
                }
            }
        }
    }

    // Просмотреть список ВСЕХ заданий по дате выплнения
    public void listOfAllTasksToDo(String dateToDo) {
        if (listOfTasks.size() == 0) {
            System.out.println("\u001B[31mСписок пуст! \u001B[0m");
        }else {
            System.out.println("\u001B[35mСписок всех задач по дате выполнения: \u001B[0m");
            for (int i = 0; i < listOfTasks.size(); i++) {
                String dateDo = listOfTasks.get(i).getDateToComplete();
                if (dateDo.equals(dateToDo)) { // проверка на совпадение даты выполнения и введенной
                    int number = listOfTasks.get(i).getNumber();
                    String name = listOfTasks.get(i).getName();
                    String description = listOfTasks.get(i).getDescription();
                    String status = listOfTasks.get(i).getStatus();
                    if (status.equalsIgnoreCase("не выполнено")) {
                        status = "\u001B[31mне выполнено\u001B[0m";
                    } else if (status.equalsIgnoreCase("выполнено")) {
                        status = "\u001B[32mвыполнено\u001B[0m";
                    }
                    String dateCreated = listOfTasks.get(i).getDateOfCreation();
                    System.out.println("Номер: " + number + "\nНазвание: " + name + "\nОписание: " + description +
                            "\nСтатус: " + status + "\nДата создания: " + dateCreated + "\nДата выполнения: " +
                            dateDo + "\n");
                }
            }
        }
    }

    // Посмотреть список всех ВЫПОЛНЕННЫХ заданий
    public void listOfAllCompletedTasks() {
        if (listOfTasks.size() == 0) {
            System.out.println("\u001B[31mСписок пуст! \u001B[31m");
        } else {
            System.out.println("\u001B[35mСписок всех выполненных задач: \u001B[0m");
            for (int i = 0; i < listOfTasks.size(); i++) {
                String status = listOfTasks.get(i).getStatus();
                if (status.equalsIgnoreCase("выполнено")) { // задание должно быть выполнено
                    status = "\u001B[32mвыполнено\u001B[0m";
                    int number = listOfTasks.get(i).getNumber();
                    String name = listOfTasks.get(i).getName();
                    String description = listOfTasks.get(i).getDescription();
                    String dateCreated = listOfTasks.get(i).getDateOfCreation();
                    String dateDo = listOfTasks.get(i).getDateToComplete();
                    if (dateDo == null) {
                        dateDo = "Дата не установлена";
                    }
                    System.out.println("Номер: " + number + "\nНазвание: " + name + "\nОписание: " + description +
                            "\nСтатус: " + status + "\nДата создания: " + dateCreated + "\nДата выполнения: " +
                            dateDo + "\n");
                }
            }
        }
    }

    // Просмотреть список ВЫПОЛНЕННЫХ заданий по дате создания
    public void listOfCompletedTasksCreated(String dateCreated) {
        if (listOfTasks.size() == 0) {
            System.out.println("\u001B[31mСписок пуст! \u001B[0m");
        }else {
            System.out.println("\u001B[35mСписок выполненных задач по дате создания: \u001B[0m");
            for (int i = 0; i < listOfTasks.size(); i++) {
                String dateOfCreation = listOfTasks.get(i).getDateOfCreation();
                String status = listOfTasks.get(i).getStatus();
                if (dateOfCreation.equalsIgnoreCase(dateCreated) && status.equalsIgnoreCase("выполнено")) { // проверка на совпадение даты создания и введенной, но и статус должен быть выполнено
                    status = "\u001B[32mвыполнено\u001B[0m";
                    int number = listOfTasks.get(i).getNumber();
                    String name = listOfTasks.get(i).getName();
                    String description = listOfTasks.get(i).getDescription();
                    System.out.println("Номер: " + number + "\nНазвание: " + name + "\nОписание: " + description +
                            "\nСтатус: " + status + "\nДата создания: " + dateCreated + "\n");
                }
            }
        }
    }

    // Посмотреть список ВЫПОЛНЕННЫХ заданий по дате выполнения
    public void listOfCompletedTasksToDo(String dateToDo) {
        if (listOfTasks.size() == 0) {
            System.out.println("\u001B[31mСписок пуст! \u001B[0m");
        }else {
            System.out.println("\u001B[35mСписок выполненных задач по дате выполнения: \u001B[0m");
            for (int i = 0; i < listOfTasks.size(); i++) {
                String dateDo = listOfTasks.get(i).getDateToComplete();
                String status = listOfTasks.get(i).getStatus();
                if (dateDo.equals(dateToDo) && status.equalsIgnoreCase("выполнено")) { // проверка на совпадение даты создания и введенной, но и статус должен быть выполнено
                    status = "\u001B[32mвыполнено\u001B[0m";
                    int number = listOfTasks.get(i).getNumber();
                    String name = listOfTasks.get(i).getName();
                    String description = listOfTasks.get(i).getDescription();
                    String dateCreated = listOfTasks.get(i).getDateOfCreation();
                    System.out.println("Номер: " + number + "\nНазвание: " + name + "\nОписание: " + description +
                            "\nСтатус: " + status + "\nДата создания: " + dateCreated + "\nДата выполнения: " +
                            dateDo + "\n");
                }
            }
        }
    }

    // Посмотреть список всех НЕВЫПОЛНЕННЫХ задач
    public  void listOfAllUnfulfilledTasks() {
        if (listOfTasks.size() == 0) {
            System.out.println("Список пуст!");
        } else {
            System.out.println("\u001B[35mСписок всех задач: \u001B[0m");
            for (int i = 0; i < listOfTasks.size(); i++) {
                String status = listOfTasks.get(i).getStatus();
                if (status.equalsIgnoreCase("не выполнено")) { // статус должен быть не выполнено
                    status = "\u001B[31mне выполнено\u001B[0m";
                    int number = listOfTasks.get(i).getNumber();
                    String name = listOfTasks.get(i).getName();
                    String description = listOfTasks.get(i).getDescription();
                    String dateCreated = listOfTasks.get(i).getDateOfCreation();
                    String dateDo = listOfTasks.get(i).getDateToComplete();
                    if (dateDo == null) {
                        dateDo = "Дата не установлена";
                    }
                    System.out.println("Номер: " + number + "\nНазвание: " + name + "\nОписание: " + description +
                            "\nСтатус: " + status + "\nДата создания: " + dateCreated + "\nДата выполнения: " +
                            dateDo + "\n");
                }
            }
        }
    }

    // Просмотреть список НЕВЫПОЛНЕННЫХ заданий (по дате создания и выплнения)
    public void listOfUnfulfilledTasksCreated(String dateCreated) {
        if (listOfTasks.size() == 0) {
            System.out.println("\u001B[31mСписок пуст! \u001B[0m");
        }else {
            System.out.println("\u001B[35mСписок не выполненных задач по дате создания: \u001B[0m");
            for (int i = 0; i < listOfTasks.size(); i++) {
                String dateOfCreation = listOfTasks.get(i).getDateOfCreation();
                String status = listOfTasks.get(i).getStatus();
                if (dateOfCreation.equalsIgnoreCase(dateCreated) && status.equalsIgnoreCase("не выполнено")) { // проверка на совпадение даты создания и введенной, но и статус должен быть не выполнено
                    status = "\u001B[31mне выполнено\u001B[0m";
                    int number = listOfTasks.get(i).getNumber();
                    String name = listOfTasks.get(i).getName();
                    String description = listOfTasks.get(i).getDescription();
                    System.out.println("Номер: " + number + "\nНазвание: " + name + "\nОписание: " + description +
                            "\nСтатус: " + status + "\nДата создания: " + dateCreated + "\n");
                }
            }
        }
    }

    // Просмотреть список НЕВЫПОЛНЕННЫХ заданий (по дате создания и выплнения)
    public void listOfUnfulfilledTasksToDo(String dateToDo) {
        if (listOfTasks.size() == 0) {
            System.out.println("\u001B[31mСписок пуст! \u001B[0m");
        }else {
            System.out.println("\u001B[35mСписок невыполненных задач по дате выполнения: \u001B[0m");
            for (int i = 0; i < listOfTasks.size(); i++) {
                String dateDo = listOfTasks.get(i).getDateToComplete();
                String status = listOfTasks.get(i).getStatus();
                if (dateDo.equals(dateToDo) && status.equalsIgnoreCase("не выполнено")) { // проверка на совпадение даты выполнения и введенной, но и статус должен быть не выполнено
                    status = "\u001B[31mне выполнено\u001B[0m";
                    int number = listOfTasks.get(i).getNumber();
                    String name = listOfTasks.get(i).getName();
                    String description = listOfTasks.get(i).getDescription();
                    String dateCreated = listOfTasks.get(i).getDateOfCreation();
                    System.out.println("Номер: " + number + "\nНазвание: " + name + "\nОписание: " + description +
                            "\nСтатус: " + status + "\nДата создания: " + dateCreated + "\nДата выполнения: " +
                            dateDo + "\n");
                }
            }
        }
    }

    // Просмотреть детальную информацию о задании
    public void getDetails(String name) {
        if (listOfTasks.size() == 0) {
            System.out.println("\u001B[31mСписок задач пуст! \u001B[0m");
        } else {
            ArrayList<Task> tasks = new ArrayList<>();
            boolean check = true;
            for (int i = 0; i < listOfTasks.size(); i++) {
                if (listOfTasks.get(i).getName().equalsIgnoreCase(name)) {
                    tasks.add(listOfTasks.get(i));
                    check = false;
                }
            }
            if (check) {
                System.out.println("\u001B[31mСовпадений не найдено! \u001B[0m \n");
            } else {
                for (int i = 0; i < tasks.size(); i++) {
                    String info = tasks.get(i).getDescription();
                    // в строке 0 сиволов или значение null или нет символов после удаления пробелов в начале и в конце
                    if (info == null || info.length() == 0 || info.trim().isEmpty())  {
                        System.out.println("Название задачи - " + tasks.get(i).getName() + ": " + " Нет описания\n");
                    } // в остальных случааях вернется описание без пробелов в начале и в конце
                    System.out.println("Название задачи - " + tasks.get(i).getName() + ": " + info.trim() + "\n");
                }
            }
        }
    }

}
