package cars.models;
import cars.Car;

public class Suzuki extends Car {
    private final int numberOfDoors;

    public Suzuki(int year, String transmission, String modelName, String number, String companyName, String fuelType, String color, int numberOfDoors) {
        super(year, transmission, modelName, number, companyName, fuelType, color);
        this.numberOfDoors = numberOfDoors;
    }

    public String getCarInfo() {
        return String.format("%s, Number of Doors: %d.", super.getAllInfo(), numberOfDoors);
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }
}