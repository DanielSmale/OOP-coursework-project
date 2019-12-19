package PatientManagmentSystem.DataModel.DoctorSystem;
import java.io.*;

import PatientManagmentSystem.DataModel.Note;
public class CreateAppointment {

	
	private String date;
	private String doctorID;
	private String patientID;
	private Note notes;
	
	public CreateAppointment(String inDate, String inPatientID, String inDoctorID) {
		this.setDate(inDate);
		this.setPatientID(inPatientID);
		this.setDoctorID(inDoctorID);

		
		
	}

	public Note getNotes() {
		return notes;
	}

	public void setNotes(Note notes) {
		this.notes = notes;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}




	
	
	
	
}
