package project2;

import java.io.BufferedReader;
import java.io.FileReader;
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
 */
public class PeoplAce {

	/**
	 *Allows users to search through data on people and places.
	 * @param args Doesn't/don't do anything for this program
	 */
	/**
	 * Provides a formatter for changing String objects of the format dd/MM/yyyyy into Date objects
	 */
	public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyyy");
	
	/**
	 * Client for reading in a CSV file of people and searching them
	 * @param args Contains the file name
	 */
	public static void main(String[] args) {
		
		ArrayList<String> personStrings= new ArrayList<String>(); // The raw data of the people
		PersonList personList= new PersonList(); // The collection of people
		String errors=""; // When exceptions are caught, they add info to this String. This String is then output as a JMessageDialog to the user.
		Scanner reader = new Scanner(System.in);
		
		
		System.out.println("Enter the fileName");
		String fileName=reader.nextLine();
		
		//Attempts to convert the CSV file to an ArrayList of Strings and store that in personStrings
		try
		{
			personStrings = convertCSVToStringList(fileName);
		}catch (IOException e)
		{
			errors+="There was a problem reading in the CSV file, or the file was not found"+"\n";
		}
		//Attempts to convert the ArrayList<String> personStrings to Person objects and add them to personCollection
		for (String personString: personStrings)
		{
			try{
				Person person=convertStringToPerson(personString, formatter);
				personList.addPerson(person);
			}catch (Exception e)
			{
				errors+=(e.getMessage()+"\n");
			}
		}
		System.out.println(personList);
		
		//Outputs the errors to the screen as a JMessageDialog if errors has had data added to it since the beginning
		if (!errors.equals(""))
		System.out.println("Errors: "+errors);
		reader.close();
		System.out.println(PersonList.firstNameComparator.getClass().getSimpleName());
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
		String[] names=personParts[0].split(" ");
		String firstName="";
		String middleNames="";
		String lastName="";
		for (int i=0; i<names.length; i++)
		{
			if (i==0)
				firstName=names[i];
			else if (i<names.length-2)
				middleNames+=(names[i]+" ");
			else if (i==names.length-2)
				middleNames+=(names[i]);
			else if (i==names.length-1)
				lastName=names[i];
		}	
		
		if (personParts.length<4||personParts.length>5)
			throw new Exception("\""+personString+"\""+"had too many/too few parts separated by commas");
		
		try
		{
		if (personParts.length==4) //Tests to see if person has a deathDate. True if false.
			aPerson=new Person(firstName, middleNames, lastName, formatter.parse(personParts[1]));
		else if (personParts.length==5) //Tests to see if person has a deathDate. True if true
			aPerson=new Person(firstName, middleNames, lastName, formatter.parse(personParts[1]));
		}
			catch (ParseException e)
		{throw new Exception("\""+personString+"\""+ "'s parts separated by commas were in the wrong formats");}
		
		return aPerson;	
	}
	
}

