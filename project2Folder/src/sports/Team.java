package sports;


import java.util.TreeMap;

public class Team {
	
	/**
	 * The ID of the team
	 */
	String ID;
	
	TreeMap<SportsYear, TeamSeason> seasons;

	public Team(String ID)
	{
	}
	
	void addSeason(TeamSeason teamSeason)
	{
		seasons.put(teamSeason.sportsYear, teamSeason);
	}
	
	
}
