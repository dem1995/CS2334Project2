package cleanMVCCircles;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class CleanMVCFunctionView extends JFrame {
	private static final long serialVersionUID = 4936659707746985798L;
	private JTextField jtfRadius = new JTextField();
	private JComboBox<Boolean> jcboFilled = new JComboBox<Boolean>(new Boolean[]{
			new Boolean(false), new Boolean(true)});

	public CleanMVCFunctionView() {		
		// Panel to group labels
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2, 1));
		panel1.add(new JLabel("Radius"));
		panel1.add(new JLabel("Filled"));

		// Panel to group text field, combo box, and another panel
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 1));
		panel2.add(jtfRadius);
		panel2.add(jcboFilled);

		//setLayout(new BorderLayout());
		add(panel1, BorderLayout.WEST);
		add(panel2, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 200);
		setLocation(200, 200);
		setVisible(true);
	}
	
	public JTextField getJtfRadius() {
		return jtfRadius;
	}
	
	public JComboBox<Boolean> getJcboFilled() {
		return jcboFilled;
	}
}
