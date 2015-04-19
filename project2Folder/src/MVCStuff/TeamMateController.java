package MVCStuff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import countryComponents.City;
import otherClasses.HelperMethods;

public class TeamMateController {
	
	private CountryModel countryModel;
	
	private SelectionView selectionView;
	
	private StateSelectionView stateSelectionView;
	
	private CityEntryView cityEntryView;
	
	private PersonEntryView personEntryView;

	/**
	 * Instance method for TeamMateController
	 */
	public TeamMateController()
	{
	}
	
	public void setModel(CountryModel newModel)
	{
		countryModel=newModel;
	}
	
    public void setSelectionView(SelectionView selectionView)
    {
    	this.selectionView=selectionView;
    	if(selectionView==null)
    		return;
    	else
    	{	
    		selectionView.getLoadMenuItem().addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    					//TODO Load method. The method below is not what the instructions want, and is only for testing purposes so please prepare a proper file searcher.
    				try{
    				ArrayList<String> csvStrings= HelperMethods.convertCSVToStringList("Players.csv");
    				countryModel.addStringList(csvStrings);
    				System.out.println("File loaded");
    				}catch (Exception f)
    				{
    					System.out.println("An error occurred");
    				}
    			}
    		});
    		
    		selectionView.getSaveMenuItem().addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    					//TODO Save Method
    			}
    		});
    		
    		selectionView.getImportMenuItem().addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    					//TODO Import Method
    			}
    		});
    		
    		selectionView.getExportMenuItem().addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    					//TODO Export Method
    			}
    		});
    		
    		selectionView.getPieChartMenuItem().addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    					//TODO Pie Chart Method
    			}
    		});
    		
    		selectionView.getMapMenuItem().addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    					//TODO Map Method
    			}
    		});
    		
    		selectionView.getAddPlaceButton().addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    					setStateSelectionView(new StateSelectionView());
    			}
    		});
    		
    		selectionView.getAddPersonButton().addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    					//TODO Add Person
    			}
    		});
    		
    		selectionView.getAddTeamButton().addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    					//TODO Map Method
    			}
    		});
    		
    	}
    		
    		
    }   
    

    public void setStateSelectionView(StateSelectionView stateSelectionView)
    {
    	this.stateSelectionView=stateSelectionView;
    	stateSelectionView.setModel(countryModel);    
    	if (countryModel!=null)
    	{
    		stateSelectionView.getEnterButton().addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    				setCityEntryView(new CityEntryView(stateSelectionView.getSelectedState()));
    		    	stateSelectionView.setVisible(false);
    		    	stateSelectionView.dispose();
    			}	
    		});
    	}
    }
    
    public void setCityEntryView(CityEntryView cityEntryView)
    {
    	this.cityEntryView=cityEntryView;
    	cityEntryView.setModel(countryModel);
    	if (countryModel!=null)
    	{
    		cityEntryView.getEnterButton().addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e)
    			{
    				try
    				{
    				City cityToAdd= cityEntryView.getFullCity();
    				countryModel.addCity(cityToAdd.getState(), cityToAdd);
    				cityEntryView.setVisible(false);
    				cityEntryView.dispose();
    				}catch (Exception f)
    				{
    					JOptionPane.showMessageDialog(cityEntryView, "Something went wrong with the creation of the city. Please try again.");
    				}
    			}
    		});
    	}
    }
    

}
