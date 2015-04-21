package MVCStuff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.swing.filechooser.FileNameExtensionFilter;

import countryComponents.City;
import countryComponents.Person;
import otherClasses.HelperMethods;
import sports.SportsStuff;

public class TeamMateController {
	
	private CountryModel countryModel;
	
	private SelectionView selectionView;
	
	private StateSelectionView stateSelectionView;
	
	private CityEntryView cityEntryView;
	
	private CitySelectionView citySelectionView;
	
	private PersonEntryView personEntryView;
	
	private FileChooserView fileChooserView;
	
	String fileName;

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
    		selectionView.getImportMenuItem().addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    				
    				
    					//TODO Load method. The method below is not what the instructions want, and is only for testing purposes so please prepare a proper file searcher.
    				
    				Object[] options= {"People file", "Team file"};
    				int n = JOptionPane.showOptionDialog(null,
    					    "What kind of file are you loading?",
    					    "",
    					    JOptionPane.DEFAULT_OPTION,
    					    JOptionPane.PLAIN_MESSAGE,
    					    null,     //do not use a custom Icon
    					    options,  //the titles of buttons
    					    options[0]); //default button title
    				
    				File currentDirectory = new File(System.getProperty("user.dir"));
    				FileNameExtensionFilter filter = new FileNameExtensionFilter(
					        "CSV files", "csv");
    				JFileChooser fileChooser=new JFileChooser();
    				if(n==0)
    				{
    					fileChooser= new JFileChooser()
    					{
    						public void approveSelection(){
    							super.approveSelection();
    							String chosenFile=this.getSelectedFile().getAbsolutePath();
    							System.out.println(chosenFile);
    							try{
    			    				ArrayList<String> csvStrings= HelperMethods.convertCSVToStringList(chosenFile);
    			    				countryModel.addStringList(csvStrings);
    			    				System.out.println("File loaded");
    			    				}catch (Exception f)
    			    				{
    			    					System.out.println("An error occurred");
    			    				}
    							
    					}		
    				};
    				fileChooser.setFileFilter(filter);
    				fileChooser.setCurrentDirectory(currentDirectory);
    				fileChooser.showOpenDialog(null);
    				}
    				else if (n==1)
    				{
    					fileChooser= new JFileChooser()
        				{
        					public void approveSelection(){
        						super.approveSelection();
        						String chosenFile=this.getSelectedFile().getAbsolutePath();
        						System.out.println(chosenFile);
        						try{
        	    					SportsStuff tempSportsStuff=new SportsStuff();
        	    					tempSportsStuff.prepareFromCSVUsingCountryModel(chosenFile, countryModel);
        	    					countryModel.setSportsStuff(tempSportsStuff);
        	    				}catch(Exception f)
        	    				{
        	    					System.out.println("Team loading failed");
        	    				}
        					}		
        				};
        			fileChooser.setFileFilter(filter);
        			fileChooser.setCurrentDirectory(currentDirectory);
        			fileChooser.showOpenDialog(null);
    				}

    				
    				
    				
    			}
    		});
    		
    		selectionView.getSaveMenuItem().addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e)
    			{		
    				
    					   
    				JFileChooser fileChooser= new JFileChooser()
    				{
    					public void approveSelection(){
    						super.approveSelection();
    						String chosenFile=this.getSelectedFile().getAbsolutePath();
    						System.out.println(chosenFile);
    						try{
    	    					HelperMethods.saveToFile(countryModel, chosenFile);
    	    				}catch(Exception f)
    	    				{
    	    					System.out.println("File saving failed");
    	    				}
    					}		
    				};
    				fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
    				fileChooser.showOpenDialog(null);
    			}
    		});
    		
    		selectionView.getLoadMenuItem().addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    				JFileChooser fileChooser= new JFileChooser()
    				{
    					public void approveSelection(){
    						super.approveSelection();
    						String chosenFile=this.getSelectedFile().getAbsolutePath();
    						System.out.println(chosenFile);
    						try{
    	    					//HelperMethods.saveToFile(chosenFile);
    	    				}catch(Exception f)
    	    				{
    	    					System.out.println("File saving failed");
    	    				}
    					}		
    				};
    				fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
    				fileChooser.showOpenDialog(null);
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
    				ActionListener stateSelectionToCityEntry=new ActionListener(){
    	    			public void actionPerformed(ActionEvent e){
    	    				setCityEntryView(new CityEntryView(stateSelectionView.getSelectedState()));
    	    		    	stateSelectionView.setVisible(false);
    	    		    	stateSelectionView.dispose();
    	    			}	
    	    		};
    				setStateSelectionView(new StateSelectionView(), stateSelectionToCityEntry);
    			}
    		});
    		
    		selectionView.getAddPersonButton().addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    				
    				//Preparing actionlisteners
    				ActionListener citySelectionToPersonEntry=new ActionListener(){
    					public void actionPerformed(ActionEvent e)
    					{
    						setPersonEntryView(new PersonEntryView(citySelectionView.getSelectedCity()));
    						citySelectionView.setVisible(false);
    						citySelectionView.dispose();
    					}
    				};
    				ActionListener stateSelectionToCitySelection= new ActionListener(){
    					public void actionPerformed(ActionEvent e)
    					{
    						setCitySelectionView(new CitySelectionView(stateSelectionView.getSelectedState()), citySelectionToPersonEntry);
    						stateSelectionView.setVisible(false);
    						stateSelectionView.dispose();
    					}
    				};
    				
    				//Setting a view up with the aforementioned ActionListeners
    				setStateSelectionView(new StateSelectionView(), stateSelectionToCitySelection);
    			}
    		});
    		
    		selectionView.getAddTeamButton().addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    					//TODO Map Method
    			}
    		});
    		
    	}
    		
    		
    }   
    

    public void setStateSelectionView(StateSelectionView stateSelectionView, ActionListener actionListener)
    {
    	this.stateSelectionView=stateSelectionView;
    	stateSelectionView.setModel(countryModel);    
    	if (countryModel!=null)
    	{
    		stateSelectionView.getEnterButton().addActionListener(actionListener);
    	}
    }
    
    /**
     * View for entering new cities
     * @param cityEntryView
     */
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
    
    /**
     * View for selecting cities
     * @param citySelectionView
     */
    public void setCitySelectionView(CitySelectionView citySelectionView, ActionListener f)
    {
    	this.citySelectionView=citySelectionView;
    	citySelectionView.setModel(countryModel);
    	if(countryModel!=null)
    	{
    		citySelectionView.getEnterButton().addActionListener(f);
    	}
    	
    }
    
    public void setPersonEntryView(PersonEntryView personEntryView)
    {
    	this.personEntryView=personEntryView;
    	personEntryView.setModel(countryModel);
    	if (countryModel!=null)
    	{
    		personEntryView.getEnterButton().addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e)
    			{
    				try
    				{
    					Person personToAdd=personEntryView.getFullPerson();
    					countryModel.addPerson(personEntryView.getCity(), personEntryView.getFullPerson());
    					System.out.println(personToAdd);
    					personEntryView.setVisible(false);
    					personEntryView.dispose();
    				}catch (Exception f)
    				{
    					JOptionPane.showMessageDialog(personEntryView, f.getMessage());
    				}
    			}
    		});
    	}
    		//TODO
    }
    
    public void setFileChooserView(ActionListener actionListener)
    {
    	 this.fileChooserView=new FileChooserView(actionListener);
    	 fileChooserView.setModel(countryModel);   	 
    }

    
}
