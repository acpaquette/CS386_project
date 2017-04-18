package com.example.chandler.hack;

/**
 * The purpose of this class is to build a Beer class that extends Drink
 * and implements the IDrink interface
 */

public class Beer extends Drink implements IDrink{
    // Scale of bitterness of beer
    private float ibu;

    public float getIBU() {
        return this.ibu;
    }

    public void setIBU(float ibu) {
        this.ibu = ibu;
    }


    public void update() {
    }

    public void edit() {
    }
}
