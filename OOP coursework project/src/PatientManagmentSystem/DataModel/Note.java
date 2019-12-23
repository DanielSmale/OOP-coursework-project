package PatientManagmentSystem.DataModel;

import PatientManagmentSystem.DataModel.DoctorSystem.CreateAppointment;

public class Note {

	private String notes;
	private Appointment relatedAppointment; // the appointment this note was added in

	public Note(String notes) {
		this.notes = notes;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Appointment getRelatedAppointment() {
		return relatedAppointment;
	}

	public void setRelatedAppointment(Appointment relatedAppointment) {
		this.relatedAppointment = relatedAppointment;
	}

}
