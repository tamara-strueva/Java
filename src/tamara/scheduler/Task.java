package tamara.scheduler;

import java.text.*;
import java.util.*;

public class Task {
    int number;
    String status, name, description, dateOfCreation, DateToComplete;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    // конструктор класса
    Task (String name, String description, String dateToComplete) {
        this.number = 0; // номер по умолчанию 0, при создании в планнере будет меняться
        this.status = "не выполнено"; // по умолчанию при создании статус не выполнено, но его можно поменять в основной программе
        this.name = name;
        this.description = description; // дополнительная информация к задаче
        this.dateOfCreation = dateFormat.format(new Date()); // дата создания ставится по умолчанию (сегодняшняя)
        this.DateToComplete = dateToComplete;
    }

    // стандартные геттеры и сеттеры

    public int getNumber() {return this.number;}

    public String getStatus() {return this.status;}

    public String getName() {return this.name;}

    public String getDescription() {return this.description;}

    public String getDateOfCreation() {return this.dateOfCreation;}

    public String getDateToComplete() {return this.DateToComplete;}

    public void setNumber(int newNumber) {this.number = newNumber;}

    public void setDescription(String newDescription) {this.description = newDescription;}

    public void setName(String newName) {this.name = newName;}

    public void setDateToComplete(String dateToComplete) {this.DateToComplete = dateToComplete;}

    public void setStatus(String status) { // всего 2 возможных статуса
        if (status.equalsIgnoreCase("выполнено")) {
            this.status = status;
        } else if (status.equalsIgnoreCase("не выполнено")) {
            this.status = status;
        }else {
            System.out.println("\u001B[31mНевозможно установить такой статус \u001B[0m");
        }
    }

}

