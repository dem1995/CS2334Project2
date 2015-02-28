package project2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Project #2
 * CS 2334, Section 010
 * Feb 18, 2015
 * <p>
 * A class for searching through data on people and places
 * </p>
 * @version 1.0
 *
 */
public class PeoplAce {
	
	/**
	 * Static CustomBufferedReader to be used by all methods
	 * */
	static CustomBufferedReader reader = new CustomBufferedReader();
	
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
		
		

					
		//Attempts to convert the CSV file to an ArrayList of Strings and store that in personStrings
		while (continueLoop)
		{
			System.out.println("Enter the fileName");
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
					continueLoop=false;
				}
			}
			catch (IOException e)
			{
				System.out.println("There was a problem reading in the CSV file, or the file was not found");
				continueLoop=true;
			}
		}
		//Attempts to convert the ArrayList<String> personStrings to a Country object
		country=convertStringListToCountry(personStrings);
		country.sort();
		System.out.println(country);
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
	 * @throws IOException due to use of BufferedReader
	 */
	public static ArrayList<String> convertCSVToStringList(String fileName) throws IOException
	{
			ArrayList<String> stringList = new ArrayList<String>();
			BufferedReader br=new BufferedReader(new FileReader(fileName));
			for (String lineOfCSV=""; lineOfCSV!=(null); lineOfCSV=br.readLine())
			{
				stringList.add(lineOfCSV);
			}
			br.close();
		return stringList;
	}
	
	/**
	 * Builds a country from personStrings
	 * @param personStrings
	 * @return A country made from the arrayList of personStrings
	 */
	public static Country convertStringListToCountry(ArrayList<String> personStrings)
	{
		Country country=new Country();
		for (String personString: personStrings)
		{
			try
			{
				Person aPerson=convertStringToPerson(personString, formatter);
				country.findStateOrAdd(aPerson.getStateName()).findCityOrAdd(aPerson.getCityName()).getPersonList().addPerson(aPerson);
			}
			catch (Exception e)
			{
				errors+=(e.getMessage()+"\n");
			}
		}
		return country;
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
			}
			else if (!personParts[1].contains("/")) //Tests to see if person has a BirthDate. Runs if false.
			{
				aPerson=new Person(fullName, null);
				aPerson.setCityName(personParts[1]);
				aPerson.setStateName(personParts[2]);
			}
		}
			catch (ParseException e)
		{throw new Exception("\""+personString+"\""+ "'s parts separated by commas were in the wrong formats");}
		
		return aPerson;	
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
		System.out.println("People or Place?");
		answer = reader.readLine();
			if(answer.equalsIgnoreCase("People"))
			{
				System.out.println("Sort or Search?");
				answer = reader.readLine();
				if(answer.equalsIgnoreCase("Sort"))
				{
					System.out.println("First or Last?");
					answer = reader.readLine();
					if(answer.equalsIgnoreCase("First"))
					{
						results=(country.toPersonList().returnAfterSortingUsing(PersonList.firstNameComparator));
					}
					else if(answer.equalsIgnoreCase("Last"))
					{
						results=(country.toPersonList().returnAfterSortingUsing(PersonList.lastNameComparator));

					}
					else
					{
						System.out.println("You did not enter 'First' or 'Last'");
						System.out.println("Please input one or the other");

					}
				}
				else if(answer.equalsIgnoreCase("Search"))
				{
					System.out.println("Exact ot Partial?");
					answer = reader.readLine();
					if(answer.equalsIgnoreCase("Exact"))
					{
						System.out.println("Enter the name of the person you're searching for");
						answer=reader.readLine();
						results=(country.toPersonList().returnAfterSortingUsing(null).exactSearchFor(answer, null));
					}
					else if(answer.equalsIgnoreCase("Partial"))
					{
						System.out.println("Enter the name of the person you're searching for");
						answer=reader.readLine();
						results=(country.toPersonList().partialSearchNamesFor(answer));
					}
					else
					{
						System.out.println("You did not enter 'Exact' or 'Partial'");
						System.out.println("Please input one or the other");
					}
				}
				else
				{
					System.out.println("You did not enter 'Sort' or 'Search'");
					System.out.println("Please input one or the other");

				}
			}
			else if(answer.equalsIgnoreCase("Place"))
			{
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
						for(City c: stateSearchedFor.getCities())
						{
							results.combineWith(c.getPersonList());
						}
					}
					else if(answer.equalsIgnoreCase("City"))
					{
						System.out.println("Enter the city name");
						City citySearchedFor=stateSearchedFor.findCity(reader.readLine());
						if(citySearchedFor!=null)
							results=citySearchedFor.getPersonList();
						else
							errors+="Failed to find city";
					}
					else
					{
						System.out.println("you did not enter 'State' or 'City'");
						System.out.println("please input one or the other");

					}
				}
				else
				{
						errors+="Failed To Find State";
				}
			}
			else
			{
				System.out.println("You did not enter 'People' or 'Place'");
				System.out.println("Please input one or the other");

			}

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
			@SuppressWarnings("unused")
			String q=results.toString();
			System.out.println("Would you like to save this to a file? Enter y/n");
			answer=reader.readLine();
			if(answer.contains("y")||answer.contains("Y"))
			{
				try{
					FileWriter outfile = new FileWriter("output.txt");
					BufferedWriter bw = new BufferedWriter(outfile);
					bw.write("This is a test -- did it work?");
					bw.newLine();
					bw.close();
				}
				catch(IOException e)
				{
					System.out.println("Failed to print to a file");
				}

			}
		}
		}
	}
	
}


