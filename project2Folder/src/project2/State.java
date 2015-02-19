package project2;

import java.util.ArrayList;

/**
 * Project #2
 * CS 2334, Section 010
 * Feb 18, 2015
 * <p>
 * Holds an <code>ArrayList</code> of <code>Cities</code> and provides methods for searching that list
 * </p>
 * @version 1.0
 */
public class State {
	
	//Instance variables~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	/**
	 * <code>True</code> if <code>cities</code> has been sorted, <code>False</code> otherwise
	 */
	public boolean isSorted;
	
	/**
	 * An <code>ArrayList</code> of <code>City</code> objects
	 */
	private ArrayList<City> cities;
	
	/**
	 * The name of the city
	 */
	private String stateName;
	
	//Instance methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	/**
	 * Creates a <code>State</code> with an empty <code>ArrayList</code> of <code>Cities</code>
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
	
	//Search method~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Searches for and returns a <code>City</code> with a name that exactly matches <code>cityName</code>.
	 * @param cityName The exact name of the city to be found
	 * @return A City with a name that exactly matches the search parameter if one is found, otherwise returns null.
	 */
	public City searchFor(String cityName)
	{
		//TODO
		return null;
	}
	
	//Adder methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	/** 
	 * Adds <code>city</code> to <code>cities</code>
	 * @param city The City to be added
	 */
	public void addCity(City city)
	{
		this.cities.add(city);
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
	
	
	
}
