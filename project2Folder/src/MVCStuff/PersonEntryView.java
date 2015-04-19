package MVCStuff;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import countryComponents.City;

public class PersonEntryView extends View {
	
	/**
	 * The button for entering a created person into the database.
	 */
	private JButton enterButton= new JButton();
	
	JTextField personName= new JTextField();
	
	JTextField birthDate = new JTextField();
	
	JTextField birthPlace= new JTextField();
	
	JTextField deathDate = new JTextField();
	
	/**
	 * Constructor for PieChartView. Takes in a city to add the person to. 
	 * @param city The city to add the person to.
	 */
	public PersonEntryView(City city)
	{
		//TODO
		super();
		this.setLayout(new GridLayout(2,4));
		
		//Adds titles to the columns in the first row
		this.add(new JLabel("Person Name", SwingConstants.CENTER));
		this.add(new JLabel("Birth Date", SwingConstants.CENTER));
		this.add(new JLabel("Birth Place", SwingConstants.CENTER));
		this.add(new JLabel("Death Date", SwingConstants.CENTER));
		
		//Adds the text fields
		this.add(personName);
		this.add(birthDate);
		this.add(birthPlace);
		this.add(deathDate);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO	
	}
	
}
