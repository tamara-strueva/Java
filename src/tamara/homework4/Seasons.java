package tamara.homework4;
import java.util.*;
import java.lang.*;

public enum Seasons {
    WINTER(-17),
    SPRING(9),
    AUTUMN(6),
    SUMMER(20){
        public void getDescription() {
            System.out.println("Теплое время года");
        }
    };
    double averageTemperature;
//    final String favouriteSeason = "SUMMER";

    String[] seasons = new String[] {"WINTER", "SPRING", "SUMMER", "AUTUMN"};

    public static void main(String[] args) {
        for (Seasons season : Seasons.values()) {
            season.printAboutSeason(season);
        }
    }

    Seasons(double averageTemperature){
        this.averageTemperature = averageTemperature;
    }

    public void iLove(Seasons season) {
        switch (season) {
            case WINTER -> System.out.println("Я люблю зиму!");
            case SPRING -> System.out.println("Я люблю весну!");
            case SUMMER -> System.out.println("Я люблю лето!");
            case AUTUMN -> System.out.println("Я люблю осень!");
        }
    }

    public static void printAboutSeason(Seasons season){
        System.out.println("Average temperature in " + season + ": " + season.getAverageTemperature() + "\u00B0C");
        season.getDescription();
    }

    public void getDescription() {
        System.out.println("Холодное время года");
    }

    public double getAverageTemperature (){
        return averageTemperature;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }
}
