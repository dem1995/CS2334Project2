package project3;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Project #3
 * CS 2334, Section 010
 * March 4, 2015
 * <p>
 * A <code>LinkedHashMap</code> of <code>team</code>s
 * </p>
 * @version 1.0
 */
public class TeamLinkedHashMap extends LinkedHashMap<String, Team>{

	/**
	 * Default constructor for TeamLinkedHashMap
	 */
	public TeamLinkedHashMap()
	{
	}
	
	//Adder method
	public void addTeam(Team team)
	{
		this.put(team.getTeamName(), team);
	}
}
