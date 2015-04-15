package project4;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Project #3
 * CS 2334, Section 010
 * Feb 18, 2015
 * <p>
 * Holds an <code>ArrayList</code> of <code>Cities</code> and provides methods for searching that list
 * </p>
 * @version 1.0
 */
public class State implements Comparable<State>{
	
	//Instance variables~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	/**
	 * <code>true</code> if <code>cities</code> has been sorted, <code>false</code> otherwise
	 */
	public boolean isSorted=false;
	
	/**
	 * An <code>ArrayList</code> of <code>City</code> objects
	 */
	private ArrayList<City> cities;
	
	/**
	 * The name of the state
	 */
	private String stateName;
	
	
	//Instance methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	/**
	 * Creates a <code>State</code> with an empty <code>ArrayList</code> of <code>Cities</code>
	 * @param stateName The name of the state
	 */
	public State(String stateName)
	{
		this.stateName=stateName;
		this.cities=new ArrayList<City>();
	}
	/**
	 * Creates a <code>State</code> that contains a copy of <code>cities</code>
	 * @param cities The Cities for this State to hold
	 */
	public State(ArrayList<City> cities)
	{
		this.cities=cities;
	}
	
	//Getter methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		/**
		 * A getter method for <code>stateName</code>
		 * @return stateName
		 */
		public String getName()
		{
			return stateName;
		}
		
		/**
		 * getter method for <code>cities</code>
		 * @return the arrayList of Cities held by this State
		 */
		public ArrayList<City> getCities()
		{
			return cities;
		}
		
	
	
	//Search method~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Searches for and returns a <code>City</code> with a name that exactly matches <code>cityName</code>.
	 * @param cityName the name of the City to find.
	 * @return A City with a name that exactly matches the search parameter if one is found, otherwise returns null.
	 */
	public City findCity(String cityName)
	{
		cityName=cityName.toLowerCase();
		for (City city: cities)
		{
			if (city.getName().toLowerCase().equalsIgnoreCase(cityName))
				return city;
		}
		return null;
	}
	
	/**
	 * Searches for and returns a <code>City</code> with a name that exactly matches <code>cityName</code>.
	 * @param cityName The exact name of the city to be found
	 * @return A City with a name that exactly matches the search parameter if one is found, otherwise add that city and return it.
	 */
	City findCityOrAdd(String cityName)
	{
		cityName=cityName.toLowerCase();
		for (City city: cities)
		{
			if (city.getName().toLowerCase().equalsIgnoreCase(cityName))
				return city;
		}
		City newCity=new City(cityName);
		cities.add(newCity);
		return newCity;
	}
	
	
	//Adder methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	/** 
	 * Adds <code>city</code> to <code>cities</code>. Sets <code>isSorted</code> to false
	 * @param city The City to be added
	 */
	void addCity(City city)
	{
		this.cities.add(city);
		isSorted=false;
	}
	
	/**
	 * Method for sorting the list of <Code>City</code> objects in this <code>State</code>. Sets <code>isSorted</code> to <code>false</code>.
	 */
	void sort()
	{
		Collections.sort(cities);
		isSorted=true;
	}
	
	@Override
	public int compareTo(State s) {
		return this.getName().compareToIgnoreCase(s.getName());
	}
	
	public String toString()
	{
		return this.getName();
	}
	
	
	
}
