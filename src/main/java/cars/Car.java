package cars;
import cars.models.*;

public abstract class Car {
    private final int year;
    private final String transmission;
    private final String modelName;
    private final String number;
    private final String companyName;
    private final String fuelType;
    private String color;

    public Car(int year, String transmission, String modelName, String number, String companyName, String fuelType, String color){
        this.year = year;
        this.transmission = transmission;
        this.modelName = modelName;
        this.number = number;
        this.companyName = companyName;
        this.fuelType = fuelType;
        this.color = color;
    }

    public abstract String getCarInfo();

    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public int getYear(){
        return this.year;
    }

    public String getNumber(){
        return number;
    }

    public String getCompanyName(){
        return companyName;
    }

    public String getFuelType(){
        return fuelType;
    }

    public static void printRecentCars(Car car) {
        if (car.getYear() > 2006) {
            System.out.println(car.getCarInfo() + "\n");
        } else {
            System.out.println("Устаревший авто:" + car.getCarInfo());
        }
    }

    public static void changeGreenToRed(Car car) {
        if (car.getColor().equalsIgnoreCase("Green")) {
            car.setColor("Red");
            System.out.println("Цвет автомобиля " + car.getCompanyName() + " " + car.getNumber() + " изменен на красный: " + car.getColor() + "\n");
        }
    }

    public static void printLuxuryCars(Car car) {
        if (car instanceof Audi && ((Audi) car).isLuxuryPackage()) {
            System.out.println("Люксовый автомобиль: " + car.getCompanyName() + " " + car.getNumber() + "\n");
        }
    }

    public static void printCarAges(Car car) {
        if (car instanceof Suzuki) {
            System.out.println("Кол-во дверей в автомобиле: " +  car.getCompanyName() + " " + car.getNumber() + " - " + ((Suzuki) car).getNumberOfDoors() + "\n");
        }
    }

    public static void printEcoFriendlyCars(Car car) {
        if (car instanceof Toyota && ((Toyota) car).isEcoFriendly()) {
            System.out.println("Экологически чистый автомобиль: " + car.getCompanyName() + " " + car.getNumber() + "\n");
        }
    }

    public static void printWarrantyPeriods(Car car) {
        if (car instanceof Hyundai) {
            System.out.println("Возраст машины: " + car.getCompanyName() + " " + car.getNumber() + " " + ((Hyundai) car).getCarAge() + " лет/года." + "\n");
        }
    }

    public static void printSunroofCars(Car car) {
        if (car instanceof Kia && ((Kia) car).hasSunroof()) {
            System.out.println("Машина с люком: " +  car.getCompanyName() + " " + car.getNumber() + "\n");
        }
    }

    public String getAllInfo(){
        return "\nCompany: " + companyName +
                "\nCar number: " + number +
                "\nYear: " + year +
                "\nTransmission: " + transmission +
                "\nModel name: " + modelName +
                "\nFuel type: " + fuelType +
                "\nColor: " + color;
    }
}