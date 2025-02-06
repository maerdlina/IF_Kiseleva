package cars.models;
import cars.Car;

public class Kia extends Car {
    private final boolean sunroof;

    public Kia(int year, String transmission, String modelName, String number, String companyName, String fuelType, String color, boolean sunroof) {
        super(year, transmission, modelName, number, companyName, fuelType, color);
        this.sunroof = sunroof;
    }

    public String getCarInfo() {
        return String.format("%s, Sunroof: %s.", super.getAllInfo(), sunroof ? "Yes" : "No");
    }

    public boolean hasSunroof() {
        return sunroof;
    }
}