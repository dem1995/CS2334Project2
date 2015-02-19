package mckn3023Project2;

/**
 *Holds a <code>PersonList</code> of people, emulating the population of a city
 */
public class City implements Comparable<City> {
	
	//Instance variables~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Holds all of the people in this <code>City</code>
	 */
	private PersonList personList;
	
	//Instance method
	/**
	 * Creates a <code>City</code> and an empty <code>PersonList</code>
	 */
	public City()
	{
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
	
	//Interface-required methods
	public int compareTo(City city) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
