package PatientManagmentSystem.DataModel.DoctorSystem;
import java.io.*;

import PatientManagmentSystem.DataModel.Note;
public class CreateAppointment {

	
	public String date;
	public String doctorID;
	public String patientID;
	public Note notes;
	
	public CreateAppointment(String inDate, String inPatientID, String inDoctorID) {
		this.date = inDate;
		this.patientID = inPatientID;
		this.doctorID = inDoctorID;

		
		
	}




	
	
	
	
}
