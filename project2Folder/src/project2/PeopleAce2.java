package project2;

import java.util.ArrayList;
import java.util.Scanner;



/**
 * Project #2
 * CS 2334, Section 010
 * Feb 18, 2015
 * <p>
 * 
 * </p>
 * @version 1.0
 */

public class PeopleAce2 {
	/***
	 * 
	 */
	static Scanner reader = new Scanner(System.in);
	/**
	 * 
	 */
	private static Country country;
	/**
	 * 
	 */
	private static PersonList personList;
	/**
	 * 
	 */
	public PeopleAce2()
	{
		
	}
	/**
	 * 
	 */
	public PeopleAce2(Country c, PersonList pl, ArrayList<State> state)
	{
		country=c;
		personList=pl;
	}
	/**
	 * this method will prompt the user to input the information
	 * @return 
	 * */
	public static void promptUser()
	{
		boolean loop = true;
		String answer;

		while(loop) // will loop until told otherwise (until the exit prompt)
		{
			System.out.println("People or Place?");
			answer = reader.nextLine();
			if(answer.equalsIgnoreCase("People")) // people prompt tree
			{
				peopleFinder();
				loop = false;
			}
			else if(answer.equalsIgnoreCase("Place"))
			{
				placeFinder();
				loop = false;
			}
			else
			{
				System.out.println("you did not enter 'People' or 'Place'");
				System.out.println("please input one or the other");
			}
		}
	}
	/**
	 * this method is dedicated to the people prompt tree
	 * @param 
	 * @return 
	 * */
	static public void peopleFinder()
	{
		String answer;
		boolean loop = true;
		
		while(loop)
		{
			System.out.println("Sort of Search?");
			answer = reader.nextLine();
			if(answer.equalsIgnoreCase("Sort")) // sort prompt tree
			{
				sortPeople();
				loop = false;
			}
			else if(answer.equalsIgnoreCase("Search"))
			{
				searchPeople();
				loop = false;
			}
			else
			{
				System.out.println("you did not enter 'Sort' or 'Search'");
				System.out.println("please input one or the other");
			}
		}
	
	}
	/**
	 * this method is dedicated to the sort tree
	 * @return 
	 * */
	static public void sortPeople()
	{
		boolean loop = true;
		while(loop)
		{
			String answer;
			System.out.println("First or Last?");
			answer = reader.nextLine();
			if(answer.equalsIgnoreCase("First")) // sort by first name
			{
				personList.sortUsing(null);
				System.out.println(personList.toString());
				loop = false;
			}
			else if(answer.equalsIgnoreCase("Last")) // sort by last name
			{
				personList.sortUsing(PersonList.lastNameComparator);
				System.out.println(personList.toString());
				loop = false;
			}
			else
			{
				System.out.println("you did not enter 'First' or 'Last'");
				System.out.println("please input one or the other");
			}
		}
	}
	/**
	 * 
	 * */
	static public void searchPeople()
	{
		String input;
		PersonList output;
		String answer;
		boolean loop = true;

		while(loop)
		{
			System.out.println("Exact ot Partial?");
			answer = reader.nextLine();
			if(answer.equalsIgnoreCase("Exact"))
			{
				System.out.println("enter the exact full name of the person");
				input = reader.nextLine();
				output = personList.exactSearchFor(input, PersonList.firstNameComparator);
				if(output!=null)
				{
					System.out.println(output);
					loop = false;
				}
				else
				{
					System.out.println("the name you entered isn't in the database");
				}
			}
			else if(answer.equalsIgnoreCase("Partial"))
			{
				System.out.println("enter the part you want to search for");
				input = reader.nextLine();
				output = personList.partialSearchNamesFor(input);
				System.out.println(output);
				loop = false;
			}
			else
			{
				System.out.println("you did not enter 'Exact' or 'Partial'");
				System.out.println("please input one or the other");
			}
		}
	}
	/**
	 * @param 
	 * @param
	 * @return 
	 * */
	static public void placeFinder()
	{
		String answer;
		String input;
		State state;
		ArrayList<State> allStates = new ArrayList<State>(country.getStates());
		
		boolean loop = true;
		
		while(loop)
		{
			System.out.println("State or City?");
			answer = reader.nextLine();
			
			if(answer.equalsIgnoreCase("State"))
			{
				while(loop)
				{
					System.out.println("enter the abbreviation of the state you want to search for");
					input = reader.nextLine();
					state = country.findState(input);
					if(state!=null)
					{
						for(City eachCity: state.getCities())
						{
							System.out.println(eachCity.getName() + ":");
							System.out.println(eachCity.getPersonList());	
						}
						loop = false;
					}
					else
					{
						System.out.println("the state abbreviation you entered is incorrect");
					}
					
				}
			}
			else if(answer.equalsIgnoreCase("City"))
			{	
				ArrayList<City> eachCity;

				while(loop)

				{
					System.out.println("enter the city name");
					input = reader.nextLine();
					for(int i= 0;i<allStates.size();i++)
					{
						eachCity=allStates.get(i).getCities();

						for(int j= 0; j<allStates.get(i).getCities().size();j++)
						{
							if(eachCity.get(j) == allStates.get(i).findCity(input))
							{
								System.out.println(allStates.get(i).getName()+ ":\n");
								System.out.println(eachCity.get(j).getName() + ":");
								System.out.println(eachCity.get(j).getPersonList());	
								loop = false;
							}
						}
					}
					if(loop)
					{
						System.out.println("the city you are searching for isn't in the database");
					}
				}				
			}
			else
			{
				System.out.println("you did not enter 'State' or 'City'");
				System.out.println("please input one or the other");
			}
		}
	}
}