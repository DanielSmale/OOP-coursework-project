package PatientManagmentSystem.DataModel;

public class Appointment {

	private String date;
	private String patientID;
	private String doctorID;

	public Appointment(String date, String patientID, String doctorID) {
		super();
		this.date = date;
		this.patientID = patientID;
		this.doctorID = doctorID;

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
