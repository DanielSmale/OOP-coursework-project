package PatientManagmentSystem.Controllers;

import PatientManagmentSystem.DataModel.Note;
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
	CreateAppointment newAppointment;

	public CreateAppointment SendAppointmentDetails(String date, String patientID, String doctorID) {
		newAppointment = new CreateAppointment(date, patientID, doctorID); // Overwrite the old appointment and add it
																			// to the
																			// text file

		StoreAppointmentDetails(newAppointment);

		return newAppointment;
	}

	public void SendNotes(String notes) {

		Note note = new Note(newAppointment, notes);
		newAppointment.setNotes(note);

	}

	public String ReturnAppointmentDetails() {

		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader(appointmentsFile))) {
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
		appointmentDetails.put("AppointmentDate", appointmentToStore.getDate());
		appointmentDetails.put("PatientID", appointmentToStore.getPatientID());
		appointmentDetails.put("DoctorID", appointmentToStore.getDoctorID());
		// appointmentDetails.put("Notes", appointmentToStore.getNotes().notes); errors

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
