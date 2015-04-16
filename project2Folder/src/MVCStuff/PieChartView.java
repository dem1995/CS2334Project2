package MVCStuff;

import java.awt.event.ActionEvent;

import otherClasses.Pie;

public class PieChartView extends View {
	
	
	Pie pie;
	
	/**
	 * Constructor for PieChartView
	 * @param pie The pie to make the view for
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