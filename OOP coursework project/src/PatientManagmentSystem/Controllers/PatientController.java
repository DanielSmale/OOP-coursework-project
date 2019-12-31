package PatientManagmentSystem.Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import PatientManagmentSystem.DataModel.Appointment;
import PatientManagmentSystem.DataModel.DoctorFeedback;
import PatientManagmentSystem.DataModel.PatientSystem.AppointmentRequest;
import PatientManagmentSystem.DataModel.PatientSystem.GiveFeedback;

public class PatientController {
	private boolean appendToFile = true;

	public void CreateAppointmentRequest(String preferedDoctorID, String thisPatientID, String[] preferedDates) {

		AppointmentRequest appointmentRequest = new AppointmentRequest();
		appointmentRequest.AppointmentRequest(preferedDoctorID, thisPatientID, preferedDates);

	}

	public Appointment[] GetPatientHistory(String patientID) {

		Appointment[] allAppointmentsList = ReturnAppointmentsDetails();
		Appointment[] allAppointmentsForSelectedPatient = new Appointment[5]; // set the array to a size of 5 and resize
																				// accordingly

		for (int i = 0; i < allAppointmentsList.length - 1; i++) {

			if (patientID == allAppointmentsList[i].getPatientID()) {
				// if the appointment we're currently looking at has the same id as the patient
				// we want, store it in an array
				allAppointmentsForSelectedPatient[i] = allAppointmentsList[i];
			}

			if (allAppointmentsForSelectedPatient.length < 4) {
				allAppointmentsForSelectedPatient = java.util.Arrays.copyOf(allAppointmentsForSelectedPatient,
						allAppointmentsForSelectedPatient.length + 5);
			}
		}

		return allAppointmentsForSelectedPatient; // and return it
	}

	public void SendDoctorFeedback(String doctorID, int rating, String feedbackNotes) {

		GiveFeedback giveFeedback = new GiveFeedback();
		giveFeedback.GiveFeedback(doctorID, rating, feedbackNotes);

	}

	public void StoreFeedback(DoctorFeedback feedback) {

		JSONObject feedbackDetails = new JSONObject();
		feedbackDetails.put("doctorID", feedback.getDoctorID());
		feedbackDetails.put("rating", feedback.getRating());
		feedbackDetails.put("feedback", feedback.getFeedbackNotes());

		File feedbackFile = new File("feedbackFile.json");

		JSONArray storedFeedback = new JSONArray();
		storedFeedback.put(feedbackDetails);

		try (FileWriter writer = new FileWriter(feedbackFile, appendToFile)) {
			{
				writer.write(storedFeedback.toString());

				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("File is located at %s%n", feedbackFile.getAbsolutePath());
	}

	public Appointment[] ReturnAppointmentsDetails() {

		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader("appointmentsFile.json"))) {
			{
				outInfo = reader.readLine();

				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONArray readAppointments = new JSONArray(outInfo);

		Appointment[] appointmentsList = new Appointment[readAppointments.length()];

		if (readAppointments == null) {
			System.out.println("JSON array empty");
		} else {
			int length = readAppointments.length();
			for (int i = 0; i < length; i++) {

				JSONObject individualAppointment = readAppointments.getJSONObject(i);

				Appointment nextAppointment = new Appointment(individualAppointment.getString("AppointmentDate"),
						individualAppointment.getString("DoctorID"), individualAppointment.getString("PatientID"));

				appointmentsList[i] = nextAppointment;

			}
		}

		return appointmentsList;
	}

}
