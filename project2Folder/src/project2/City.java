package project2;

/**
 * Project #2
 * CS 2334, Section 010
 * Feb 18, 2015
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
	
	//Getter methods
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
	
	//Interface-required methods
	public int compareTo(City city) {
		return this.getName().compareTo(city.getName());
	}
	
	
}