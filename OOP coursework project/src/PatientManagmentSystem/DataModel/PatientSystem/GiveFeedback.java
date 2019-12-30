package PatientManagmentSystem.DataModel.PatientSystem;

import PatientManagmentSystem.DataModel.DoctorFeedback;

public class GiveFeedback {

	public void GiveFeedback(String doctorID, int rating, String feedbackNotes) {
		DoctorFeedback doctorFeedback = new DoctorFeedback(doctorID, rating, feedbackNotes);
	}

}
