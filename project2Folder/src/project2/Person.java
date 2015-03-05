/**
 * 
 */
package project2;

import java.util.Date;

/**
 * Project #3
 * CS 2334, Section 010
 * Feb 18, 2015
 * <p>
 * An object that contains data about a person, such as a first name, a last name, and a birthdate. Middle names are optional.
 * </p>
 * @version 1.0
 */
public class Person implements Comparable<Person> {
	
	//Instance Variables~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/**
	 *The first name of the person 
	 */
	private String firstName="";
	/**
	 * The last name of the person
	 */
	private String lastName="";
	/**
	 * The middle names of the person, separated by spaces
	 */
	private String middleNames="";

	/**
	 * The name of the city the person lives in
	 */
	private String cityName="";
	
	/**
	 * The name of the state the person lives in
	 */
	private String stateName="";
	/**
	 * The date of birth of the person
	 */
	private Date birthDate;
	
	//Instance Methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	

	/**
	 * Constructor method for a person with a first name, a middle name, a last name, and a birthdate.
	 * @param firstName The person's first name
	 * @param lastName The person's last name
	 * @param birthDate The person's birth date.
	 */
	public Person(String firstName, String lastName, Date birthDate)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.birthDate=birthDate;
	}
	
	/**
	 * Constructor method for person with a first name, a middle name, a last name, and a birthdate.
	 * @param firstName The person's first name
	 * @param middleNames The person's middle names, separated by spaces
	 * @param lastName The person's last name
	 * @param birthDate The person's birth date.
	 */
	public Person(String firstName, String middleNames, String lastName, Date birthDate)
	{
		this(firstName, lastName, birthDate);
		this.middleNames=middleNames;
	}
	
	/**
	 * Constructor method for a person with a given name
	 * @param fullName The person's fullName, is split up, and its components are assigned to firstName, lastName, and middleNames
	 * @param birthDate The person's birth date
	 */
	
	public Person(String fullName, Date birthDate)
	{
		String[] names=fullName.split(" ");
		for (int i=0; i<names.length; i++)
		{
			if (i==0)
				this.firstName=names[i];
			else if (i<names.length-2)
				this.middleNames+=(names[i]+" ");
			else if (i==names.length-2)
				this.middleNames+=(names[i]);
			else if (i==names.length-1)
				this.lastName=names[i];
		}			
		this.birthDate=birthDate;
	}

	

	
	//Getter Methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Getter method for <code>firstName</code>
	 * @return The firstName String of the person object
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * Getter method for <code>lastName</code>
	 * @return The lastName String of the person object
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * Getter method for <code>middleNames</code>
	 * @return The middleNames String of the person object
	 */
	public String getMiddleNames()
	{
		return middleNames;
	}
	
	/**
	 * Returns the full name of the person, in the order First Middles Last
	 * @return The full name of the person, in the order First Middles Last
	 */
	public String getFullName()
	{
		if (lastName=="")
			return firstName;
		if (middleNames=="")
			return firstName+" "+lastName;
		return (firstName+" "+middleNames+" "+lastName);
	}
	
	/**
	 * Getter method for <code>birthDate</code>
	 * @return The date of birth of the Person
	 */
	public Date getBirthDate()
	{
		return birthDate;
	}
	
	/**
	 * Getter method for <code>stateName</code>
	 * @return the name of the state the person lives in
	 */
	public String getStateName()
	{
		return stateName;
	}
	
	/**
	 * Getter method for <code>cityName</code>
	 * @return The name of the city the person lives in
	 */
	public String getCityName()
	{
		return cityName;
	}
	
	//Setter Methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Setter method for <code>stateName</code>
	 * @param stateName The name of the state
	 */
	public void setStateName(String stateName)
	{
		this.stateName=stateName;
	}
	
	/**
	 * Setter method for <code>cityName</code>
	 * @param cityName The name of the city
	 */
	public void setCityName(String cityName)
	{
		this.cityName=cityName;
	}
	
	public String toString()
	{
		if(getBirthDate() == null)
		{
			return getFullName()+","+getCityName()+","+getStateName();
		}
		return getFullName()+","+getCityName()+","+getStateName() +","+getBirthDate();
	}
	
	//Interface-required Methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public int compareTo(Person otherPerson) {
		return this.getFullName().compareToIgnoreCase(otherPerson.getFullName());
	}
	

}
