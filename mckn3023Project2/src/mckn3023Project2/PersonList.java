package mckn3023Project2;

import java.util.ArrayList;

public class PersonList {
	/**
	 * An ArrayList of Person objects
	 */
	private ArrayList<Person> people;
	
	public PersonList()
	{}
	
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
	
	public void addPerson(Person person)
	{
		people.add(person);		
	}
	
	public Person getPerson(int i)
	{
		return (people.get(i));
	}
}
