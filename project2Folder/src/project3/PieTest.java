package project3;

import static org.junit.Assert.*;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JFrame;

import org.junit.Test;

public class PieTest {

	@Test
	public void test() {
		TreeMap<String, AtomicInteger> testMap=new TreeMap<String, AtomicInteger>();
		testMap.put("fred", new AtomicInteger(1));
		testMap.put("harold", new AtomicInteger(2));
		Pie pie = null;
		try
		{
		pie= new Pie(testMap);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		JFrame jFrame=new JFrame();
		jFrame.add(pie);
		jFrame.pack();
		jFrame.setVisible(true);
		System.out.println("Press enter");
		Scanner reader=new Scanner(System.in);
		reader.nextLine();
	}

}
