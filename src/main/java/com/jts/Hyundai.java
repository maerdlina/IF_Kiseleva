package com.jts;

public class Hyundai extends Car {

    public Hyundai(int year, String transmission, String modelName, String number, String companyName, String fuelType, String color) {
        super(year, transmission, modelName, number, companyName, fuelType, color);
    }

    @Override
    public String getCarInfo() {
        return String.format("Hyundai %s", super.getAllInfo());
    }

    public int getWarrantyPeriod() {
        return 5; // Предполагаем, что гарантия на все автомобили Hyundai 5 лет
    }

    public int getCarAge() {
        return 2025 - super.getYear(); // Предполагаем, что текущий год 2025
    }
}
