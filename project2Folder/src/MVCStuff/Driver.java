package MVCStuff;

import java.util.ArrayList;

/**
 *The driver for the program
 */
public class Driver {
	/**
	 * The country from which the rest of the classes will derive their information from
	 */
	private CountryModel model=new CountryModel();
	
	/**
	 * The first view to show up.
	 */
	private SelectionView selectionView=new SelectionView();
	
	/**
	 * The view for selecting states when adding places or people
	 */
	private StateSelectionView stateSelectionView=new StateSelectionView();
	
	/**
	 * The controller
	 */
	private TeamMateController controller= new TeamMateController();
	
	/**
	 * Constructor method for driver. Views and models should be set for controllers here, and models should be set for views here.
	 */
	public Driver()
	{
		selectionView.setModel(model);
		stateSelectionView.setModel(model);
		controller.setModel(model);
		controller.setSelectionView(selectionView);
		controller.setStateSelectionView(stateSelectionView);
	}
	
	/**
	 * The main method
	 * @param args The program arguments
	 */
	public static void main (String[] args)
	{
		new Driver();
	}
	

}
