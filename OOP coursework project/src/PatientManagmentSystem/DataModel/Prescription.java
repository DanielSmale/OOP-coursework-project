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

}
