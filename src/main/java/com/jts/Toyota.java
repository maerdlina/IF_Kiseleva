package com.jts;

public class Toyota extends Car {

    public Toyota(int year, String transmission, String modelName, String number, String companyName, String fuelType, String color) {
        super(year, transmission, modelName, number, companyName, fuelType, color);
    }

    @Override
    public String getCarInfo() {
        return String.format("Toyota %s", super.getAllInfo());
    }


    public boolean isEcoFriendly() {
        return "Petrol".equalsIgnoreCase(super.getFuelType());
    }
}
