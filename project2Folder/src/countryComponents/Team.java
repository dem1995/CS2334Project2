package countryComponents;

import java.io.Serializable;

/**
 * Project #4
 * CS 2334, Section 010
 * April 16, 2015
 * <p>
 * Holds a <code>PersonList</code> of team members, the name of the city in which they are based, and the name of the state that city is in.
 * </p>
 * @version 1.0
 */
public class Team implements Comparable<Team>, Serializable{

	/**
	 * The name of the state in which this team is based
	 */
	String stateName;
	
	/**
	 * The name of the city in which this team is based
	 */
	String cityName;
	
	/**
	 * the name of the team
	 */
	String teamName;
	
	/**
	 * The members of this team
	 */
	PersonList teamMembers;
	
	/**
	 * Creates a Team object
	 * @param line The line from which the team will draw its data
	 */
	public Team(String line)
	{
		try
		{
		String[] teamParts = line.split(";");
		this.teamName.equalsIgnoreCase(teamParts[0]);
		this.cityName.equalsIgnoreCase(teamParts[1]);
		this.stateName.equalsIgnoreCase(teamParts[2]);
		PersonList personList	= new PersonList();
		for(int i = 3; i<teamParts.length;i++)
		{
			Person person	= new Person(teamParts[i]);
			personList.addPerson(person);
		}
		this.teamMembers	= personList;
		}
		catch (Exception e)
		{
		}
	}
	
	/**
	 * 
	 */
	public Team()
	{
	}





	/**
	 * Getter method for the PersonList containing this team's members
	 * @return The PersonList containing this team's members
	 */
	public PersonList getTeamMembers()
	{
		return teamMembers;
	}
	
	/**
	 * Getter method for cityName
	 * @return The name of the city in which this team is based
	 */
	public String getCityName()
	{
		return cityName;
	}
	
	/**
	 * Getter method for stateName
	 * @return The name of the state in which this team is based
	 */
	public String getStateName()
	{
		return stateName;
	}
	
	
	/**
	 * Setter method for cityName
	 * @param cityName The name of the city in which this team is based
	 */
	void setCityName(String cityName)
	{
		this.cityName=cityName;
	}
	
	/**
	 * Setter method for stateName
	 * @param stateName The name of the state in which this team is based
	 */
	void setStateName(String stateName)
	{
		this.stateName=stateName;
	}
	
	/**
	 * Setter method for teamMembers
	 * @param teamMembers The team members of this team
	 */
	public void setTeamMembers(PersonList teamMembers)
	{
		teamMembers.sortUsing(PersonList.middleNamesComparator);
		teamMembers.sortUsing(PersonList.firstNameComparator);
		teamMembers.sortUsing(PersonList.lastNameComparator);
		this.teamMembers=teamMembers;
	}


	/**
	 * Getter method for teamName
	 * @return The name of the team
	 */
	public String getTeamName()
	{
		return teamName;
	}
	
	
	/**
	 * Setter method for teamName
	 * @param teamName The name of the team
	 */
	public void setTeamName(String teamName)
	{
		this.teamName=teamName;
	}
	



	@Override
	public int compareTo(Team o) {
		return this.getTeamName().compareToIgnoreCase(o.getTeamName());
	}	
	//Conversion methods
	
	/**
	 * Converts a String to a Team object
	 * @param line The string to be converted to a team
	 * @return a team created from the parater string
	 */
	public static Team convertStringToTeam(String line)
	{
		Team team= new Team();
	
		String[] teamParts = line.split(";");
		team.teamName	= teamParts[0].trim();
		team.cityName	= teamParts[1].trim();
		team.stateName	= teamParts[2].trim();
		PersonList personList	= new PersonList();
		for(int i = 3; i<teamParts.length-3;i++)
		{
			Person person	= new Person(teamParts[i].trim());
			personList.addPerson(person);
		}
		team.setTeamMembers(personList);
		
		return team;
	}
	
}