package MVCStuff;

import java.awt.event.ActionEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *	The view that appears when the user starts the program. It has a menu bar with a file menu and a graph menu.
 	Inside its content pane, there are three vertical lists side-by-side, each with its own title above it and set of buttons below it.
 	The first list shall be titled "Places"; the second, "People"; the third, "Teams".
 */
public class SelectionView extends View {
	
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
	
	
	/**
	 * The constructor method for SelectionView
	 */
	public SelectionView()
	{	
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
		
		//Set the names for the actions to happen when the JMenuItems are clicked
		loadMenuItem.setActionCommand("load");
		saveMenuItem.setActionCommand("save");
		importMenuItem.setActionCommand("import");
		exportMenuItem.setActionCommand("export");
		pieChartMenuItem.setActionCommand("pie");
		mapMenuItem.setActionCommand("map");
		
		
		//Have this view listen to the menuItems for actionEvents
		loadMenuItem.addActionListener(this);
		saveMenuItem.addActionListener(this);
		importMenuItem.addActionListener(this);
		exportMenuItem.addActionListener(this);
		pieChartMenuItem.addActionListener(this);
		mapMenuItem.addActionListener(this);
		
		
		setSize(500,200);
		setLocation(400, 200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//TODO
	}
}