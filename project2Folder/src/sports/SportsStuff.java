package sports;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import otherClasses.HelperMethods;
import countryComponents.DateFormatter;
import countryComponents.Person;
import countryComponents.PersonList;

public class SportsStuff{
	
	/**
	 * A HashMap where the keys are String team IDs and the values are Teams
	 */
	static TreeMap<String, Team> teams;
	
	
	/**
	 *All of the teamSeasons (for rendering to JList)
	 */
	static ArrayList<TeamSeason> teamSeasons;
	
	/**
	 * All of the SportsYears in this object
	 */
	static TreeMap<Integer, SportsYear> sportsYears;
	
	
	public SportsStuff(){
		teams= new TreeMap<String, Team>();
		teamSeasons=new ArrayList<TeamSeason>();
		sportsYears=new TreeMap<Integer, SportsYear>();
	}
	
	/**
	 * Adds a team with the specified ID to the teams TreeMap
	 * @param ID
	 * @param team
	 */
	public void addTeam(String ID, Team team)
	{
		teams.put(ID, team);
	}
	
	public void addTeamSeason(String ID, TeamSeason teamSeason, int year)
	{
		teamSeasons.add(teamSeason);
	}
	
	public static void main (String[] args)
	{
		SportsStuff sportsStuff= new SportsStuff();
		try{
		sportsStuff.prepareFromCSV("hello");
		}catch (Exception e)
		{
			System.out.println ("Help");
		}
	}
	
	public void prepareFromCSV(String fileName) throws Exception
	{
		ArrayList<String> strings=HelperMethods.convertCSVToStringList("teams2.csv");
		String ID="";
		SportsYear sportsYear;
		TeamSeason teamSeason;
		
		String name;
		int year;
		String cityName=new String();
		String stateName= new String();
		PersonList personList= new PersonList();
		
		for (int i=0; i<strings.size(); i++)
		{
			try
			{
			String line= strings.get(i);
			String[] seasonParts = line.split(";");
			year=Integer.parseInt(seasonParts[0].trim());
			name=seasonParts[1].trim();
			cityName=seasonParts[2].trim();
			stateName=seasonParts[3].trim();
			personList	= new PersonList();
			for(int j = 4; j<seasonParts.length;j++)
			{
		//		Person person	= Person.convertStringToPerson(seasonParts[j], DateFormatter.formatter);
		//		personList.addPerson(person);
			}
			
			sportsYear=findOrAddSportsYearFromInt(year);
			teamSeason=new TeamSeason(name, ID, sportsYear);
			
			}
			catch (Exception e)
			{
				try
				{
					String tempString= strings.get(i).trim();
					ID=tempString.substring(0, tempString.length()-1);
				}catch (Exception f)
				{
					System.out.println("Parsing error in SportsStuff");
				}
			}

		}
	}
	
	public SportsYear findOrAddSportsYearFromInt(int i)
	{
		if (sportsYears.get(new Integer(i))==null)
		{
			SportsYear sy=new SportsYear(i);
			sportsYears.put(new Integer(i), sy);
			return sy;
		}
		else
			return sportsYears.get(new Integer(i));
	}
	
	public ArrayList<TeamSeason> getTeamSeasons()
	{
		return teamSeasons;
	}
	
}
