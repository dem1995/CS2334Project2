package project2;

import java.util.ArrayList;

/**
 * Project #2
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
	ArrayList<State> states;
	
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
	

	//Search method
	/**
	 * Finds and returns a <code>State</code> matching the <code>name</code>
	 * @param name The name of the State to be found
	 * @return The State that was found
	 */
	public State findState(String name)
	{
		//TODO
		return null;
	}
	
	//Adder method
	/**
	 * Adds a <code>State</code> to <code>states</code>
	 * @param state The State to be added to states
	 */
	public void addState(State state)
	{
		states.add(state);
	}
	
}