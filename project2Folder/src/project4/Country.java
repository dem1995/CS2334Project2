package project4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

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
	
	

	/**
	 * Lets you know if this Country's treeMap of people (basically a quick way to search for people if you don't know their city or state) needs to be updated due to changes to this Country.
	 */
	private boolean treeMapNeedsBuilding=true;
	
	/**
	 * A treemap of players. Used to assign birthdates to players
	 */
	private TreeMap<String, Person> treeMap=new TreeMap<String, Person>();
	
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
	protected State findStateOrAdd(String name)
	{
		name=name.toLowerCase();
		for (State state: states)
		{
			//System.out.println(name+" "+state.getName());
			//System.out.println(name.equalsIgnoreCase(state.getName()));
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
	
	/**
	 * Searches this country for a Team of a given name
	 * @param teamName The name of the Team that this object looks for
	 * @return The Team matching the name given in the parameters
	 * @throws Exception Thrown if team is null
	 */
	public Team findTeam(String teamName) throws Exception
	{
		Team team=null;
		for (State state: getStates())
			for (City city: state.getCities())
				if(!(city.getTeams().get(teamName)==null)){
				team=city.getTeams().get(teamName);
				}
		if (team==null)
			throw new Exception();
		else
			return team;
	}
	
	/**
	 * Searches this Country for a Person. Only to be used if the State and City of the Person are unknown
	 * @param personName The name of the Person this method is searching for
	 * @return A Person with the name given via this method's parameters
	 */
	public Person findPerson(String personName)
	{
		if(treeMapNeedsBuilding)
		{
			for (Person person: this.toPersonList().getPeople())
				treeMap.put(person.getFullName(), person);
		}
		treeMapNeedsBuilding=false;
		return (treeMap.get(personName));
	}
	
	//Adder methods
	
	/**
	 * Method for adding a person to this country
	 * @param aPerson The person to be added
	 */
	protected void addPerson(Person aPerson)
	{
		findStateOrAdd(aPerson.getStateName()).findCityOrAdd(aPerson.getCityName()).getPersonList().addPerson(aPerson);
		treeMapNeedsBuilding=true;
	}
	
	/**
	 * Adds a <code>State</code> to <code>states</code>
	 * @param state The State to be added to states
	 */
	protected void addState(State state)
	{
		states.add(state);
	}
	
	protected void addCity(State state, City city)
	{
		state.addCity(city);
	}
	
//WARNING: Use the below methods to add teams to cities, don't use the addTeam method found in City
	/**
	 * Adds a <code>Team</code> to the TeamLinkedHashMap of one of the Cities held by one of the States in this Country
	 * @param team The team to be added
	 */
	protected void addTeam(Team team)
	{
		assert (team!=null);
		for (int i=0; i<team.getTeamMembers().getPeople().size(); i++)
		{
			if(this.findPerson(team.getTeamMembers().getPeople().get(i).getFullName())!=null)
			team.getTeamMembers().getPeople().set(i,this.findPerson(team.getTeamMembers().getPeople().get(i).getFullName()));
		}
	    State theState=this.findStateOrAdd(team.getStateName());
	    City theCity=theState.findCityOrAdd(team.getCityName());
	    theCity.addTeam(team);
	}

	/**
	 * Adds <code>Team</code>s to the TeamLinkedHashMaps of one of the Cities held by the States in this Country
	 * @param teams
	 */
	protected void addTeams(ArrayList<Team> teams)
	{
		for (Team team: teams)
		{
			try
		{
			this.addTeam(team);
		}catch (Exception e)
		{
			System.out.println("AddTeams Error");
			e.printStackTrace();
		}
		}
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