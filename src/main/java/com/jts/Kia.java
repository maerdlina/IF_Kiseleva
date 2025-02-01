package com.jts;

public class Kia extends Car {
    private boolean sunroof;

    public Kia(int year, String transmission, String modelName, String number, String companyName, String fuelType, String color, boolean sunroof) {
        super(year, transmission, modelName, number, companyName, fuelType, color);
        this.sunroof = sunroof;
    }

    @Override
    public String getCarInfo() {
        return String.format("Kia %s, Sunroof: %s.", super.getAllInfo(), sunroof ? "Yes" : "No");
    }

    public boolean hasSunroof() {
        return sunroof;
    }
}
