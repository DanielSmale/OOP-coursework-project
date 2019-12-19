package PatientManagmentSystem.DataModel.SecretarySystem;

import PatientManagmentSystem.Controllers.SecretaryController;
import PatientManagmentSystem.DataModel.PatientSystem.AppointmentRequest;

public class ReceiveAppointmentRequest {
	 /*
	 * This object handles appointments a patient has asked for and matches up an
	 * available doctor on one of the possible dates
	 * 
	 * Receive requests for appointments. Secretary Create an appointment between a
	 * patient and a free doctor.
	 */
static SecretaryController secretaryController = new SecretaryController();

	public static void ReceiveAppointmentRequest(String preferedDoctorID, String[] preferedDates) {

	Object[] allDoctors = secretaryController.ReturnDoctorDetails();
		
		
	}

}
