package com.lxh.function.templet;

/**
 * @author lxh
 */
public class Automobile<X, Y, Z> {
    private X make;
    private Y model;
    private Z year;

    public Automobile(X make, Y model, Z year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    protected void what() {
        System.out.println("This automobile is a " + year + " " + make + " " + model + ".");
    }

}
