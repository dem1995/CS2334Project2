package project3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Project #3
 * CS 2334, Section 010
 * Feb 18, 2015
 * <p>
 *Holds a bunch of <code>State</code> objects
 *</p>
 *@version 1.0
 */
public class Country {

	//Instance variables
	/**
	 * The <code>State</code>s contained by this <code>Country</code>
	 */
	private ArrayList<State> states;
	
	//Instance methods	
	/**
	 * Constructs a <code>Country</code> with an empty <code>ArrayList{@literal <}State{@literal >}</code>
	 */
	public Country() {
		this.states=new ArrayList<State>();
	}

	/**
	 * Constructs a <code>Country</code> with an <code>ArrayList{@literal <}State{@literal >}</code> that is a copy of <code>states</code>
	 * @param states The States you want this Country to hold
	 */
	public Country(ArrayList<State> states) {
		this.states = states;
	}
	
	//Accessor Methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * @return this <code>country</code>'s states
	 */
	public ArrayList<State> getStates()
	{
		return this.states;
	}
	

	//Search methods
	/**
	 * Finds and returns a <code>State</code> matching the <code>name</code>
	 * @param name The name of the State to be found
	 * @return The State that was found
	 */
	public State findStateOrAdd(String name)
	{
		name=name.toLowerCase();
		for (State state: states)
		{
			if (state.getName().toLowerCase().equalsIgnoreCase(name))
				return state;
		}
		State newState=new State(name);
		states.add(newState);
		return newState;
	}
	/**
	 * Finds and returns a <code>State</code> matching the <code>name</code> without adding any extra states
	 * @param name The name of the State to be found
	 * @return The State that was found
	 */
	public State findState(String name)
	{
		name=name.toLowerCase();
		for (State state: states)
		{
			if (state.getName().toLowerCase().equalsIgnoreCase(name))
				return state;
		}
		return null;
	}
	
	//Adder methods
	/**
	 * Adds a <code>State</code> to <code>states</code>
	 * @param state The State to be added to states
	 */
	public void addState(State state)
	{
		states.add(state);
	}
	
	/**
	 * @return The Country as an arrayList of Person objects
	 */
	public PersonList toPersonList()
	{
		PersonList tempList=new PersonList();
		for (State s: states)
			for (City c: s.getCities())
				for (Person p: c.getPersonList().getPeople())
					tempList.addPerson(p);
		return tempList;
	}
	
	//Other methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/**
	 * Sorts the <code>State</code>s in this <code>Country</code>
	 */
	public void sort()
	{
		Collections.sort(states);
	}
	

	public String toString()
	{
		return toPersonList().toString();
	}


}