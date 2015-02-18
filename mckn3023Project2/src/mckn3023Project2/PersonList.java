package mckn3023Project2;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *A sort-of wrapper for an ArrayList<Person> object 
 */
public class PersonList {
	
	//Static Comparator<Person> objects. To be used when sorting and searching for things		
	/**
	 * Comparator for searching/sorting by first name
	 */
	public static CompareFirstName firstNameComparator=new CompareFirstName();
	/**
	 * Comparator for searching/sorting by last name
	 */
	public static CompareLastName lastNameComparator=new CompareLastName();
	/**
	 * Comparator for searching/sorting by birthdate
	 */
	public static CompareBirthDate birthDateComparator=new CompareBirthDate();

	
	//Instance variables~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * How the list is currently sorted
	 */
	public String currentlySortedBy="";
	
	/**
	 * An ArrayList of Person objects
	 */
	private ArrayList<Person> people;
	
	/**
	 * Creates a PersonList with an empty ArrayList<Person> people object
	 */
	
	//Instance methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public PersonList()
	{
		people=new ArrayList<Person>();
	}
	
	/**
	 * Sorts the ArrayList<Person> people via a Comparator comparator. If comparator is null, sorts via natural ordering defined by the methods defined for the Comparable<Person> interface of Person objects
	 * @param comparator The Comparator<Person> with which the sorting will be done. If null, uses the natural ordering defined by the methods defined for the Comparable<Person> interface of Person objects
	 */
	
	//Getter methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * A method for getting a Person from PersonList's ArrayList<Person> people object at index i
	 * @param i The index of the person to be gotten
	 * @return The person at index i of PersonList's ArrayList<Person> people object
	 */
	public Person getPerson(int i)
	{
		return (people.get(i));
	}
	
	//Sorting methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Sorts the ArrayList<Person> people using the Comparator<Person> comparator
	 * @param comparator How the ArrayList<Person> people should be sorted
	 */
	public void sortUsing(Comparator<Person> comparator)
	{
		//TODO
	}
	
	//Searching methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	/**
	 * Searches the ArrayList<Person> people for Person objects with data that exactly match the key
	 * @param key Either a full name, a first name, a last name, or a String representation of a date, depending on the comparator
	 * @param comparator How the searching will be done
	 * @return A PersonList with Person objects whose data exactly matches the key
	 */
	public PersonList exactSearchFor(String key, Comparator<Person> comparator)
	{
		//TODO
		return null;
	}
	
	/**
	 * Searches the ArrayList<Person> people for Person objects with full names that contain the key
	 * @param name What the Persons in the returned PersonList should contain in their full names
	 * @return A PersonList with Person objects whose full names contain the key
	 */
	public PersonList partialSearchNamesFor(String name)
	{
		//TODO
		return null;
	}
	

	//Other methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Merges two person objects into one
	 * @param person
	 * @return a combination of the PersonList that the combineWith method was called for and the PersonList the combineWith method was sent
	 */
	public PersonList combineWith(PersonList person)
	{
		//TODO
		return null;
	}
	
	/**
	 * A method for adding a person to PersonList's ArrayList<Person> people object
	 * @param person The person to be added to People
	 */
	public void addPerson(Person person)
	{
		people.add(person);		
	}
	

}
