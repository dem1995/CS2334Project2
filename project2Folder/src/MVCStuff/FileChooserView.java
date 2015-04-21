package MVCStuff;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooserView extends View {

	
	public String fileChosen="";
	
	public FileChooserView(ActionListener actionListener)
	{
		super();
		JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "csv files", "csv");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(this);
	    chooser.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		fileChosen=chooser.getSelectedFile().getAbsolutePath();
	    	}
	    });
	    chooser.addActionListener(actionListener);		
	}

}
