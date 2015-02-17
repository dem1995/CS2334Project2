package mckn3023Project2;

import java.util.ArrayList;

/**
 *A sort-of wrapper for an ArrayList<Person> object 
 */
public class PersonList {
	/**
	 * An ArrayList of Person objects
	 */
	private ArrayList<Person> people;
	
	/**
	 * Creates a PersonList with an empty ArrayList<Person> people object
	 */
	public PersonList()
	{
		people=new ArrayList<Person>();
	}
	
	/**
	 * Sorts the ArrayList<Person> people by the PersonObjects' firstName Strings
	 */
	public void sortByFirstName()
	{
		//TODO
	}
	
	/**
	 *sorts the ArrayList<Person> people by the PersonObjects' lastName Strings
	 */
	public void sortByLastName()
	{
		//TODO
	}
	
	/**
	 * Searches the ArrayList<Person> people for Person objects whose full names contain the String name
	 * @param name
	 */
	public PersonList(String name)
	{
		//TODO
	}
	
	/**
	 * Merges two person objects into one
	 * @param person
	 * @return a combination of the PersonList that the combineWith method was called for and the PersonList the combineWith method was sent
	 */
	public PersonList combineWith(PersonList person)
	{
		//TODO
		return new PersonList();
	}
	
	/**
	 * A method for adding a person to PersonList's ArrayList<Person> people object
	 * @param person The person to be added to People
	 */
	public void addPerson(Person person)
	{
		people.add(person);		
	}
	
	/**
	 * A method for getting a Person from PersonList's ArrayList<Person> people object at index i
	 * @param i The index of the person to be gotten
	 * @return The person at index i of PersonList's ArrayList<Person> people object
	 */
	public Person getPerson(int i)
	{
		return (people.get(i));
	}
}
