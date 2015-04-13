package MVCStuff;

import java.util.ArrayList;

/**
 *The driver for the program
 */
public class Driver {
	/**
	 * The country from which the rest of the classes will derive their information from
	 */
	private CountryModel countryModel=new CountryModel();
	
	/**
	 * The first view to show up.
	 */
	private SelectionView selectionView=new SelectionView();
	
	
	/**
	 * Constructor method for driver. Views should be added to models here, and models should be set for views here.
	 */
	public Driver()
	{
		selectionView.setModel(countryModel);
		countryModel.addActionListener(selectionView);
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
