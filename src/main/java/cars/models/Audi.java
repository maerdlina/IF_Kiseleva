package cars.models;
import cars.Car;

public class Audi extends Car {
    private final boolean luxuryPackage;

    public Audi(int year, String transmission, String modelName, String number, String companyName, String fuelType, String color, boolean luxuryPackage) {
        super(year, transmission, modelName, number, companyName, fuelType, color);
        this.luxuryPackage = luxuryPackage;
    }

    public String getCarInfo() {
        return String.format("%s \nLuxury Package: %s.", super.getAllInfo(), luxuryPackage ? "Yes" : "No");
    }

    public boolean isLuxuryPackage() {
        return luxuryPackage;
    }
}