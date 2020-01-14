package PatientManagmentSystem.DataModel.PatientSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PatientTest {
	Patient test = new Patient("test", "test", "T1", "Testing", 100, "Other", "Test road, Testland");

	@Test
	void testGetGivenName() {

		assertEquals("test", test.getGivenName());
	}

	@Test
	void testSetGivenName() {
		test.setGivenName("test1");

		assertEquals("test1", test.getGivenName());
	}

	@Test
	void testGetSurname() {
		assertEquals("test", test.getSurname());
	}

	@Test
	void testSetSurname() {
		test.setSurname("test2");
		assertEquals("test2", test.getSurname());

	}

	@Test
	void testGetUniqueID() {

		assertEquals("T1", test.getUniqueID());

	}

	@Test
	void testSetUniqueID() {

		test.setUniqueID("T2");
		assertEquals("T2", test.getUniqueID());
	}

	@Test
	void testGetPassword() {

		assertEquals("Testing", test.getPassword());
	}

	@Test
	void testSetPassword() {

		test.setPassword("Tester");
		assertEquals("Tester", test.getPassword());
	}

	@Test
	void testGetAge() {
		assertEquals(100, test.getAge());
	}

	@Test
	void testSetAge() {
		test.setAge(1000);

		assertEquals(1000, test.getAge());

	}

	@Test
	void testGetGender() {
		assertEquals("Other", test.getGender());
	}

	@Test
	void testSetGender() {

		test.setGender("testCase");

		assertEquals("testCase", test.getGender());
	}

	@Test
	void testGetAddress() {
		assertEquals("Test road, Testland", test.getAddress());
	}

	@Test
	void testSetAddress() {
		test.setAddress("Java lane");

		assertEquals("Java lane", test.getAddress());
	}

}
