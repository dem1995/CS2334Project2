package MVCStuff;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import countryComponents.City;

public class AddPersonView extends View {
	
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
	 */
	public AddPersonView(City city)
	{
		//TODO
		super();
		this.setLayout(new GridLayout(2,4));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO	
	}
	
}
