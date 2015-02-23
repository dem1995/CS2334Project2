package project2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonListTest {

	@Test
	public void test() {
		PersonList testPersonList=new PersonList();
		testPersonList.addPerson(new Person("fred", "smith", null));
		testPersonList.addPerson(new Person("george", "zebra", null));
		testPersonList.addPerson(new Person("harold", "cobra", null));

		testPersonList.sortUsing(PersonList.lastNameComparator);
		assertEquals("cobra", testPersonList.getPerson(0));
		testPersonList.sortUsing(PersonList.firstNameComparator);
		assertEquals("fred", testPersonList.getPerson(0));
		
		assertEquals("george", testPersonList.exactSearchFor("george", PersonList.firstNameComparator).getPerson(0).getFirstName());
		assertEquals("harold cobra", testPersonList.partialSearchNamesFor("rold").getPerson(0).getFullName());
	}

}