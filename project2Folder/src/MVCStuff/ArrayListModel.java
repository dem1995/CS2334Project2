package MVCStuff;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

/**
 * @author Dave
 *
 * @param <E> The the type of object held by this listModel
 */
public class ArrayListModel<E> extends DefaultListModel<E> {
	/**
	 * 
	 */
	ArrayList<E> elements;
	

}
