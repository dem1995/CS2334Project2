/**
 * 
 */
package mckn3023Project2;

import java.util.Date;

/**
 * An object that contains data about a person, such as a first name, a last name, and a birthdate. Middle names are opional.
 */
public class Person implements Comparable<Person> {
	
	//Instance Variables~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/**
	 *The first name of the person 
	 */
	private String firstName;
	/**
	 * The last name of the person
	 */
	private String lastName;
	/**
	 * The middle names of the person, separated by spaces
	 */
	private String middleNames;
	/**
	 * The date of birth of the person
	 */
	private Date birthDate;
	
	//Instance Methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/**
	 * Constructor method for person with a first name, a middle name, a last name, and a birthdate.
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
	 * Getter method for the first name
	 * @return The firstName String of the person object
	 */
	
	//Getter Methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * Getter method for the last name
	 * @return The firstName String of the person object
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * Getter method for the middle names
	 * @return The firstName String of the person object
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
		return (firstName+" "+middleNames+" "+lastName);
	}
	
	/**
	 * Getter method for the birthdate
	 * @return The date of birth of the Person
	 */
	public Date getBirthDate()
	{
		return birthDate;
	}
	
	//Interface-required Methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public int compareTo(Person otherPerson) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
