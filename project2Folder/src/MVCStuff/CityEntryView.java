package MVCStuff;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import countryComponents.State;

/**
 *The view for entering a city.
 */
public class CityEntryView extends View {
	
	/**
	 * The field in which a user will enter the name of the city to be created
	 */
	JTextField cityEntryJTextField=new JTextField();
	
	/**
	 * The field for entering the latitudinal coordinate of this city
	 */
	JTextField latitudeEntryJTextField=new JTextField();
	
	/**
	 * The field for entering the longitudinal coordinate of this city
	 */
	JTextField longitudeEntryJTextField=new JTextField();
	
	/**
	 * The button used to combine the fields into a new city and add it to the database
	 */
	JButton enterButton = new JButton("Enter");
	
	/**
	 * Constructor for CityEntryView. The created City will be in the State provided.
	 * @param state
	 */
	public CityEntryView(State state)
	{
		super();
		setLayout(new GridBagLayout());
		GridBagConstraints constraints=new GridBagConstraints();
		constraints.fill=GridBagConstraints.HORIZONTAL;
		constraints.gridy=0;
		constraints.gridx=0;
		add(new JLabel("Enter the city name, latitude, and longitude below, then press the \"enter\" button"), constraints);
		constraints.gridy=1;
		constraints.gridx=0;
		add(new JLabel("City Name"), constraints);
		constraints.gridx=1;
		add(new JLabel("Latitude"), constraints);
		constraints.gridx=2;
		add(new JLabel("Longitude"), constraints);
		constraints.gridy=2;
		constraints.gridx=0;
		add(cityEntryJTextField, constraints);
		constraints.gridx=1;
		add(latitudeEntryJTextField, constraints);
		constraints.gridx=2;
		add(longitudeEntryJTextField, constraints);
		constraints.gridy=3;
		add(enterButton, constraints);
	}
	
	
	/**
	 * Retrieves the Enter Button from this view
	 * @return the Enter Button
	 */
	public JButton getEnterButton()
	{
		return enterButton;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Do nothing. No need to update here.	
	}
	
}
