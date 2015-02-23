package project2;

import static org.junit.Assert.*;

import org.junit.Test;

public class StateTest {

	@Test
	public void test() {
		State state=new State("Missouri");
		City city= new City("Town and Country");
		City city2=new City("St. Louis City");
		City city3=new City("Ballwin");
		state.addCity(city);
		state.addCity(city2);
		state.addCity(city3);
		assertEquals(state.searchFor("Town and Country").getName(), "Town and Country");
	}

}
