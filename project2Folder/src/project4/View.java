package project4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class View extends JFrame implements ActionListener 
{
	
	/**
	 * The TeamMateModel used by this view
	 */
	private TeamMateModel teamMateModel;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO	
	}
	
	/**
	 * Sets the TeamMateModel to be used by this view
	 * @param teamMateModel the TeamMateModel to be used by this view
	 */
	public void setModel(TeamMateModel teamMateModel)
	{
		//TODO
	}
	
	/**
	 * Returns the TeamMateModel used by this view
	 * @return teamMateModel the TeamMateModel used by this view
	 */
	public TeamMateModel getModel()
	{
		//TODO
		return null;
	}

}
