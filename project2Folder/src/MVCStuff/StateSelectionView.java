package MVCStuff;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

import countryComponents.State;


/**
 * View for selecting the State to which to add a new City
 */
public class StateSelectionView extends View {
	
	/**
	 * The model for this view
	 */
	private CountryModel countryModel;
	
	/**
	 * A JList of the list of states in the CountryModel
	 */
	private JList<State> stateJList= new JList<State>();
	
	/**
	 * The button for choosing the selected state
	 */
	private JButton enterButton= new JButton("Enter");

	/**
	 * Constructor for PieChartView
	 */
	public StateSelectionView()
	{
		super();
	}
	
	public void setModel(CountryModel countryModel)
	{
		super.setModel(countryModel);
		this.countryModel=countryModel;
		setLayout(new GridLayout(2,1)); 
		stateJList= new JList<State>((State[]) countryModel.getStates().toArray(new State[0]));
		JScrollPane scrollableStates = new JScrollPane(stateJList);
		this.add(scrollableStates);
		this.add(enterButton);
		this.validate();
	}
	
	public JButton getEnterButton()
	{
		return enterButton;
	}
	
	public State getSelectedState()
	{
		return stateJList.getSelectedValue();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO	
	}
	
}
