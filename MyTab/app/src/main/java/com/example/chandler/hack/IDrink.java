package com.example.chander.hack;

import android.media.Image;

public interface IDrink {

	private String name, description;
	private int rating;
	private Image image;

	public void setName(String name);

	public String getName();

	public void setDescription(String description);

	public String getDescription();

	public void setImage(Image image);

	public Image getImage();

	public void setRating(int rating);

	public int getRating();

	public void update();
	
	public void edit();
}
