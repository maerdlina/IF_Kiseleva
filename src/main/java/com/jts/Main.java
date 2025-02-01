package com.jts;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //It's Main origin

    public static void printRecentCars(List<Car> carList) {
        System.out.println("Информация об автомобилях, выпущенных после 2006 года:");
        for (Car car : carList) {
            if (car.getYear() > 2006) {
                System.out.println(car.getCarInfo() + "\n");
            } else {
                System.out.println("Устаревший авто " + car.getCompanyName() + " " + car.getNumber() + "\n");
            }
        }
    }

    public static void changeGreenToRed(List<Car> carList) {
        for (Car car : carList) {
            if (car.getColor().equalsIgnoreCase("Green")) {
                car.setColor("Red");
                System.out.println("Цвет автомобиля " + car.getCompanyName() + " " + car.getNumber() + " изменен на красный: " + car.getColor());
            }
        }
    }

    public static void printLuxuryCars(List<Car> carList) {
        for (Car car : carList) {
            if (car instanceof Audi && ((Audi) car).isLuxuryPackage()) {
                System.out.println("Люксовый автомобиль: " + car.getCompanyName() + " " + car.getNumber());
            }
        }
    }

    public static void printCarAges(List<Car> carList) {
        for (Car car : carList) {
            if (car instanceof Suzuki) {
                System.out.println("Кол-во дверей в автомобиле: " +  car.getCompanyName() + " " + car.getNumber() + " - " + ((Suzuki) car).getNumberOfDoors());
            }
        }
    }

    // Метод для вывода экологически чистых автомобилей
    public static void printEcoFriendlyCars(List<Car> carList) {
        for (Car car : carList) {
            if (car instanceof Toyota && ((Toyota) car).isEcoFriendly()) {
                System.out.println("Экологически чистый автомобиль: " + car.getCompanyName() + " " + car.getNumber());
            }
        }
    }

    // Метод для вывода сроков гарантии
    public static void printWarrantyPeriods(List<Car> carList) {
        for (Car car : carList) {
            if (car instanceof Hyundai) {
                System.out.println("Срок гарантии Hyundai: " + ((Hyundai) car).getWarrantyPeriod() + " лет.");
            }
        }
    }

    // Метод для вывода автомобилей с люком
    public static void printSunroofCars(List<Car> carList) {
        for (Car car : carList) {
            if (car instanceof Kia && ((Kia) car).hasSunroof()) {
                System.out.println("Машина с люком: " +  car.getCompanyName() + " " + car.getNumber());
            }
        }
    }

    public static void main(String[] args){
//        Audi myAudi = new Audi();
//        myAudi.setColor("black");
//        System.out.println(myAudi.getCarInfo());
        List<Car> cars = new ArrayList<>();
        cars.add(new Audi(2021, "automatic", "A6", "ABC123", "Audi", "Petrol", "green", true));
        cars.add(new Audi(2020, "automatic", "Q5", "XYZ456", "Audi", "Diesel", "white", false));
        cars.add(new Audi(2019, "manual", "A4", "LMN789", "Audi", "Petrol", "red", true));
        cars.add(new Audi(2022, "automatic", "Q7", "DEF012", "Audi", "Petrol", "silver", true));
        cars.add(new Audi(2004, "manual", "A3", "GHI345", "Audi", "Diesel", "blue", false));
        cars.add(new Suzuki(2018, "automatic", "Swift", "JKL345", "Suzuki", "Petrol", "Blue", 5));
        cars.add(new Toyota(2020, "manual", "Camry", "MNO678", "Toyota", "Petrol", "green"));
        cars.add(new Hyundai(2019, "automatic", "Elantra", "PQR901", "Hyundai", "Diesel", "Gray"));
        cars.add(new Kia(2004, "automatic", "Sportage", "STU234", "Kia", "Petrol", "Silver", true));

        printRecentCars(cars);
        changeGreenToRed(cars);
        printLuxuryCars(cars);
        printCarAges(cars);
        printEcoFriendlyCars(cars);
        printWarrantyPeriods(cars);
        printSunroofCars(cars);
    }
}
