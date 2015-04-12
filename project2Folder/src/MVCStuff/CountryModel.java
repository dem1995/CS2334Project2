package MVCStuff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import project4.Country;
import project4.Person;
import project4.State;
import project4.Team;

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
		//TODO CountryModel constructor
	}
	
	/**
	 * Adds a View to this model
	 * @param view The View to be added
	 */
	public synchronized void addView (View view)
	{
		views.add(view);
	}
	
	/**
	 * Method for adding a team
	 * @param team The Team to be added
	 */
	@Override
	public void addTeam (Team team)
	{
		super.addTeam(team);
		
		//TODO addTeam method
	}
	
	/**
	 * Method for adding a State
	 * @param state The State to be added
	 */
	public void addState(State state)
	{
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
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "state added"));
		return foundState;
	}
	
	/**
	 * Method for adding a person. Places them in State/City based on their attributes
	 * @param person The person to be added
	 */
	public void addPerson(Person person)
	{
		super.addPerson(person);
		//TODO addPerson method
	}
	
	
	/**
	 * Removes a view from this model
	 * @param view The View to be removed
	 */
	public synchronized void removeView(View view)
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
	
	

}
