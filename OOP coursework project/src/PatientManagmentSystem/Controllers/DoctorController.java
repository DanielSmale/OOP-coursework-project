package PatientManagmentSystem.Controllers;

import PatientManagmentSystem.DataModel.Appointment;
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
	Appointment newAppointment;
	private boolean appendToFile = true;

	public void SendAppointmentDetails(String date, String patientID, String doctorID) {
		newAppointment = new Appointment(date, patientID, doctorID); // Overwrite the old appointment and add it
																			// to the
																			// text file

		StoreAppointmentDetails(newAppointment);
	}

	public void SendNotes(String notes) {

		Note note = new Note(notes);
		
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

	private void StoreAppointmentDetails(Appointment newAppointment) {

		JSONObject appointmentDetails = new JSONObject();
		appointmentDetails.put("AppointmentDate", newAppointment.getDate());
		appointmentDetails.put("PatientID", newAppointment.getPatientID());
		appointmentDetails.put("DoctorID", newAppointment.getDoctorID());
		// appointmentDetails.put("Notes", appointmentToStore.getNotes().notes); errors

		JSONObject appointment = new JSONObject();
		appointment.put("Appointment", appointmentDetails);

		try (FileWriter writer = new FileWriter(appointmentsFile, appendToFile)) {
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
