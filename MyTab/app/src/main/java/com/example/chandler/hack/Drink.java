package com.example.chandler.hack;

import android.media.Image;

/**
 * Created by adampaquette on 4/13/17.
 */

public class Drink implements IDrink {

    private int rating;
    private String name, description;
    private Image image;

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void update() {
    }

    public void edit() {
    }
}
