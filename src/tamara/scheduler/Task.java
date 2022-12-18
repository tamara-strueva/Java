package tamara.scheduler;

import java.text.*;
import java.util.*;

public class Task {
    int number;
    String status, name, description, dateOfCreation, DateToComplete;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    Task (String name, String description) {
        this.number = 0;
        this.status = "невыполнено";
        this.name = name;
        this.description = description;
        this.dateOfCreation = dateFormat.format(new Date());
    }

    Task (String name, String description, String dateToComplete) {
        this.number = 0;
        this.status = "невыполнено";
        this.name = name;
        this.description = description;
        this.dateOfCreation = dateFormat.format(new Date());
        this.DateToComplete = dateToComplete;
    }

    public int getNumber() {return this.number;}

    public String getStatus() {return this.status;}

    public String getName() {return this.name;}

    public String getDescription() {return this.description;}

    public String getDateOfCreation() {return this.dateOfCreation;}

    public void setNumber(int number) {this.number = number;}

    public void setStatus(String status) {
        if (status.equalsIgnoreCase("выполнено")) {
            this.status = status;
        } else if (status.equalsIgnoreCase("отменено")) {
            this.status = status;
        }
        System.out.println("Невозможно");
    }
}

