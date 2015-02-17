/**
 * 
 */
package mckn3023Project2;

import java.util.Date;


/**
 * @author Dave
 *
 */
public class Person implements Comparable<Person> {
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
	
	public Person(String firstName, String lastName, Date birthDate)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.birthDate=birthDate;
	}
	
	public Person(String firstName, String middleNames, String lastName, Date birthDate)
	{
		this(firstName, lastName, birthDate);
		this.middleNames=middleNames;
	}


	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
