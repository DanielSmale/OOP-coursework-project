package PatientManagmentSystem.DataModel;

public class Prescription {

	private String doctorID;
	private String patientID;
	private Note doctorNote;
	private Medicine medicine;
	private int quantity;
	private double dosage;

	public Prescription(String doctorID, String patientID, Note doctorNote, Medicine medicine, int quantity,
			double dosage) {
		super();
		this.doctorID = doctorID;
		this.patientID = patientID;
		this.doctorNote = doctorNote;
		this.medicine = medicine;
		this.quantity = quantity;
		this.dosage = dosage;
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

	public Note getDoctorNote() {
		return doctorNote;
	}

	public void setDoctorNote(Note doctorNote) {
		this.doctorNote = doctorNote;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDosage() {
		return dosage;
	}

	public void setDosage(double dosage) {
		this.dosage = dosage;
	}

}
