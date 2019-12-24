package PatientManagmentSystem.Controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;

import PatientManagmentSystem.DataModel.PatientSystem.AppointmentRequest;

public class PatientController {

	public void CreateAppointmentRequest(String preferedDoctorID, String thisPatientID, String[] preferedDates) {

		AppointmentRequest appointmentRequest = new AppointmentRequest();
		appointmentRequest.AppointmentRequest(preferedDoctorID, thisPatientID, preferedDates);

	}

	public String ReturnAppointmentDetails() {

		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader("appointmentsFile.json"))) {
			{
				outInfo = reader.readLine();

				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONObject readAppointments = new JSONObject(outInfo);

		return readAppointments.toString();
	}

}
