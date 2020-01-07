package PatientManagmentSystem.DataModel.PatientSystem;

import PatientManagmentSystem.DataModel.SecretarySystem.ReceiveAppointmentRequest;

public class AppointmentRequest {
	// Request appointment – there should be an avenue to ask for a specific doctor
	// and a range of
	// potential dates.

	private String PreferredDoctorID;
	private String[] PreferedDates;

	public void AppointmentRequest(String preferedDoctorID, String patientID, String[] preferedDates) {

		ReceiveAppointmentRequest.ReceiveAppointmentRequest(preferedDoctorID, patientID, preferedDates);

	}

}
