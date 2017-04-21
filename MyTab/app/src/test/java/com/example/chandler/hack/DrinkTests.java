package com.example.chandler.hack;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DrinkTests {

	private Drink drink;
	private Beer beer;
	private Wine wine;
	private Spirit spirit;

	@Before
	public void initTests() {
		drink = new Drink();
		beer = new Beer();
		wine = new Wine();
		spirit = new Spirit();
	}

	@Test
	public void genericDrinkTestName() {
		drink.setName("Bud Light");
		assertEquals(drink.getName(), "Bud Light");
	}

	@Test
	public void genericDrinkTestDescription() {
		drink.setDescription("Trash");
		assertEquals(drink.getDescription(), "Trash");
	}
		
	@Test
	public void genericDrinkTestImage() {
		/*Image testImage = new Image();
		drink.setImage(testImage);
		assertEquals(drink.getImage(), testImage);*/
	}

	@Test
	public void genericDrinkTestRating() {
		drink.setRating(2);
		assertEquals(drink.getRating(), 2);
	}

	@Test
	public void BeerTestIBU() {
		beer.setIBU(3.3);
		assertEquals(beer.getIBU(), 3.3, .01);
	}

	@Test
	public void WineTestFlavorNote() {
		wine.setFlavorNote("Tennis Balls");
		assertEquals(wine.getFlavorNote(), "Tennis Balls");
	}

	@Test
	public void WineTestType() {
		wine.setType("Red");
		assertEquals(wine.getType(), "Red");
	}

	@Test
	public void SpiritTestProof() {
		spirit.setProof(50);
		assertEquals(spirit.getProof(), 50);
	}
}
