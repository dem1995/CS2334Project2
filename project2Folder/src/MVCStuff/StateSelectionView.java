package MVCStuff;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JList;
import javax.swing.JScrollPane;

import countryComponents.State;


public class StateSelectionView extends View {
	
	private CountryModel countryModel;
	
	/**
	 * A JList of the list of states in the CountryModel
	 */
	JList<State> stateJList= new JList<State>();
	
	//State state1= new State("fredState");
	//State state2= new State("halState");
	//State[] statesTester= {state1, state2};
	//String[] strings= {"fred", "hal"};
	
	//JList<State> stateJList= new JList<State>(statesTester);

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
		stateJList= new JList<State>((State[]) countryModel.getStates().toArray(new State[0]));
		JScrollPane scrollableStates = new JScrollPane(stateJList);
		this.getContentPane().add(scrollableStates);
		this.validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO	
	}
	
}
