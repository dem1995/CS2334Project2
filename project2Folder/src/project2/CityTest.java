package project2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CityTest {

	@Test
	public void test() {
		City city= new City("Los Angeles");
		City city2=new City("St. Louis");
		assertEquals(city.compareTo(city2), -1);
	}

}