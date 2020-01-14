package PatientManagmentSystem.DataModel.SecretarySystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import PatientManagmentSystem.DataModel.DoctorSystem.Doctor;

class SecretaryTest {

	Secretary test = new Secretary("test", "test", "T1", "Testing");

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

}
