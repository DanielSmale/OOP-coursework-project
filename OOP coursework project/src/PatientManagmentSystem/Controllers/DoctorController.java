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
	File appointmentsFile = new File("appointmentsFile.json");
	private boolean appendToFile = true;

	public void SendAppointmentDetails(String date, String patientID, String doctorID) {
		Appointment nextAppointment = new Appointment(date, patientID, doctorID);

		StoreAppointmentDetails(nextAppointment);
	}

	public void SendNotes(String notes, String date, String patientID, String doctorID) {

		Note note = new Note(notes);

		Appointment relatedAppointment = new Appointment(date, doctorID, patientID);
		note.setRelatedAppointment(relatedAppointment);

		StoreNoteDetails(note);
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

	private void StoreAppointmentDetails(Appointment newAppointment) {

		JSONObject appointmentDetails = new JSONObject();
		appointmentDetails.put("AppointmentDate", newAppointment.getDate());
		appointmentDetails.put("PatientID", newAppointment.getPatientID());
		appointmentDetails.put("DoctorID", newAppointment.getDoctorID());

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

	private void StoreNoteDetails(Note noteToRecord) {

		JSONObject noteDetails = new JSONObject();
		noteDetails.put("noteString", noteToRecord.getNotes());
		noteDetails.put("relatedAppointment", noteToRecord.getRelatedAppointment());
		File notesFile = new File("notes.json");

		JSONObject note = new JSONObject();
		note.put("Note", noteDetails);

		try (FileWriter writer = new FileWriter(notesFile, appendToFile)) {
			{
				writer.write(note.toString());

				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("File is located at %s%n", notesFile.getAbsolutePath());
	}
}
