package cars.models;
import cars.Car;

public class Hyundai extends Car {

    public Hyundai(int year, String transmission, String modelName, String number, String companyName, String fuelType, String color) {
        super(year, transmission, modelName, number, companyName, fuelType, color);
    }

    public String getCarInfo() {
        return String.format("%s", super.getAllInfo());
    }

    public int getCarAge() {
        return 2025 - super.getYear();
    }
}