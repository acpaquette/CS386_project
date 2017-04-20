public com.example.chandler.hack;

import org.junit.Assert.*;

public class DrinkTests {

	Drink drink;
	Beer beer;
	Wine wine;
	Spirit spirit;

	@Test
	public void initTests() {
		drink = new Drink();
		beer = new Beer();
		wine = new Wine();
		spirit = new Spirit();
	}
}
