package MVCStuff;

import java.awt.Frame;
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
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import sports.Team;
import sports.TeamSeason;
import countryComponents.City;
import countryComponents.Person;
import countryComponents.State;

/**
 *	The view that appears when the user starts the program. It has a menu bar with a file menu and a graph menu.
 *	Inside its content pane, there are three vertical lists side-by-side, each with its own title above it and set of buttons below it.
 *	The first list shall be titled "Places"; the second, "People"; the third, "Teams".
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
	private JList<City> placesList= new JList();
	private JList<Person> peopleList=new JList();
	private JList<TeamSeason> seasonList= new JList();
	private JScrollPane placesScrollPane= new JScrollPane(placesList);
	private JScrollPane peopleScrollPane= new JScrollPane(peopleList);
	private JScrollPane teamsScrollPane=  new JScrollPane(seasonList);
	
	//The contentPane's buttons
	private JButton addPlaceButton= new JButton("Add");
	private JButton addPersonButton= new JButton("Add");
	private JButton addSeasonButton= new JButton ("Add");
	
	/**
	 * The constructor method for SelectionView
	 */
	public SelectionView()
	{	
		super();
		
		
		//Keeps this window from always being on top.
		this.setAlwaysOnTop(false);
		
		//Makes it so that when this window closes, the whole program closes
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//Makes this window fill the whole screen
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		
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
		this.add(new JLabel("Places", SwingConstants.CENTER));
		this.add(new JLabel("People", SwingConstants.CENTER));
		this.add(new JLabel("Seasons", SwingConstants.CENTER));
		
		//Add ScrollableLists to the Frame
		this.add(placesScrollPane);
		this.add(peopleScrollPane);
		this.add(teamsScrollPane);
			
		//Add JButtons to the Frame
		this.add(addPlaceButton);
		this.add(addPersonButton);
		addPersonButton.setEnabled(false);
		this.add(addSeasonButton);
		addSeasonButton.setEnabled(false);
		
	
		validate();
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
		return addPersonButton;
	}
	
	public JButton getAddTeamButton(){
		return addSeasonButton;
	}
	

	public void setModel(CountryModel countryModel)
	{
		super.setModel(countryModel);
		this.countryModel=countryModel;
		if (countryModel!=null)
		{
			updatePlaceList();
		}
	}
	
	public JList<City> getJList()
	{
		return placesList;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		super.actionPerformed(e);
		if (countryModel!=null)
		{
			updatePlaceList();
			System.out.println("updatedPlaceList");
		}
		if (countryModel!=null&& e.getActionCommand()==Constants.PERSON_ADDED)
		{
			updatePersonList();
		}
		if (countryModel!=null&&(e.getActionCommand()==Constants.TEAM_ADDED||e.getActionCommand()==Constants.SEASON_ADDED))
		{
			updateSeasonList();
		}

		//if ()
		System.out.println("Model fired an action");
		System.out.println(e.paramString());
		
	}
	
	/**
	 * Updates the placesListModel of placesList
	 */
	private void updatePlaceList()
	{
		ArrayList<City> cityList=countryModel.getCities();
		if (cityList.size()!=placesList.getModel().getSize())
		{
			placesList.setListData(cityList.toArray(new City[0]));
		}
		if (cityList.size()!=0)
		{
			addPersonButton.setEnabled(true);
		}
		
			
	}

	private void updatePersonList()
	{
		ArrayList<Person> personList=countryModel.getPeople();
		if (personList.size()!=peopleList.getModel().getSize())
		{
			peopleList.setListData(personList.toArray(new Person[0]));
		}
	}
	
	private void updateSeasonList()
	{
		seasonList.setListData(countryModel.getSportsStuff().getTeamSeasons().toArray(new TeamSeason[0]));
	}
	
	
}