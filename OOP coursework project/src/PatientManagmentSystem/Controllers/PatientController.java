package PatientManagmentSystem.Controllers;

import PatientManagmentSystem.DataModel.PatientSystem.AppointmentRequest;

public class PatientController {

	public void CreateAppointmentRequest(String preferedDoctorID, String[] preferedDates) {

		AppointmentRequest appointmentRequest = new AppointmentRequest();
		appointmentRequest.AppointmentRequest(preferedDoctorID, preferedDates);

	}

}
