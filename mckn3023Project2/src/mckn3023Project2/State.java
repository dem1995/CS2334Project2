package mckn3023Project2;

import java.util.ArrayList;

public class State {
	
	private ArrayList<City> cities;
	
	public State(ArrayList<City> cities)
	{
		this.cities=cities;
	}
	
	/** 
	 * @param city
	 */
	public void addCity(City city)
	{
		this.cities.add(city);
	}
	
	public ArrayList<Person> searchForName(String name)
	{
		//TODO
		return new ArrayList<Person>();
	}
	
	
	
}