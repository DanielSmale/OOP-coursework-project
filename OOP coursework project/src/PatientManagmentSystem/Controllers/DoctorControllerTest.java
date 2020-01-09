package PatientManagmentSystem.Controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PatientManagmentSystem.DataModel.Appointment;
import PatientManagmentSystem.DataModel.Prescription;

class DoctorControllerTest {

	DoctorController testController;

	@BeforeEach
	void setUp() throws Exception {
		testController = new DoctorController();
	}

	@Test
	void testSendAppointmentDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testStoreAppointmentDetails() {
		
		Appointment testApp = new Appointment("testuesday", "tP1", "tD1");

		testController.StoreAppointmentDetails(testApp);
		Appointment[] appointment = testController.ReturnAppointmentsDetails();
		assertEquals("testuesday", appointment[0].getDate());
		assertEquals("tP1", appointment[0].getPatientID());
		assertEquals("tD1", appointment[0].getDoctorID());
	}

	@Test
	void testReturnAppointmentsDetails() {

	Appointment testApp = new Appointment("testuesday", "tP1", "tD1");
		
		testController.StoreAppointmentDetails(testApp);
		Appointment[] appointment = testController.ReturnAppointmentsDetails();
		assertEquals("testuesday" , appointment[0].getDate());
		assertEquals("tP1" , appointment[0].getPatientID());
		assertEquals("tD1" , appointment[0].getDoctorID());
		
	}

	@Test
	void testSendNotes() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPatientHistory() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateNewPrescription() {
			
		testController.CreateNewPrescription("tD1", "tP1", "im testing", "testyprofine", 10000, 100);
		
		PatientController tp = new PatientController();
		
		Prescription[] p = tp.ReturnPrescriptionDetails();

		assertEquals("tD1" , p[0].getDoctorID());
		assertEquals("tP1" , p[0].getPatientID());
		assertEquals("im testing" , p[0].getDoctorNote().getNotes());
		assertEquals("testyprofine" , p[0].getMedicine().getMedicineName());
		assertEquals("10000" , p[0].getQuantity());
		assertEquals("100" , p[0].getDosage());

		
	}

	@Test
	void testStorePrescriptionDetails() {
		
		
	}

}
