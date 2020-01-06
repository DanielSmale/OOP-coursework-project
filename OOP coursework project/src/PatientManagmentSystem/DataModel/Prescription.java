package PatientManagmentSystem.DataModel;

public class Prescription {

	private String doctorID;
	private String patientID;
	private Note doctorNote;
	private Medicine medicine;
	private int quantity;
	private double dosage;

	public static class Builder {

		private String doctorID;
		private String patientID;
		private Note doctorNote;
		private Medicine medicine;
		private int quantity;
		private double dosage;

		public Builder(String doctorID, String patientID, Note doctorNote, Medicine medicine, int quantity,
				double dosage) {

			this.doctorID = doctorID;
			this.patientID = patientID;
			this.doctorNote = doctorNote;
			this.medicine = medicine;
			this.quantity = quantity;
			this.dosage = dosage;
		}

		public void setDoctorID(String doctorID) {
			this.doctorID = doctorID;
		}

		public void setPatientID(String patientID) {
			this.patientID = patientID;
		}

		public void setDoctorNote(Note doctorNote) {
			this.doctorNote = doctorNote;
		}

		public void setMedicine(Medicine medicine) {
			this.medicine = medicine;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public void setDosage(double dosage) {
			this.dosage = dosage;
		}

		public Prescription Build() {
			return new Prescription(this);
		}

	}

	private Prescription(Builder builder) {

		this.doctorID = builder.doctorID;
		this.patientID = builder.patientID;
		this.doctorNote = builder.doctorNote;
		this.medicine = builder.medicine;
		this.quantity = builder.quantity;
		this.dosage = builder.dosage;
	}

	public String getDoctorID() {
		return doctorID;
	}

	public String getPatientID() {
		return patientID;
	}

	public Note getDoctorNote() {
		return doctorNote;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getDosage() {
		return dosage;
	}

}
