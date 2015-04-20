package MVCStuff;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
		this.add(new JLabel("Birth Date", SwingConstants.CENTER), constraints);
		constraints.gridx=2;
		this.add(new JLabel("Birth Place", SwingConstants.CENTER), constraints);
		constraints.gridx=3;
		this.add(new JLabel("Death Date", SwingConstants.CENTER), constraints);
		
		//Adds the text fields
		constraints.gridy=1;
		constraints.gridx=0;
		this.add(personName, constraints);
		constraints.gridx=1;
		this.add(birthDate, constraints);
		constraints.gridx=2;
		this.add(birthPlace, constraints);
		constraints.gridx=3;
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
	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO	
	}
	
}
