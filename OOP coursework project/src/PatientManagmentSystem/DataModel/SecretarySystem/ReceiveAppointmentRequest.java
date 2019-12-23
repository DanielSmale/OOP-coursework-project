package PatientManagmentSystem.DataModel.SecretarySystem;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import PatientManagmentSystem.Controllers.DoctorController;
import PatientManagmentSystem.Controllers.SecretaryController;
import PatientManagmentSystem.DataModel.Appointment;
import PatientManagmentSystem.DataModel.DoctorSystem.Doctor;
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

	public static void ReceiveAppointmentRequest(String preferedDoctorID, String patientID, String[] preferedDates) {

		Doctor[] allDoctors = secretaryController.ReturnDoctorDetails();
		Appointment[] allApointments = secretaryController.ReturnAppointmentDetails();

		for (Doctor currentDoctor : allDoctors) {
			if (preferedDoctorID == currentDoctor.getUniqueID()) { // if the preferred doctor
				for (Appointment currentAppointment : allApointments) {
					int i = 0;
					if (preferedDates[i] != currentAppointment.getDate() || i < preferedDates.length) {
						// and if one of the preferred dates are available
						Appointment requestedAppointment = new Appointment(currentAppointment.getDate(),
								preferedDoctorID, patientID); // create an appointment
						secretaryController.StoreAppointmentDetails(requestedAppointment);
					} else {
						i++;
					}
				}

			}

		}

	}

}
