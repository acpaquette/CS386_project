package com.example.chandler.hack;

/**
 * The purpose of this class is to build a Beer class that extends Drink
 * and implements the IDrink interface
 */

public class Beer extends Drink implements IDrink {
    // Scale of bitterness of beer
    private double ibu;

    public Beer() {
	super();
	ibu = 0.0;
    }

    public double getIBU() {
        return this.ibu;
    }

    public void setIBU(double ibu) {
        this.ibu = ibu;
    }


    public void update() {
    }

    public void edit() {
    }
}
