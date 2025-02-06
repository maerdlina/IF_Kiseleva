import cars.Car;
import cars.models.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Car> cars = new ArrayList<>();
        cars.add(new Audi(2021, "automatic", "A6", "ABC123", "Audi", "Petrol", "green", true));
        cars.add(new Audi(2020, "automatic", "Q5", "XYZ456", "Audi", "Diesel", "white", false));
        cars.add(new Hyundai(2001, "automatic", "Elantra", "AOR101", "Hyundai", "Petrol", "Green"));
        cars.add(new Audi(2022, "automatic", "Q7", "DEF012", "Audi", "Petrol", "silver", true));
        cars.add(new Audi(2004, "manual", "A3", "GHI345", "Audi", "Diesel", "blue", false));
        cars.add(new Suzuki(2018, "automatic", "Swift", "JKL345", "Suzuki", "Petrol", "Blue", 5));
        cars.add(new Toyota(2020, "manual", "Camry", "MNO678", "Toyota", "Petrol", "green"));
        cars.add(new Hyundai(2019, "automatic", "Elantra", "PQR901", "Hyundai", "Diesel", "Gray"));
        cars.add(new Kia(2004, "automatic", "Sportage", "STU234", "Kia", "Petrol", "Silver", true));

        for(Car car: cars){
            Car.printRecentCars(car);
            Car.changeGreenToRed(car);
            Car.printLuxuryCars(car);
            Car.printCarAges(car);
            Car.printEcoFriendlyCars(car);
            Car.printWarrantyPeriods(car);
            Car.printSunroofCars(car);
        }
    }
}