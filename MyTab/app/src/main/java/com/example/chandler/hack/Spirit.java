package com.example.chandler.hack;

/**
 * The purpose of this class is to build a Spirit class that takes the Drink
 * extend and the alcohol tuturial
 */

public class Spirit extends Drink implements IDrink{
    private int proof;

    public Spirit() {
	super();
	proof = 0;
    }

    public int getProof() {
        return this.proof;
    }

    public void setProof(int proof) {
        this.proof = proof;
    }

    @Override
    public void update() {

    }

    @Override
    public void edit() {

    }
}
