package project3;

import java.util.LinkedHashMap;

/**
 * Project #3
 * CS 2334, Section 010
 * March 4, 2015
 * <p>
 * A <code>LinkedHashMap</code> of <code>team</code>s
 * </p>
 * @version 1.0
 */
public class TeamLinkedHashMap extends LinkedHashMap<String, Team> {


	//TODO fill in the comments
	/**
	 * the name of the team
	 */
	String teamName;
	/**
	 * the team
	 */
	Team team;
	
	/**
	 * Default constructor for TeamLinkedHashMap
	 */
	public TeamLinkedHashMap()
	{
	}
	/**
	 * @param	team
	 * @param	value
	 */
	public TeamLinkedHashMap(Team team,String teamName)
	{
		this.team		=	team;
		this.teamName	=	teamName;
	}

	/**
	 * @param	location	the location where to look for people in
	 * @return	the people who live in the given location
	 */
	public PersonList getPersonListOfTeamAt(String location)
	{
		PersonList personList = new PersonList();
		for(int i = 0; i< this.team.teamMembers.getPeople().size()  ;i++)
		{
			Person person = this.team.teamMembers.getPerson(i);
			if(person.getCityName() == location)
			{
				personList.addPerson(person);
			}
			else if(person.getStateName() == location)
			{
				personList.addPerson(person);
			}
		}
		return personList;
	}
	
	//Setter methods
	/**
	 * @param team
	 */
	public void setTeam(Team team)
	{
		this.team = team;
	}
	/**
	 * @param value
	 */
	public void setTeamName(String teamName)
	{
		this.teamName = teamName;
	}
}
