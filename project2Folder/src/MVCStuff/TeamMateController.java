package MVCStuff;

import java.util.ArrayList;

public class TeamMateController {
	/**
	 * An arrayList that holds all the views (which are actionListeners) to be handled by this controller.
	 */
	private ArrayList<View> views;

	/**
	 * Instance method for TeamMateController
	 */
	public TeamMateController()
	{
		views=new ArrayList<View>();
	}
	
    public void addView(View view)
	{
	}
}
