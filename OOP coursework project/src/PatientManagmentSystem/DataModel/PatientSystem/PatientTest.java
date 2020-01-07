package PatientManagmentSystem.DataModel.PatientSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PatientTest {
	Patient test = new Patient("test", "test", "T1", "Testing", 100, "Other", "Test road, Testland");

	@Test
	void testPatientStringStringStringStringIntStringString() {

		assertEquals("test", test.getGivenName());
		assertEquals("test", test.getSurname());
		assertEquals("T1", test.getUniqueID());
		assertEquals("Testing", test.getPassword());
		assertEquals(100, test.getAge());
		assertEquals("Other", test.getGender());
		assertEquals("Test road, Testland", test.getAddress());

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
