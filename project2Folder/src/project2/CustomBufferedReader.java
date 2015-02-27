package project2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 *a custom <code>BufferedReader</code> that catches IO exceptions during its readline method
 */
public class CustomBufferedReader extends BufferedReader{

	/**
	 * Creates a new CustomBufferedReader using System.in as args
	 */
	public CustomBufferedReader()
	{
		this(new InputStreamReader(System.in));
	}
	
	/**
	 * @param arg0
	 */
	public CustomBufferedReader(Reader arg0) {
		super(arg0);
		
	}
	
	public String readLine()
	{
		String input="";
		try
		{
			input=super.readLine();
		}
		catch(IOException e)
		{
				
		}
		return input;
	}

}
