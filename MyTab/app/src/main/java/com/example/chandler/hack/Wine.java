package com.example.chandler.hack;

/**
 * Created by adampaquette on 4/13/17.
 */

public class Wine extends Drink implements IDrink{

    private String flavorNote, type;

    public String getFlavorNote() {
        return this.flavorNote;
    }

    public void setFlavorNote(String flavorNote) {
        this.flavorNote = flavorNote;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public void update() {
    }

    public void edit() {
    }
}
