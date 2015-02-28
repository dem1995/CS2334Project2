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
	 * Creates a new CustomBufferedReader with <code>new</code> <code>InputStreamReader</code> <code>System.in</code> as args
	 */
	public CustomBufferedReader()
	{
		this(new InputStreamReader(System.in));
	}
	
	/**
	 * Instantiates a CustomBufferedReader with given arguments. Calls CustomBufferedReader's superClass's instantiation method, so any requirements that this constructor would have in BufferedReader must also be present here
	 * @param arg0 The reader to be wrapped by this
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
