package com.jts;

abstract class Car {
    private int year;
    private String transmission;
    private String modelName;
    private String number;
    private String companyName;
    private String fuelType;
    private String color;

    public Car(){}

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

    public String getAllInfo(){
        String info = "";
        if(year != 0) info += "\nYear: " + year;
        if(transmission != null) info += "\nTransmission: " + transmission;
        if(modelName != null) info += "\nModel name: " + modelName;
        if(number != null) info += "\nCar number: " + number;
        if(companyName != null) info += "\nCompany: " + companyName;
        if(fuelType != null) info += "\nFuel type: " + fuelType;
        if(color != null) info += "\nColor: " + color;

        return info;
    }
}
