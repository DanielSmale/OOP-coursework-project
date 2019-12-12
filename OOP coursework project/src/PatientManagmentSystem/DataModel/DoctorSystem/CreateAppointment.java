package PatientManagmentSystem.DataModel.DoctorSystem;

public class CreateAppointment {

	public String date;
	public String doctorID;
	public String patientID;
	
	
	public CreateAppointment(String inDate, String inPatientID, String inDoctorID) {
		this.date = inDate;
		this.patientID = inPatientID;
		this.doctorID = inDoctorID;

	}
	
	
}
