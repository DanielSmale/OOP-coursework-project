package PatientManagmentSystem.DataModel.DoctorSystem;

import PatientManagmentSystem.DataModel.Medicine;
import PatientManagmentSystem.DataModel.Note;
import PatientManagmentSystem.DataModel.Prescription;

public class PrescribeMedicines {

	public void NewPrescription(String doctorID, String patientID, Note doctorNote, Medicine medicine, int quantity,
			double dosage) {

		Prescription newPrescription = new Prescription(doctorID, patientID, doctorNote, medicine, quantity, dosage);

	}

}
