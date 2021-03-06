package MVCStuff;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
//import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import countryComponents.City;
import countryComponents.DateFormatter;
import countryComponents.Person;
//import countryComponents.State;

public class PersonEntryView extends View {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The button for entering a created person into the database.
	 */
	private JButton enterButton= new JButton();
	
	private City city;
	
	JTextField personName= new JTextField();
	
	JTextField birthDate = new JTextField();
	
	JTextField deathDate = new JTextField();
	
	/**
	 * Constructor for PieChartView. Takes in a city to add the person to. 
	 * @param city The city to add the person to.
	 */
	public PersonEntryView(City aCity)
	{
		//TODO
		super();
		this.city=aCity;
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraints=new GridBagConstraints();
		constraints.fill=GridBagConstraints.BOTH;
		constraints.weightx=1;
		constraints.weighty=1;
		
		//Adds titles to the columns in the first row
		constraints.gridy=0;
		constraints.gridx=0;
		this.add(new JLabel("Person Name", SwingConstants.CENTER), constraints);
		constraints.gridx=1;
		this.add(new JLabel("Birth Date, format: dd/mm/yyyy", SwingConstants.CENTER), constraints);
		constraints.gridx=2;
		this.add(new JLabel("Death Date, optional, format: dd/mm/yyyy", SwingConstants.CENTER), constraints);
		
		//Adds the text fields
		constraints.gridy=1;
		constraints.gridx=0;
		this.add(personName, constraints);
		constraints.gridx=1;
		this.add(birthDate, constraints);
		constraints.gridx=2;
		this.add(deathDate, constraints);
		
		//Adds the enter button
		constraints.gridy=2;
		constraints.gridx=0;
		constraints.gridwidth=GridBagConstraints.REMAINDER;
		this.add(enterButton, constraints);
	}
	
	public JButton getEnterButton()
	{
		return enterButton;
	}
	
	public Person getFullPerson() throws Exception
	{
		String nameText=personName.getText();
		String birthDateText=birthDate.getText();
		String deathDateText=deathDate.getText();
		Date birthDate= new Date();
		Date deathDate= new Date();
		//Person aPerson;
		
		try{
			birthDate=DateFormatter.formatter.parse(birthDateText);
		}catch (Exception e)
		{
			Exception f= new Exception("There was a problem with the format of the inputted birth date. Please try again.");
			throw f;
		}
		
		if (deathDateText.equals(""))
		{
			return new Person(nameText, birthDate);
		}
		else
		{
			try{
				deathDate= DateFormatter.formatter.parse(deathDateText);
			}catch (Exception e)
			{
				Exception f= new Exception("There was a problem with the format of the inputted death date. PLease try again");
				throw f;
			}
			return new Person(nameText, birthDate, deathDate);
		}
		
		
			
		
	}
	
	/**
	 * Returns the city the person is to be registered to
	 * @return The city that this person object will be put into
	 */
	public City getCity()
	{
		return city;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO	
	}
	
}
