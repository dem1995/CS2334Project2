package otherClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HelperMethods {
	
	/**
	 * Method for converting a CSV file to a list of String objects in the form "Name, birthDate, birthCity, birthState" or "Name, birthDate, birthCity, birthState"
	 * @param fileName name of the CSV file to grab text from
	 * @return an ArrayList of the Strings, each of which was a line of the CSV file
	 * @throws Exception an exception
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

}
