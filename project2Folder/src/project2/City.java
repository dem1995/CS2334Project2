package project2;

import java.awt.geom.Point2D;

/**
 * Project #2
 * CS 2334, Section 010
 * Feb 27, 2015
 * <p>
 * Holds a <code>PersonList</code> of people, emulating the population of a city
 * </p>
 * @version 1.0
 */
public class City implements Comparable<City> {
	
	//Instance variables~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Holds all of the people in this <code>City</code>
	 */
	private PersonList personList;
	
	/**
	 * The name of the city
	 */
	private String cityName;
	
	/**
	 * The teams based in this city
	 */
	private TeamLinkedHashMap teams;
	
	/**
	 * The geographic coordinates of this city
	 */
	private Point2D coordinates;
	//Instance method
	/**
	 * Creates a <code>City</code> with the name <code>cityName</code> and an empty <code>PersonList</code>
	 * @param cityName The name of the city
	 */
	public City(String cityName)
	{
		this.cityName=cityName;
		this.personList=new PersonList();
	}
	
	//Accessor methods
	/**
	 * Retrieves <code>personList</code>
	 * @return A PersonList of Person objects in this City's PersonList personList
	 */
	public PersonList getPersonList()
	{
		return personList;
	}
	
	/**
	 * A getter method for cityName
	 * @return the name of the city
	 */
	public String getName()
	{
		return cityName;
	}
	
	/**
	 * A getter method for coordinates
	 * @return The geographic coordinates of this city
	 */
	public Point2D getCoordinate()
	{
		return coordinates;
	}
	
	//Setter methods
	/**
	 * Adjusts the y-value of this city's geographic location
	 * @param latitude the y-value of this city's geographic location
	 */
	public void setLatitude(int latitude)
	{
	    //TODO	
	}
	/**
	 * Adjusts the x-value of this city's geographic location
	 * @param longitude the x-value of this city's geographic location
	 */
	public void setLongitude(int longitude)
	{
	    //TODO	
	}
	
	//Interface-required methods
	public int compareTo(City city) {
		return this.getName().compareTo(city.getName());
	}
	
	
}
