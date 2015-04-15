package MVCStuff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import countryComponents.Country;
import countryComponents.DateFormatter;
import countryComponents.Person;
import countryComponents.State;
import countryComponents.Team;

public class CountryModel extends Country {
	
	/**
	 * The Views to be held by this model
	 */
	private ArrayList<View> views= new ArrayList<View>();
	/**
	 * Constructor
	 */
	public CountryModel()
	{
		super();
		//Prepares the 51 States of United States of America (DC is counted as a state)
		try
		{
			prepareStatesFromTextFile("states.txt");
			}catch (Exception e){
			System.out.println("The program had trouble with using the file states.txt,or states.txt does not exist in an accessible path");
		}
		
		
		//TODO CountryModel constructor
	}
	
	//Adder methods
	
	/**
	 * Adds a View to this model
	 * @param view The View to be added
	 */
	public synchronized void addActionListener (View view)
	{
		views.add(view);
	}
	
	/**
	 * Method for adding a person. Places them in State/City based on their attributes
	 * @param person The person to be added
	 */
	public void addPerson(Person person)
	{
		super.addPerson(person);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, Constants.PERSON_ADDED));
	}
	
	/**
	 * Method for adding a person without triggering an ActionEvent.
	 * @param aPerson The person to be added
	 */
	private void addPersonWithoutTriggeringEvent(Person aPerson)
	{
		super.addPerson(aPerson);
	}
	
	/**
	 * Builds a country from personStrings
	 * @param personStrings The strings from which the Person objects will be constructed
	 * @param country The Country to which the PersonList created from the personStrings will be added
	 * @return The error messages encountered during this
	 */
	public String addStringList(ArrayList<String> personStrings)
	{
		String errors="";
		for (String personString: personStrings)
		{
			try
			{
				Person aPerson=Person.convertStringToPerson(personString, DateFormatter.formatter);
				this.addPersonWithoutTriggeringEvent(aPerson);
			}
			catch (Exception e)
			{
				errors+=(e.getMessage()+"\n");
			}
		}
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, Constants.PERSON_ADDED));
		return errors;
	}
	
	/**
	 * Method for adding a team
	 * @param team The Team to be added
	 */
	@Override
	public void addTeam (Team team)
	{
		super.addTeam(team);
		
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, Constants.TEAM_ADDED));
		
		//TODO addTeam method
	}
	
	public void addTeams(ArrayList<Team> teams)
	{
		super.addTeams(teams);	
	}
	/**
	 * Method for adding a State
	 * @param state The State to be added
	 */
	public void addState(State state)
	{
		super.addState(state);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, Constants.STATE_ADDED));
		//TODO addState method in CountryModel
	}
	
	/**
	 * Finds and returns a <code>State</code> matching the <code>name</code>
	 * @param name The name of the State to be found
	 * @return The State that was found
	 */
	public State findStateOrAdd(String name)
	{
		State foundState=super.findStateOrAdd(name);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, Constants.STATE_ADDED));
		return foundState;
	}
	

	
	
	/**
	 * Removes a view from this model
	 * @param view The View to be removed
	 */
	public synchronized void removeActionListener(View view)
	{
		//TODO removeActionListener method from TeamMateModel method
	}
	
	
	/**
	 * Processes an ActionEvent
	 * @param e the actionEvent to be added
	 */
	private void processEvent(ActionEvent e)
	{
		ArrayList<View> list;

		synchronized (this) {
			if (views == null) return;
			list = (ArrayList<View>)views.clone();
		}

		for (int i = 0; i < list.size(); i++) {
			View view = list.get(i);
			view.actionPerformed(e);
		}
	}
	
	
	/**
	 * Prepares some states for this country from a file specified by the parameter
	 * @param fileName The name of the file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void prepareStatesFromTextFile(String fileName) throws FileNotFoundException, IOException
	{
	BufferedReader bufferedReader=new BufferedReader(new FileReader("states.txt"));
	for (int i=0; i<51; i++)
	{
		this.addState(new State(bufferedReader.readLine()));
	}
	bufferedReader.close();	
	}
	

}
