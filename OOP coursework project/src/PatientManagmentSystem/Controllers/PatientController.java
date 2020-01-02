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
import PatientManagmentSystem.DataModel.Medicine;
import PatientManagmentSystem.DataModel.Note;
import PatientManagmentSystem.DataModel.Prescription;
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
		for (int i = 0; i == allAppointmentsList.length - 1; i++) {
			System.out.println(allAppointmentsList[i]);
			if (patientID.equals(allAppointmentsList[i].getPatientID())) {
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

		JSONArray outAppointments = new JSONArray(outInfo);

		Appointment[] appointmentsList = new Appointment[outAppointments.length()];

		if (outAppointments == null) {
			System.out.println("JSON array empty");
		} else {
			int length = outAppointments.length();
			System.out.println(length);
			for (int i = 0; i < length - 1; i++) {

				JSONObject individualAppointment = outAppointments.getJSONObject(i);

				Appointment nextAppointment = new Appointment(individualAppointment.getString("AppointmentDate"),
						individualAppointment.getString("PatientID"), individualAppointment.getString("DoctorID"));

				appointmentsList[i] = nextAppointment;

			}
		}

		return appointmentsList;
	}

	public Prescription[] ReturnPrescriptionDetails() {

		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader("prescriptionsFile.json"))) {
			{
				outInfo = reader.readLine();

				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONArray outPrescriptions = new JSONArray(outInfo);

		Prescription[] prescriptionsList = new Prescription[outPrescriptions.length()];

		if (outPrescriptions == null) {
			System.out.println("JSON array empty");
		} else {
			int length = outPrescriptions.length();
			for (int i = 0; i < length; i++) {

				JSONObject individualPrescription = outPrescriptions.getJSONObject(i);

				JSONObject outMedicine = (JSONObject) individualPrescription.get("medicine");
				Medicine attachedMedicine = new Medicine(outMedicine.getString("medicineName"),
						outMedicine.getInt("stock"));

				JSONObject outNote = (JSONObject) individualPrescription.get("note");

				Note attachedNote = new Note(outNote.getString("noteString"));

				Prescription nextPrescription = new Prescription(individualPrescription.getString("doctorID"),
						individualPrescription.getString("patientID"), attachedNote, attachedMedicine,
						individualPrescription.getInt("quantity"), individualPrescription.getDouble("dosage"));

				prescriptionsList[i] = nextPrescription;

			}
		}

		return prescriptionsList;
	}

}
