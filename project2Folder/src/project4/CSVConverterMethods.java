package project4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;

public class CSVConverterMethods {

	/**
	 * Static CustomBufferedReader to be used by all methods
	 * */
	private static CustomBufferedReader reader = new CustomBufferedReader();

	/**
	 * Provides a formatter for changing String objects of the format dd/MM/yyyyy into Date objects
	 */
	public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyyy");

	/**
	 * Errors accumulated during the project
	 */
	public static String errors="";

	/**
	 * Results of searching/sorting
	 */
	public static String results="";

	/**
	 *Allows users to search through data on people and places.
	 * @param args Doesn't/don't do anything for this program
	 */
	public static void main(String[] args) {

		ArrayList<String> personStrings= new ArrayList<String>(); // The raw data of the people
		boolean	continueLoop=true;	
		Country country= new Country();
		//Welcomes the user
		System.out.println("Hello! Welcome to TeamMate! You may enter \"quit\" at any time to");

		//Attempts to convert the CSV file to an ArrayList of Strings and store that in personStrings
		while (continueLoop)
		{
			System.out.println("Enter the fileName that has the names of the players and their birthdates");
			String fileName=reader.readLine();
			try
			{
				if (fileName.length() == 0)
				{
					System.out.println("You did not enter a FileName");
				}
				else
				{
					personStrings = convertCSVToStringList(fileName);
					addStringListToCountry(personStrings, country);
					continueLoop=false;
				}
			}
			catch (Exception e)
			{
				if(fileName=="exit")
					System.exit(0);
				System.out.println(e.getMessage());
				System.out.println("There was a problem reading in the CSV file, or the file was not found");
				continueLoop=true;
			}
		}
		continueLoop = true;
		while (continueLoop)
		{
			System.out.println("Enter the fileName that has the names of the teams and the members of each");
			String fileName=reader.readLine();
			try
			{
				if (fileName.length() == 0)
				{
					System.out.println("You did not enter a FileName");
				}
				else
				{
					ArrayList<Team> teamList=new ArrayList<Team>();
					teamList=convertStringListToArrayListOfTeams(convertCSVToStringList(fileName));
//					for (int i=0; i<teamList.size(); i++)
//					{
//						for (int j=0; j<teamList.get(i).getTeamMembers().getPeople().size(); j++)
//							try{
//							teamList.get(i).getTeamMembers().getPeople().set(j,country.findPerson(teamList.get(i).getTeamMembers().getPeople().get(j).getFullName()));
//							}
//						catch (Exception e)
//						{};
//					}
					country.addTeams(teamList);
					continueLoop=false;
				}
			}
			catch (Exception e)
			{
				if(fileName=="exit")
					System.exit(0);
				System.out.println("There was a problem reading in the CSV file, or the file was not found");
				continueLoop=true;
			}
		}
		continueLoop = true;
		while (continueLoop)
		{
		System.out.println("Enter the fileName that has the name of the cities and the longitude and the latitude");
		String fileName=reader.readLine();
			if (fileName.length() == 0)
			{
				System.out.println("You did not enter a FileName");
			}
			else
			{
				try
					{
				convertToCSV(fileName);
					}
				catch (Exception e)
				{
					if(fileName=="exit")
						System.exit(0);
					errors+=e.getStackTrace()+"/n";
				}
				continueLoop=false;
			}
		}

		country.sort();
		//System.out.println(country);
		//Outputs the errors to the screen as a JMessageDialog if errors has had data added to it since the beginning
		if (!errors.equals(""))
			System.out.println("Errors: "+errors);
		errors="";
		promptUser(country);
		System.exit(0);

	}

	/**
	 * Method for converting a CSV file to a list of String objects in the form "Name, birthDate, birthCity, birthState" or "Name, birthDate, birthCity, birthState"
	 * @param fileName name of the CSV file to grab text from
	 * @return an ArrayList of the Strings, each of which was a line of the CSV file
	 * @throws Exception 
	 * @throws IOException due to use of BufferedReader
	 */
	public static ArrayList<String> convertCSVToStringList(String fileName) throws Exception
	{
		ArrayList<String> stringList = new ArrayList<String>();
		BufferedReader br=new BufferedReader(new FileReader(fileName));
		for (String lineOfCSV=""; lineOfCSV!=(null); lineOfCSV=br.readLine())
		{
			if(lineOfCSV!="")
			stringList.add(lineOfCSV);
		}
		br.close();
		if (stringList.isEmpty())
			{
			throw new Exception("CSV File was empty");
			}
		return stringList;
	}
	
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
	/**
	 * Method for converting a String in the form of "Name, birthDate, birthCity, birthState" or ""Name, birthDate, birthCity, birthState" containing Person data to a Person object
	 * @param personString Sting representing a person object's data
	 * @param formatter Formats the date data
	 * @return a Person object generated from the personString input
	 * @throws Exception throws an exception if this method receives invalid input
	 */
	public static Person convertStringToPerson(String personString, SimpleDateFormat formatter) throws Exception
	{
		Person aPerson=null;
		String[] personParts = personString.split(",");
		String fullName=personParts[0];

		if (personParts.length<4||personParts.length>5)
			throw new Exception("\""+personString+"\""+"had too many/too few parts separated by commas");

		try
		{
			if (personParts[1].contains("/")) //Tests to see if person has a BirthDate. Runs if true.
			{
				aPerson=new Person(fullName, formatter.parse(personParts[1]));
				aPerson.setCityName(personParts[2]);
				aPerson.setStateName(personParts[3]);
				if(personParts.length == 5)
				{
					if(personParts[4].contains("/"))
					{
						aPerson.setDeathDate(formatter.parse(personParts[4]));
					}
				}
				
			}
			else if (!personParts[1].contains("/")) //Tests to see if person has a BirthDate. Runs if false.
			{
				aPerson=new Person(fullName, null);
				aPerson.setCityName(personParts[1]);
				aPerson.setStateName(personParts[2]);
				if(personParts.length == 4)
				{
					if(personParts[3].contains("/"))
					{
						aPerson.setDeathDate(formatter.parse(personParts[4]));
					}
				}
			}
		}
		catch (ParseException e)
		{throw new Exception("\""+personString+"\""+ "'s parts separated by commas were in the wrong formats");}

		return aPerson;	
	}
	
	/**
	 * Builds a country from personStrings
	 * @param personStrings The strings from which the Person objects will be constructed
	 * @param country The Country to which the PersonList created from the personStrings will be added
	 */
	public static void addStringListToCountry(ArrayList<String> personStrings, Country country)
	{
		for (String personString: personStrings)
		{
			try
			{
				Person aPerson=convertStringToPerson(personString, formatter);
				country.addPerson(aPerson);
			}
			catch (Exception e)
			{
				errors+=(e.getMessage()+"\n");
			}
		}
	}
	
	/**
	 * Converts an ArrayList of Strings to an ArrayList of Teams
	 * @param teamStrings The ArrayList of Strings from which to form the ArrayList of Teams
	 * @return ArrayList of Teams formed from the ArrayList of Strings
	 */
	public static ArrayList<Team> convertStringListToArrayListOfTeams(ArrayList<String> teamStrings)
	{
		ArrayList<Team> arrayListOfTeams=new ArrayList<Team>();
		for (String teamString: teamStrings)
			arrayListOfTeams.add(convertStringToTeam(teamString));
		return arrayListOfTeams;
	}

	/**
	 * 
	 * @param fileName 
	 * @throws Exception
	 * 
	 */
	public static void convertToCSV(String fileName) throws Exception
	{
		Country country = new Country();
		ArrayList<String> stringList = new ArrayList<String>();
		BufferedReader br=new BufferedReader(new FileReader(fileName));
		for (String lineOfCSV=""; lineOfCSV!=(null); lineOfCSV=br.readLine())
		{
			stringList.add(lineOfCSV);
		}
		br.close();
		for(int i=0; i < stringList.size();i++)
		{
			String[] fileParts = stringList.get(i).split(";");
			((country.findStateOrAdd(fileParts[1])).findCityOrAdd(fileParts[0])).setLatitude(Integer.parseInt(fileParts[2]));
			((country.findStateOrAdd(fileParts[1])).findCityOrAdd(fileParts[0])).setLatitude(Integer.parseInt(fileParts[3]));
		}
	}

	/**
	 * @param country The country that contains the lists of people with which we're doing stuff
	 */
	public static void promptUser(Country country)
	{
		String answer="";


		while(!answer.equalsIgnoreCase("quit"))
		{
			errors="";
			results="";
			PersonList results=new PersonList();
			String teamName="";
			System.out.println("People, Place, or Team?");
			answer = reader.readLine();
			
			if(answer.equalsIgnoreCase("Team"))
			{
//If the user wants to search for a team
				Team teamFound=null;
				System.out.println("What's the name of the team?");
				answer = reader.readLine();
				try{
					teamFound=country.findTeam(answer);
				}
				catch(Exception e)
				{
					System.out.println("Team not found");
				}
				if(teamFound!=null)
				{
					teamName=teamFound.getTeamName();
					results = teamFound.getTeamMembers();
				}
			}
			else if(answer.equalsIgnoreCase("People"))
//If they chose people
			{
				System.out.println("Sort or Search?");
				answer = reader.readLine();
				if(answer.equalsIgnoreCase("Sort"))
//If they're sorting people
				{
					System.out.println("First or Last?");
					answer = reader.readLine();
					if(answer.equalsIgnoreCase("First"))
					{
//If they want it by first name
						results=(country.toPersonList().returnAfterSortingUsing(PersonList.middleNamesComparator).returnAfterSortingUsing(PersonList.lastNameComparator).returnAfterSortingUsing(PersonList.firstNameComparator));
					}
					else if(answer.equalsIgnoreCase("Last"))
//If they want it by last name
					{
						results=(country.toPersonList().returnAfterSortingUsing(PersonList.middleNamesComparator).returnAfterSortingUsing(PersonList.firstNameComparator).returnAfterSortingUsing(PersonList.lastNameComparator));

					}
					else
					{
//If they entered something incorrectly
						System.out.println("You did not enter 'First' or 'Last'");
						System.out.println("Please input one or the other");

					}
				}
				else if(answer.equalsIgnoreCase("Search"))
				{
//If they're searching people
					System.out.println("Exact ot Partial?");
					answer = reader.readLine();
					if(answer.equalsIgnoreCase("Exact"))
					{
//If they're exact in they're searching
						System.out.println("Enter the name of the person you're searching for");
						answer=reader.readLine();
						results=(country.toPersonList().returnAfterSortingUsing(null).exactSearchFor(answer, null));
					}
					else if(answer.equalsIgnoreCase("Partial"))
					{
//If they're searching for partial matches
						System.out.println("Enter the name of the person you're searching for");
						answer=reader.readLine();
						results=(country.toPersonList().partialSearchNamesFor(answer));
					}
					else
					{
//If thye didn't input exact or partial
						System.out.println("You did not enter 'Exact' or 'Partial'");
						System.out.println("Please input one or the other");
					}
				}
				else
				{
//If, when choosing what to do with people, they accidentally didn't choose sort or search
					System.out.println("You did not enter 'Sort' or 'Search'");
					System.out.println("Please input one or the other");

				}
			}
			else if(answer.equalsIgnoreCase("Place"))
			{
//If they're going by place
				State stateSearchedFor=null;
				System.out.println("State or City?");
				answer = reader.readLine();
				if(answer.equalsIgnoreCase("State")||answer.equalsIgnoreCase("City"))
				{
					System.out.println("Enter the two-letter abbreviation of the State you're searching for");
					stateSearchedFor=country.findState(reader.readLine());
				}
				if (stateSearchedFor!=null)
				{
					if(answer.equalsIgnoreCase("State"))
					{
//If they're searching by state
						for(City c: stateSearchedFor.getCities())
						{
							results.combineWith(c.getPersonList());
						}
					}
					else if(answer.equalsIgnoreCase("City"))
					{
//If they're searching by city
						System.out.println("Enter the city name");
						City citySearchedFor=stateSearchedFor.findCity(reader.readLine());
						if(citySearchedFor!=null)
							results=citySearchedFor.getPersonList();
						else
							errors+="Failed to find city";
					}
					else
					{
//If, when choosing the geographic scope, they accidentally didn't choose state or city
						System.out.println("you did not enter 'State' or 'City'");
						System.out.println("please input one or the other");

					}
				}
				else
				{
//If the state was not found
					errors+="Failed To Find State";
				}
			}
			else
			{
				System.out.println("You did not enter 'People' or 'Place'");
				System.out.println("Please input one or the other");

			}
//Runs if the user entered quit
			if (answer.equalsIgnoreCase("quit"))
				System.out.println("You have quit the program");
			else if (!errors.equals(""))
				System.out.println(errors);
			else if ((""+results).equals("null"))
				System.out.println("Nothing was returned from your search");
			else if (results.toString().equals(""))
				System.out.println("Nothing was returned from your search");
			else
			{
				String q=results.toString();
				System.out.println(q);
				System.out.println("Would you like to save this to a file? Enter y/n");
				answer=reader.readLine();
				if(answer.contains("y")||answer.contains("Y"))
//Runs if user wants to save file
				{
					try{
						FileWriter outfile = new FileWriter("output.txt");
						BufferedWriter bw = new BufferedWriter(outfile);
						bw.write(teamName);
						bw.newLine();
						bw.write(results.toString());
						bw.newLine();
						bw.close();
					}
					catch(IOException e)
					{
						System.out.println("Failed to print to a file");
					}

				}
				else if (answer.equalsIgnoreCase("quit"))
					System.out.println("You have quit the program");
			}
			System.out.println("Graph, continue, or exit?");
			answer = reader.readLine();
			
			if(answer.equalsIgnoreCase("Graph"))
			{
//If the user wants to graph
				Pie pie = null;
				try
				{
					Team aTeam=new Team();
					aTeam.setTeamName(teamName);
					aTeam.setTeamMembers(results);
				pie= new Pie(aTeam);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				//Sets up JFrame
				JFrame jFrame=new JFrame();
				//Adds the pie chart of ages to it
				jFrame.add(pie);
				jFrame.pack();
				jFrame.setVisible(true);
			}
			else if(answer.equalsIgnoreCase("exit"))
			{
//If the user wants to quit
				answer = "quit";
				System.out.println("You have quit the program");
			}
		}
	}

}


