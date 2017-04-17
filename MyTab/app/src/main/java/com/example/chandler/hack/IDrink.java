package com.example.chandler.hack;

import android.media.Image;

public interface IDrink {

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
