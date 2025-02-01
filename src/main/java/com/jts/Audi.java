package com.jts;

public class Audi extends Car{
    private boolean luxuryPackage;

    public Audi(){}

    public Audi(int year, String transmission, String modelName, String number, String companyName, String fuelType, String color, boolean luxuryPackage) {
        super(year, transmission, modelName, number, companyName, fuelType, color);
        this.luxuryPackage = luxuryPackage;
    }

    public void setLuxuryPackage(boolean luxuryPackage){
        this.luxuryPackage = luxuryPackage;
    }

    @Override
    public String getCarInfo() {
        return String.format("Audi %s \nLuxury Package: %s.", super.getAllInfo(), luxuryPackage ? "Yes" : "No");
    }

    public boolean isLuxuryPackage() {
        return luxuryPackage;
    }
}
