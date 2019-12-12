package PatientManagmentSystem.Controllers;

import PatientManagmentSystem.DataModel.DoctorSystem.CreateAppointment;

public class DoctorController {

	public CreateAppointment SendAppointmentDetails(String date, String patientID, String doctorID) {
	CreateAppointment newAppointment = new CreateAppointment(date, patientID, doctorID);
		return newAppointment;
	}
	
	
	
	
}
