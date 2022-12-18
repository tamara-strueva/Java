package tamara.scheduler;

import tamara.scheduler.Task;
import tamara.scheduler.Scheduler;

import java.util.NoSuchElementException;

public class SchedulerTest {

    public static void main(String[] args) {
        Scheduler mySchedule = new Scheduler();

        mySchedule.createTask("1");
        mySchedule.createTask("2");
        mySchedule.createTask("3");

        mySchedule.listOfAllTasks();


        // Scheduler mySchedule = new Scheduler();


        // цикл, сначала настройки: формат даты
        // просят ввести действие (при запуске программы создается календарь)
        // цикл по действиям
    }
}

//Выберете действие или его номер:
//1 - создать задание - хотите сразу установить дату выполнения?
//2 - удалить задание
//3 - редактировать задание
//4 - посмотреть список всех заданий -- 1 абсолютно всех 2 по дате создания 3 по дате выполнения
//5 - посмотреть список выполненных заданий -- 1 абсолютно всех 2 по дате создания 3 по дате выполнения
//6 - посмотреть список невыполненных заданий -- 1 абсолютно всех 2 по дате создания 3 по дате выполнения
//7 - посмотреть список отложенных заданий***
//8 - посмотреть детальную информацию о задании -- выберете задание