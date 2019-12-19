package PatientManagmentSystem.DataModel.PatientSystem;

import PatientManagmentSystem.DataModel.SecretarySystem.ReceiveAppointmentRequest;

public class AppointmentRequest {
	// Request appointment � there should be an avenue to ask for a specific doctor
	// and a range of
	// potential dates.

	String PreferredDoctorID;
	String[] PreferedDates;

	public void AppointmentRequest(String preferedDoctorID, String[] preferedDates) {

		ReceiveAppointmentRequest.ReceiveAppointmentRequest(preferedDoctorID, preferedDates);

	}

}
