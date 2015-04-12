package project4;
//Version 1.1 Final. Date April 12, 2015. 3:20 AM

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * 
 *The basic View class that contains the methods/components that any View class should have. Abstract so as to prevent it being mistakenly used as a view with complete functionality.
 */
public abstract class View extends JFrame implements ActionListener 
{
	
	/**
	 * The TeamMateModel used by this view
	 */
	private TeamMateModel teamMateModel;

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	/**
	 * Sets the TeamMateModel to be used by this view
	 * @param modelParam the TeamMateModel to be used by this view
	 */
	public void setModel(TeamMateModel modelParam)
	{
		teamMateModel=modelParam;
		if (teamMateModel!=null)
			teamMateModel.addActionListener(this); //registers this view as an actionListener for its model teamMateModel
		repaint();
	}
	
	/**
	 * Returns the TeamMateModel used by this view
	 * @return teamMateModel the TeamMateModel used by this view
	 */
	public TeamMateModel getModel()
	{
		return teamMateModel;
	}

}
