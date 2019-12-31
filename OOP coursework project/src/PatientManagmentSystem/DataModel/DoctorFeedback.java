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

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedbackNotes() {
		return feedbackNotes;
	}

	public void setFeedbackNotes(String feedbackNotes) {
		this.feedbackNotes = feedbackNotes;
	}

	
	
}
