package mckn3023Project2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CityTest {

	@Test
	public void test() {
		City test = new City();
		PersonList output = test.searchForName();
		assertEquals(("expected result"), output);
	}

}
