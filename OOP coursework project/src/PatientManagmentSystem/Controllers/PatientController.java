package PatientManagmentSystem.Controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import PatientManagmentSystem.DataModel.Appointment;
import PatientManagmentSystem.DataModel.PatientSystem.AppointmentRequest;
import PatientManagmentSystem.DataModel.PatientSystem.GiveFeedback;

public class PatientController {

	public void CreateAppointmentRequest(String preferedDoctorID, String thisPatientID, String[] preferedDates) {

		AppointmentRequest appointmentRequest = new AppointmentRequest();
		appointmentRequest.AppointmentRequest(preferedDoctorID, thisPatientID, preferedDates);

	}

	public void SendDoctorFeedback(String doctorID, int rating, String feedbackNotes) {

		GiveFeedback giveFeedback = new GiveFeedback();
		giveFeedback.GiveFeedback(doctorID, rating, feedbackNotes);

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
