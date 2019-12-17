package PatientManagmentSystem.DataModel;

import PatientManagmentSystem.DataModel.DoctorSystem.CreateAppointment;

public class Note {
	public CreateAppointment createAppointment;
public String notes;

public Note(CreateAppointment createAppointment, String notes) {
	this.createAppointment = createAppointment;
	this.notes = notes;
}


}
