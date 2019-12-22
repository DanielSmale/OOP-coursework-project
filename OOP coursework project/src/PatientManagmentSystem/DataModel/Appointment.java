package PatientManagmentSystem.DataModel;

public class Appointment {

	private String date;
	private String doctorID;
	private String patientID;


	public Appointment(String date, String doctorID, String patientID) {
		super();
		this.date = date;
		this.doctorID = doctorID;
		this.patientID = patientID;
	}




	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}


}
