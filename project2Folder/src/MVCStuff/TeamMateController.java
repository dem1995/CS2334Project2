package MVCStuff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TeamMateController {
	
	private CountryModel countryModel;
	
	private SelectionView selectionView;
	
	private StateSelectionView stateSelectionView;

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
    					//TODO Load method
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
    		
    	}
    		
    		
    }   
    public void setStateSelectionView(StateSelectionView stateSelectionView)
    {
    	this.stateSelectionView=stateSelectionView;
    	if(stateSelectionView!=null)
    	{
    		stateSelectionView.get
    	}
    }
}
