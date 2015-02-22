package project2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
		PersonList personCollection= new PersonList(); // The collection of people
		boolean exit=false; // Boolean that lets the program know when to exit the last method
		String errors=""; // When exceptions are caught, they add info to this String. This String is then output as a JMessageDialog to the user.
		Scanner reader = new Scanner(System.in);
		
		//Attempts to convert the CSV file to an ArrayList of Strings and store that in personStrings
		try
		{
			personStrings = convertCSVToStringList(args[0]);
		}catch (IOException e)
		{
			errors+="There was a problem reading in the CSV file, or the file was not found"+"\n";
		}
		
		//Attempts to convert the ArrayList<String> personStrings to Person objects and add them to personCollection
		for (String personString: personStrings)
		{
			try{
				Person person=convertStringToPerson(personString, formatter);
				personCollection.addPerson(person);
			}catch (Exception e)
			{
				errors+=(e.getMessage()+"\n");
			}
		}
		
		//Outputs the errors to the screen as a JMessageDialog if errors has had data added to it since the beginning
		if (!errors.equals(""))
		messageOutput(errors, "Errors found");
		
		//Loops through and allows the user to enter a String, then outputs any Person objects in personCollection with a name containing that string to the screen
		while (!exit)
		{
			String userInput=(String)JOptionPane.showInputDialog(null, "Enter the name or part of the name of the person that you wish to search for, or press \"cancel\" to quit", "searching for name", JOptionPane.PLAIN_MESSAGE);
			if (userInput!=null)
			{	
				PersonList temp=personCollection.partialSearchNamesFor(userInput);
				//temp.sort();
				messageOutput(temp.toString(), "Search Results");
			}
			else
				exit=true;
		}
		reader.close();
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
		
		if (personParts.length<4||personParts.length>5)
			throw new Exception("\""+personString+"\""+"had too many/too few parts separated by commas");
		
		try
		{
		if (personParts.length==4)
			aPerson=new Person(names[0], names[names.length], formatter.parse(personParts[1]));
		else if (personParts.length==5)
			aPerson=new Person(names[0], names[names.length], formatter.parse(personParts[1]));
		}
			catch (ParseException e)
		{throw new Exception("\""+personString+"\""+ "'s parts separated by commas were in the wrong formats");}
		
		return aPerson;	
	}
	
	/**
	 * Convenience method for taking care of setting up a JScrollPane in a JOptionPane
	 * @param output The string to be put into the JScrollPane to be placed into a JOptionPane
	 * @param windowTitle The title of the window
	 */
	public static void messageOutput(String output, String windowTitle)
	{
		JTextArea jTextArea=new JTextArea(output);
		JScrollPane jScrollPane=new JScrollPane(jTextArea);
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension preferredDialogSize=new Dimension((int)screenSize.getWidth()/2, (int)screenSize.getHeight()/2);
		jScrollPane.setPreferredSize(preferredDialogSize);
		JOptionPane.showMessageDialog(null, jScrollPane, windowTitle, JOptionPane.PLAIN_MESSAGE);
	}
	
}


