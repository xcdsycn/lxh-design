package com.lxh.function.notemplet;

/**
 * @author lxh
 */
public class Automobile {
    private String make;
    private String model;
    private short year;


    public Automobile(String make, String model, short year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    protected void what() {
        System.out.println("This automobile is a " + year + " " + make + " " + model + ".");
    }
}
