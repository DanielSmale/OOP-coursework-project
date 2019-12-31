package PatientManagmentSystem.DataModel.PatientSystem;

import PatientManagmentSystem.Controllers.AdministratorController;
import PatientManagmentSystem.Controllers.DoctorController;
import PatientManagmentSystem.Controllers.PatientController;
import PatientManagmentSystem.DataModel.DoctorFeedback;
import PatientManagmentSystem.DataModel.AdministratorSystem.ReceivePatientFeedback;

public class GiveFeedback {

	public void GiveFeedback(String doctorID, int rating, String feedbackNotes) {
		DoctorFeedback doctorFeedback = new DoctorFeedback(doctorID, rating, feedbackNotes);

		PatientController patientController = new PatientController();

		patientController.StoreFeedback(doctorFeedback);
	}

}
