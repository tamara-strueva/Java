package tamara.homework4;
import java.lang.*;
import java.util.Scanner;

public enum Seasons {
    //пречисление времен года и средней температуры
    WINTER(-17),
    SPRING(9),
    AUTUMN(6),
    SUMMER(20){
        // вывод, какое время года, потому что только лето теплое
        public void getDescription() {
            System.out.println("Теплое время года");
        }
    };
    double averageTemperature;
    final String favouriteSeason = "SUMMER";

    // список сезонов, чтобы вывести описание
    String[] seasons = new String[] {"WINTER", "SPRING", "SUMMER", "AUTUMN"};

    public static void main(String[] args) {
        // вывод информации о временах года
        for (Seasons season : Seasons.values()) {
            printAboutSeason(season);
        }

        // запрос ввести любимое время года, чтобы вывести о нем информацию
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите свое любимое время года: ");
        String favouriteSeason = scan.nextLine();

        for (Seasons season : Seasons.values()) {
            if(season.toString().compareTo(favouriteSeason) == 0) {
                printAboutSeason(season);
            }
        }
    }

    // конструктор, в котором указывается средняя температура сезона
    Seasons(double averageTemperature){
        this.averageTemperature = averageTemperature;
    }

    // вывод сообщения "я люблю..."
    public void iLove(Seasons season) {
        switch (season) {
            case WINTER -> System.out.println("Я люблю зиму!");
            case SPRING -> System.out.println("Я люблю весну!");
            case SUMMER -> System.out.println("Я люблю лето!");
            case AUTUMN -> System.out.println("Я люблю осень!");
        }
    }

    // вывод информации о времени года
    public static void printAboutSeason(Seasons season){
        System.out.println("Average temperature in " + season + ": " + season.getAverageTemperature() + "\u00B0C");
        season.getDescription();
    }

    // вывод описания времени года
    public void getDescription() {
        System.out.println("Холодное время года");
    }

    // метод, возвращающий среднюю температуру времени года
    public double getAverageTemperature (){
        return averageTemperature;
    }

    // метод, чтобы задать среднюю температуру
    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }
}
