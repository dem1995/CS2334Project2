package MVCStuff;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import countryComponents.City;
import countryComponents.Person;
import countryComponents.State;
import countryComponents.Team;

/**
 *	The view that appears when the user starts the program. It has a menu bar with a file menu and a graph menu.
 	Inside its content pane, there are three vertical lists side-by-side, each with its own title above it and set of buttons below it.
 	The first list shall be titled "Places"; the second, "People"; the third, "Teams".
 */
public class SelectionView extends View {
	
	//The model from which this view obtains data
	private CountryModel countryModel;
	
	//The menus to be added to this view's jMenuBar

	/**
	 * The file menu for the menu bar.
	 */
	private JMenu fileMenu= new JMenu("File");
	
	/**
	 * The graph menu for the menu bar.
	 */
	private JMenu graphMenu= new JMenu("Graph");
	
	//The fileMenu's menuItems
	private JMenuItem loadMenuItem= new JMenuItem("Load TeamMate data");
	private JMenuItem saveMenuItem= new JMenuItem("Save TeamMate data");
	private JMenuItem importMenuItem= new JMenuItem("Import TeamMate data");
	private JMenuItem exportMenuItem= new JMenuItem("Export TeamMate data");
	
	//The graphMenu's menuItems
	private JMenuItem pieChartMenuItem= new JMenuItem("Pie Chart");
	private JMenuItem mapMenuItem= new JMenuItem("Map");
	
	//The contentPane's JScrollPanes and JLists
	DefaultListModel<City> placesListModel=new DefaultListModel<City>();
	private JList<City> placesList= new JList(placesListModel);
	private JList<Person> peopleList=new JList();
	private JList<Team> teamList= new JList();
	private JScrollPane placesScrollPane= new JScrollPane(placesList);
	private JScrollPane peopleScrollPane= new JScrollPane();
	private JScrollPane teamsScrollPane=  new JScrollPane();
	
	//The contentPane's buttons
	private JButton addPlaceButton= new JButton("Add");
	private JButton addPersonButton= new JButton("Add");
	private JButton addTeamButton= new JButton ("Add");
	
	/**
	 * The constructor method for SelectionView
	 */
	public SelectionView()
	{	
		super();
		
		//Set the layout for the JFrame
		this.setLayout(new GridLayout(3,3));
		
		//Set up the menu bar
		setJMenuBar(new JMenuBar());

		//Add fileMenu and graphMenu
		getJMenuBar().add(fileMenu);
		getJMenuBar().add(graphMenu);
	
		//Add JMenuItems to fileMenu and graphMenu
		fileMenu.add(loadMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.add(importMenuItem);
		fileMenu.add(exportMenuItem);
		graphMenu.add(pieChartMenuItem);
		graphMenu.add(mapMenuItem);
		
		//Add titles to the columns for the frame
		this.add(new JLabel("Places"));
		this.add(new JLabel("People"));
		this.add(new JLabel("Teams"));
		
		//Add ScrollableLists to the Frame
		this.add(placesScrollPane);
		this.add(peopleScrollPane);
		this.add(teamsScrollPane);
			
		//Add JButtons to the Frame
		this.add(addPlaceButton);
		this.add(addPersonButton);
		this.add(addTeamButton);
		
	}
	
	//Getter methods for JMenuItem
	
	public JMenuItem getLoadMenuItem() {
		return loadMenuItem;
	}

	public JMenuItem getSaveMenuItem() {
		return saveMenuItem;
	}

	public JMenuItem getImportMenuItem() {
		return importMenuItem;
	}

	public JMenuItem getExportMenuItem() {
		return exportMenuItem;
	}

	public JMenuItem getPieChartMenuItem() {
		return pieChartMenuItem;
	}

	public JMenuItem getMapMenuItem() {
		return mapMenuItem;
	}
	
	public JButton getAddPlaceButton(){
		return addPlaceButton;
	}

	public JButton getAddPersonButton(){
		return addPlaceButton;
	}
	
	public JButton getAddTeamButton(){
		return addPlaceButton;
	}

	public void setModel(CountryModel countryModel)
	{
		super.setModel(countryModel);
		this.countryModel=countryModel;
		if (countryModel!=null)
		{
			ArrayList<State> theStates= countryModel.getStates();
			for (int i=0; i<theStates.size(); i++)
			{
				ArrayList<City> theCities= theStates.get(i).getCities();
				for (int j=0; j<theCities.size(); j++)
					placesListModel.addElement(theCities.get(j));
					
			}
		}
		placesList=new JList(placesListModel);
	}
	public void actionPerformed(ActionEvent e)
	{
		
		super.actionPerformed(e);
		if (countryModel!=null)
		{
			updatePlaceList(placesListModel, countryModel);
			System.out.println("updatedPlaceList");
		}
		System.out.println("Model fired an action");
		System.out.println(e.paramString());
		
	}
	
	/**
	 * Updates the placesListModel of placesList
	 * @param theList
	 * @param theModel
	 */
	private void updatePlaceList(DefaultListModel<City> theList, CountryModel theModel)
	{
		placesListModel=new DefaultListModel<City>();
		placesList.setModel(placesListModel);
		ArrayList<State> theStates= countryModel.getStates();
		for (int i=0; i<theStates.size()&&i<5; i++)
		{
			ArrayList<City> theCities= theStates.get(i).getCities();
			for (int j=0; j<theCities.size()&&j<5; j++)
				placesListModel.addElement(theCities.get(j));
		}	
		
	}
	
}