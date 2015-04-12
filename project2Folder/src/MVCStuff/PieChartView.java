package MVCStuff;

import java.awt.event.ActionEvent;

import project4.Pie;

public class PieChartView extends View {
	
	
	Pie pie;
	
	/**
	 * Constructor for PieChartView
	 */
	public PieChartView(Pie pie)
	{
		super();
		this.pie=pie;
		this.add(this.pie);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
	}
	
}
