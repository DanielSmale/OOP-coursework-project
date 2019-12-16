package PatientManagmentSystem.Controllers;

import PatientManagmentSystem.DataModel.DoctorSystem.CreateAppointment;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.*;

public class DoctorController {
	File appointmentsFile = new File("appointments.json");

	public CreateAppointment SendAppointmentDetails(String date, String patientID, String doctorID) {
		CreateAppointment newAppointment = new CreateAppointment(date, patientID, doctorID);

		StoreAppointmentDetails(newAppointment);

		return newAppointment;
	}

	public String ReturnAppointmentDetails() {

		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader("appointments.json"))) {
			{
				outInfo = reader.readLine();

				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONObject readAppointment = new JSONObject(outInfo);


		return readAppointment.toString();
	}

	private void StoreAppointmentDetails(CreateAppointment appointmentToStore) {

		JSONObject appointmentDetails = new JSONObject();
		appointmentDetails.put("AppointmentDate", appointmentToStore.date);
		appointmentDetails.put("PatientID", appointmentToStore.patientID);
		appointmentDetails.put("DoctorID", appointmentToStore.doctorID);

		JSONObject appointment = new JSONObject();
		appointment.put("Appointment", appointmentDetails);

		try (FileWriter writer = new FileWriter(appointmentsFile, true)) {
			{
				writer.write(appointment.toString());

				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("File is located at %s%n", appointmentsFile.getAbsolutePath());
	}

}
