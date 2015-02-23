package project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Project #2
 * CS 2334, Section 010
 * Feb 18, 2015
 * <p>
 * A sort-of wrapper for an <code>ArrayList</code> of <code>Person</code>s
 * </p>
 * @version 1.0
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
	 * An <code>ArrayList</code> of <code>Person</code>s
	 */
	private ArrayList<Person> people;
	
	
	//Instance methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Creates a <code>PersonList</code> with an empty <code>people</code>
	 */
	public PersonList()
	{
		people=new ArrayList<Person>();
	}
	
	//Getter methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * A method for getting a <code>Person</code> from <code>people</code>
	 * @param i The index of the person to be gotten
	 * @return The person at index i of PersonList's people object
	 */
	public Person getPerson(int i)
	{
		return (people.get(i));
	}
	
	//Sorting methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Sorts <code>people</code> using <code>comparator</code>. If <code>comparator</code> is <code>null</code>, uses natural ordering. Changes <code>currentlySortedBy</code>.
	 * @param comparator How people should be sorted
	 */
	public void sortUsing(Comparator<Person> comparator)
	{
		Collections.sort(people, comparator);
		System.out.println(comparator.getClass());
	}
	
	//Searching methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	/**
	 * Searches <code>people</code> for and returns <code>Person</code>s with data that exactly match <code>key</code>
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
	 * Searches <code>people</code> for and returns <code>Person</code>s with full names that contain <code>key</code>
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
	 * Merges two <code>Person</code>s into one
	 * @param person The Person to be merged with the Person this is called on.
	 * @return a combination of the PersonList that the combineWith method was called for and the PersonList the combineWith method was sent
	 */
	public PersonList combineWith(PersonList person)
	{
		//TODO
		return null;
	}
	
	/**
	 * A method for adding a <code>Person</code> to <code>people</code>
	 * @param person The person to be added to People
	 */
	public void addPerson(Person person)
	{
		people.add(person);		
	}
	
	public String toString()
	{
		String cheese="";
		for (int i=0; i<people.size(); i++)
			cheese+=people.get(i).toString()+"\n";
		return cheese;
	}
	

}
