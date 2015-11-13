package base;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {

	private static PersonDomainModel person;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Where instance of PersonDomainModel created
		Calendar date = Calendar.getInstance();
		date.set(1996, 02, 28);
		Date DOB = date.getTime();
		PersonDomainModel person1 = new PersonDomainModel("Andrew", "Gross", "107 Norris Road", 19803, "Wilmington", DOB);
		person = person1;
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//Delete person record after every test
		PersonDAL.deletePerson(person.getPersonID());
		
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void addPersonTest() {
		//Try to get the value of person in database but fail because it has not been added yet
		try {
		PersonDAL.getPerson(person.getPersonID());
		}
		catch (IndexOutOfBoundsException e) {
			//Should catch the error thrown and output this message
			System.out.println("No record of person in database.");
		}
		
		
		//Now attempt to add person to database
		try {
			PersonDAL.addPerson(person); 
			//Test to determine if person was added to database
			assertTrue(PersonDAL.getPerson(person.getPersonID()).getPersonID().toString().equals(person.getPersonID().toString()));
			System.out.println("Person added to the database!");
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("No record of person in database.");
		}
	}
	
	@Test
	public void editPersonTest() {
		//Add person to database with first name "Andrew"
		PersonDAL.addPerson(person);
		//Check to see if first name in database == first name in person
		assertTrue(PersonDAL.getPerson(person.getPersonID()).getFirstName().toString().equals(person.getFirstName().toString()));
		
		//Edit person in database; change name from "Andrew" to "Johnny"
		person.setFirstName("Johnny");
		PersonDAL.updatePerson(person);
		//Check to see if first name in database changed from "Andrew" to "Johnny"
		assertTrue(PersonDAL.getPerson(person.getPersonID()).getFirstName().toString().equals(person.getFirstName().toString()));
		
	}
	
	@Test
	public void deletePersonTest() {
		//Add person to database
		PersonDAL.addPerson(person);
		//Check to see if person was added to the database
		assertTrue(PersonDAL.getPerson(person.getPersonID()).getPersonID().toString().equals(person.getPersonID().toString()));
		
		//Try to delete person from database
		PersonDAL.deletePerson(person.getPersonID());
		try {
			PersonDAL.getPerson(person.getPersonID());
			System.out.println("Record of person found in database");
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("Record deleted!");
		}
		
	}

}
