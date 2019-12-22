package PatientManagmentSystem.DataModel;

import PatientManagmentSystem.DataModel.DoctorSystem.CreateAppointment;

public class Note {

	public String notes;
	private Appointment relatedAppointment; // the appointment this note was added in
	
	public Appointment getRelatedAppointment() {
		return relatedAppointment;
	}

	public void setRelatedAppointment(Appointment relatedAppointment) {
		this.relatedAppointment = relatedAppointment;
	}

	public Note(String notes) {
		this.notes = notes;
	}

}
