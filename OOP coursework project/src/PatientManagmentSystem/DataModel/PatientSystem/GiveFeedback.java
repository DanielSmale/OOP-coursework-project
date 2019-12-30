package PatientManagmentSystem.DataModel.PatientSystem;

import PatientManagmentSystem.Controllers.AdministratorController;
import PatientManagmentSystem.DataModel.DoctorFeedback;

public class GiveFeedback {
	AdministratorController administratorController;

	public void GiveFeedback(String doctorID, int rating, String feedbackNotes) {
		DoctorFeedback doctorFeedback = new DoctorFeedback(doctorID, rating, feedbackNotes);

		administratorController.ReceivePatientFeedback(doctorFeedback);
	}

}
