package PatientManagmentSystem.DataModel;

public class DoctorFeedback {

	private String doctorID;
	private int rating;
	private String feedbackNotes;

	public DoctorFeedback(String doctorID, int rating, String feedbackNotes) {
		super();
		this.doctorID = doctorID;
		this.rating = rating;
		this.feedbackNotes = feedbackNotes;
	}

}
