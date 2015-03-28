package project3;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JComponent;

/**
 * A Pie chart.
 */
public class Pie extends JComponent {
	
	/**
	 * The total weight of the pie (the sum of the pie's sectors' weights)
	 */
	private int weightSum=0;
	
	/**
	 * The pieces of the pie chart
	 */
	private ArrayList<Sector> sectors=new ArrayList<Sector>();

	/**
	 * Creates a new pie chart using a TreeMap of data
	 * @param map
	 */
	
	public Pie(TreeMap<String, AtomicInteger> map)
	{
		for (Entry<String, AtomicInteger> entry : map.entrySet())
		{
			System.out.println(entry.getKey()+"||"+entry.getValue());
			
		    sectors.add(new Sector(entry.getKey(), entry.getValue().get()));
		    System.out.println(entry.getKey()+" added");

		}
		
		for(Sector sector: sectors)
		{
			weightSum+=sector.getWeight();
		}
		for(Sector sector: sectors)
		{
			sector.setAngleExtent(((double)sector.getWeight())/weightSum*360);
			//TODO delete this print statement after verifying the operation above worked as expected.
			System.out.print(sector.getAngleExtent());
			sector.setColor(new Color((int)(Math.random() * 0x1000000)));
		}
	}
	
	/**
	 * @param team Creates a Pie chart from a team object
	 */
	public Pie(Team team)
	{
		PersonList personList=team.getTeamMembers();
		ArrayList<Person> personArrayList=personList.getPeople();
		Set<Integer> setOfAges=new TreeSet<Integer>();
		for (Person person: personArrayList)
		{
			setOfAges.add(new Integer(person.getAge()));
		}
		
		
		
		
	}
	
	
	public void paint(Graphics g)
	{
		Graphics2D g2D=(Graphics2D)g;
		 RenderingHints renderingHints = new RenderingHints(
	             RenderingHints.KEY_TEXT_ANTIALIASING,
	             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	    g2D.setRenderingHints(renderingHints);
		Rectangle2D boundaries=this.getBounds();
		Rectangle2D boundingRectangle=new Rectangle2D.Double();
		if (boundaries.getWidth()<boundaries.getHeight())
			boundingRectangle=new Rectangle2D.Double(boundaries.getX(), boundaries.getY(), boundaries.getWidth(), boundaries.getWidth());
		else
			boundingRectangle=new Rectangle2D.Double(boundaries.getX(), boundaries.getY(), boundaries.getHeight(), boundaries.getHeight());
		g2D.draw(new Ellipse2D.Double(boundingRectangle.getX(), boundingRectangle.getY(), boundingRectangle.getWidth(), boundingRectangle.getHeight()));
		double currentAngle=0;
		for (Sector sector: sectors)
		{
			sector.setFrame(boundingRectangle);
			sector.setAngleStart(currentAngle);
			currentAngle+=sector.getAngleExtent();
			g2D.setColor(sector.getColor());
			g2D.fill(sector);
		}
	}
}
