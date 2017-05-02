package com.example.chandler.hack;

import android.media.Image;

/**
 * Created by adampaquette on 4/13/17.
 */

public class Drink implements IDrink {

    private float rating;
    private String name;
    private String description;
    private Image image;

    public Drink() {
        rating = 0;
	name = "";
	description = "";
	//image = new Image();
    }

    public float getRating() {
        return this.rating;
    }

    public void setRating(float rating) {
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
