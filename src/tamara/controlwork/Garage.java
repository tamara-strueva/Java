package tamara.controlwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// в программе игнорируются формы машин и гаража, берется площадь гаража и машин, пока в гараже полностью не закончится место
public class Garage {
    double width, length;
    int numberOfCars;
    ArrayList<Car> carsInGarage = new ArrayList<>(); // список всех машин в гараже

    public Garage(double width, double length, int numberOfCars){
        this.width = width;
        this.length = length;
        this.numberOfCars = numberOfCars;
    }

    // метод добавляет машину в гараж (список) и эта машина занимает там какое-то место
    public void addCar(Car car) {
        Class clas = car.getClass();
        double square = this.length * this.width;
        if (clas == BMWM3.class) {
            square -= ((BMWM3) car).getSize();
            carsInGarage.add(car);
        }else if (clas == BMWX5.class) {
            square -= ((BMWX5) car).getSize();
            carsInGarage.add(car);
        }else if (clas == Porche918Spyder.class) {
            square -= ((Porche918Spyder) car).getSize();
            carsInGarage.add(car);
        }
    }

    public void sortByPriceMaxMin() {
        carsInGarage.sort(new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                if (car1.getPrice() > car2.getPrice()) {
                    return -1;
                }else if (car1.getPrice() == car2.getPrice()) {
                    return 0;
                }else {
                    return 1;
                }
            }
        });

        for (int i = 0; i < carsInGarage.size(); i++) {
            System.out.println("Car's color: " + carsInGarage.get(i).getColor() +
                    ", Car's price: " + carsInGarage.get(i).getPrice() +
                    ", Car's max speed: " + carsInGarage.get(i).getMaxSpeed() +
                    ", Car's price: " + carsInGarage.get(i).getPrice());
        }
    }

    public void sortByPriceMinMax() {
        carsInGarage.sort(new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                if (car1.getPrice() > car2.getPrice()) {
                    return 1;
                }else if (car1.getPrice() == car2.getPrice()) {
                    return 0;
                }else {
                    return -1;
                }
            }
        });

        for (int i = 0; i < carsInGarage.size(); i++) {
            System.out.println("Car's color: " + carsInGarage.get(i).getColor() +
                    ", Car's price: " + carsInGarage.get(i).getPrice() +
                    ", Car's max speed: " + carsInGarage.get(i).getMaxSpeed() +
                    ", Car's price: " + carsInGarage.get(i).getPrice());
        }
    }


    public void sortByCountCarsInGarageMaxMin(){
        // создаем списки по моделям, чтобы потом сравнить их
        ArrayList<Car> bmwM3 = new ArrayList<>();
        ArrayList<Car> bmwX5 = new ArrayList<>();
        ArrayList<Car> porche = new ArrayList<>();

        // в цикле заполняем созданные ранее списки
        for (int i = 0; i < carsInGarage.size(); i++) {
            Class clas = carsInGarage.get(i).getClass();
            if (clas == BMWM3.class) {
                bmwM3.add(carsInGarage.get(i));
            }else if (clas == BMWX5.class) {
                bmwX5.add(carsInGarage.get(i));
            }else if (clas == Porche918Spyder.class) {
                porche.add(carsInGarage.get(i));
            }
        }

        // записываем в один список длины списков машин по моделям
        int countBMWm3 = bmwM3.size();
        int countBMWx5 = bmwX5.size();
        int countPorche = porche.size();

        int[] list = new int[] {countBMWm3, countBMWx5, countPorche};

        // после сортировки получим список из трех чисел, первое - наименьшее, последнее - наибольшее
        Arrays.sort(list);

        // просто выводим сначала те, которых наибольшее число, потом меньше и наименьшее
        if (bmwM3.size() == list[2]) {
            for (int i = 0; i < carsInGarage.size(); i++) {
                System.out.println("Car's color: " + carsInGarage.get(i).getColor() +
                        ", Car's price: " + carsInGarage.get(i).getPrice() +
                        ", Car's max speed: " + carsInGarage.get(i).getMaxSpeed() +
                        ", Car's price: " + carsInGarage.get(i).getPrice());
            }
        }else if (bmwX5.size() == list[2]) {
            for (int i = 0; i < carsInGarage.size(); i++) {
                System.out.println("Car's color: " + carsInGarage.get(i).getColor() +
                        ", Car's price: " + carsInGarage.get(i).getPrice() +
                        ", Car's max speed: " + carsInGarage.get(i).getMaxSpeed() +
                        ", Car's price: " + carsInGarage.get(i).getPrice());
            }
        }else if (porche.size() == list[2]) {
            for (int i = 0; i < carsInGarage.size(); i++) {
                System.out.println("Car's color: " + carsInGarage.get(i).getColor() +
                        ", Car's price: " + carsInGarage.get(i).getPrice() +
                        ", Car's max speed: " + carsInGarage.get(i).getMaxSpeed() +
                        ", Car's price: " + carsInGarage.get(i).getPrice());
            }
        }
        if (bmwM3.size() == list[1]) {
            for (int i = 0; i < carsInGarage.size(); i++) {
                System.out.println("Car's color: " + carsInGarage.get(i).getColor() +
                        ", Car's price: " + carsInGarage.get(i).getPrice() +
                        ", Car's max speed: " + carsInGarage.get(i).getMaxSpeed() +
                        ", Car's price: " + carsInGarage.get(i).getPrice());
            }
        }else if (bmwX5.size() == list[1]) {
            for (int i = 0; i < carsInGarage.size(); i++) {
                System.out.println("Car's color: " + carsInGarage.get(i).getColor() +
                        ", Car's price: " + carsInGarage.get(i).getPrice() +
                        ", Car's max speed: " + carsInGarage.get(i).getMaxSpeed() +
                        ", Car's price: " + carsInGarage.get(i).getPrice());
            }
        }else if (porche.size() == list[1]) {
            for (int i = 0; i < carsInGarage.size(); i++) {
                System.out.println("Car's color: " + carsInGarage.get(i).getColor() +
                        ", Car's price: " + carsInGarage.get(i).getPrice() +
                        ", Car's max speed: " + carsInGarage.get(i).getMaxSpeed() +
                        ", Car's price: " + carsInGarage.get(i).getPrice());
            }
        }
        if (bmwM3.size() == list[0]) {
            for (int i = 0; i < carsInGarage.size(); i++) {
                System.out.println("Car's color: " + carsInGarage.get(i).getColor() +
                        ", Car's price: " + carsInGarage.get(i).getPrice() +
                        ", Car's max speed: " + carsInGarage.get(i).getMaxSpeed() +
                        ", Car's price: " + carsInGarage.get(i).getPrice());
            }
        }else if (bmwX5.size() == list[0]) {
            for (int i = 0; i < carsInGarage.size(); i++) {
                System.out.println("Car's color: " + carsInGarage.get(i).getColor() +
                        ", Car's price: " + carsInGarage.get(i).getPrice() +
                        ", Car's max speed: " + carsInGarage.get(i).getMaxSpeed() +
                        ", Car's price: " + carsInGarage.get(i).getPrice());
            }
        }else if (porche.size() == list[0]) {
            for (int i = 0; i < carsInGarage.size(); i++) {
                System.out.println("Car's color: " + carsInGarage.get(i).getColor() +
                        ", Car's price: " + carsInGarage.get(i).getPrice() +
                        ", Car's max speed: " + carsInGarage.get(i).getMaxSpeed() +
                        ", Car's price: " + carsInGarage.get(i).getPrice());
            }
        }
    }
    // можно аналогично сделать сортировку от минимума к максимуму, но не успела
}
