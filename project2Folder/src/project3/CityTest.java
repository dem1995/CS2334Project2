package project3;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CityTest {

	@Test
	public void test() {
		City city= new City("Los Angeles");
		City city2=new City("St. Louis");
		int firstComparison=city.compareTo(city2);
		assertEquals(firstComparison/Math.abs(firstComparison), -1);
		int oppositeComparison=city2.compareTo(city);
		assertEquals(oppositeComparison/Math.abs(oppositeComparison), 1);
		int equalsComparison=city.compareTo(city);
		assertEquals(equalsComparison, 0);
	}
}
