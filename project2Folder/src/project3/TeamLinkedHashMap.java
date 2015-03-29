package project3;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Project #3
 * CS 2334, Section 010
 * March 4, 2015
 * <p>
 * A <code>LinkedHashMap</code> of <code>team</code>s
 * </p>
 * @version 1.0
 */
public class TeamLinkedHashMap extends LinkedHashMap<String, Team> implements Serializable{

	/**
	 * Default constructor for TeamLinkedHashMap
	 */
	public TeamLinkedHashMap()
	{
	}
	
	//Adder method
	/**
	 * Adds a Team to this TeamLinkedHashMap
	 * @param team the Team to be added to this TeamLinkedHashMap
	 */
	public void addTeam(Team team)
	{
		assert(team!=null);
		this.put(team.getTeamName(), team);
	}
	
	/**
	 * Sorts this TeamLinkedHashMap by Team name by putting it into a treeMap and bringing it back
	 */
	public void sort()
	{
		TreeMap<String, Team> treeMap=new TreeMap<String, Team>(this);
		this.putAll((treeMap));
	}
}
