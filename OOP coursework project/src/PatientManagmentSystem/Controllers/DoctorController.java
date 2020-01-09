package PatientManagmentSystem.Controllers;

import PatientManagmentSystem.DataModel.Appointment;
import PatientManagmentSystem.DataModel.MainClass;
import PatientManagmentSystem.DataModel.Medicine;

import PatientManagmentSystem.DataModel.Note;

import PatientManagmentSystem.DataModel.Prescription;
import PatientManagmentSystem.DataModel.DoctorSystem.CreateAppointment;
import PatientManagmentSystem.DataModel.DoctorSystem.MakesNotes;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;

import java.net.IDN;
import java.util.ArrayList;

import PatientManagmentSystem.DataModel.DoctorSystem.PrescribeMedicines;
import javafx.collections.ArrayChangeListener;

import org.json.*;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

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

	public Appointment[] GetPatientHistory(String patientID) {

		Appointment[] allAppointmentsList = ReturnAppointmentsDetails();
		Appointment[] allAppointmentsForSelectedPatient = new Appointment[5];
		// set the array to a size of 5 and resize
		// accordingly

		for (int i = 0; i < allAppointmentsList.length - 1; i++) {

			if (patientID == allAppointmentsList[i].getPatientID()) {
				// if the appointment we're currently looking at has the same id as the patient
				// we want, store it in an array
				allAppointmentsForSelectedPatient[i] = allAppointmentsList[i];
			}

			System.out.println(allAppointmentsForSelectedPatient[i]);

			if (allAppointmentsForSelectedPatient.length < 4) {
				allAppointmentsForSelectedPatient = java.util.Arrays.copyOf(allAppointmentsForSelectedPatient,
						allAppointmentsForSelectedPatient.length + 5);
			}
		}

		return allAppointmentsForSelectedPatient; // and return it
	}

	public void CreateNewPrescription(String doctorID, String patientID, String doctorNotes, String medicineString,
			int quantity, double dosage) {

		Note newNote = new Note(doctorNotes);
		Medicine newMedicine = new Medicine(medicineString, quantity);

		PrescribeMedicines prescribeMedicine = new PrescribeMedicines();
		Prescription newPrescription = prescribeMedicine.NewPrescription(doctorID, patientID, newNote, newMedicine,
				quantity, dosage);

		StorePrescriptionDetails(newPrescription);
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

// this is a problem need to make the array on start up

		JSONArray readAppointments = MainClass.readAppointments;
		
		Appointment[] appointmentsList = new Appointment[readAppointments.length()];

		if (readAppointments == null) {
			System.out.println("JSON array empty");
		} else {
			int length = readAppointments.length();
			for (int i = 0; i < length; i++) {

				JSONObject individualAppointment = readAppointments.getJSONObject(i);

				Appointment nextAppointment = new Appointment(individualAppointment.getString("AppointmentDate"),
						individualAppointment.getString("PatientID"), individualAppointment.getString("DoctorID"));

				appointmentsList[i] = nextAppointment;
			}
		}

		return appointmentsList;
	}

	public void StoreAppointmentDetails(Appointment newAppointment) {

		JSONObject appointmentDetails = new JSONObject();
		appointmentDetails.put("AppointmentDate", newAppointment.getDate());
		appointmentDetails.put("PatientID", newAppointment.getPatientID());
		appointmentDetails.put("DoctorID", newAppointment.getDoctorID());

		JSONArray appointments = new JSONArray();
		appointments.put(appointmentDetails);

		JSONArray readAppointments = MainClass.readAppointments;

		try (FileWriter writer = new FileWriter(appointmentsFile, appendToFile)) {
			{
				writer.write(appointments.toString());
				writer.flush();
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

		JSONObject appointmentDetails = new JSONObject();
		appointmentDetails.put("AppointmentDate", noteToRecord.getRelatedAppointment().getDate());
		appointmentDetails.put("PatientID", noteToRecord.getRelatedAppointment().getPatientID());
		appointmentDetails.put("DoctorID", noteToRecord.getRelatedAppointment().getDoctorID());
		noteDetails.put("relatedAppointment", appointmentDetails);

		File notesFile = new File("notes.json");

		JSONObject note = new JSONObject();
		note.put("Note", noteDetails);

		try (FileWriter writer = new FileWriter(notesFile, appendToFile)) {
			{
				writer.write(note.toString());
				writer.flush();

				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("File is located at %s%n", notesFile.getAbsolutePath());
	}

	public void StorePrescriptionDetails(Prescription prescriptionToRecord) {

		JSONObject prescriptionDetails = new JSONObject();
		prescriptionDetails.put("doctorID", prescriptionToRecord.getDoctorID());
		prescriptionDetails.put("patientID", prescriptionToRecord.getPatientID());

		JSONObject note = new JSONObject();
		note.put("noteString", prescriptionToRecord.getDoctorNote().getNotes());
		note.put("relatedAppointment", prescriptionToRecord.getDoctorNote().getRelatedAppointment());

		prescriptionDetails.put("note", note);

		JSONObject medicine = new JSONObject();
		medicine.put("medicineName", prescriptionToRecord.getMedicine().getMedicineName());

		System.out.println(prescriptionToRecord.getMedicine().getMedicineName());

		System.out.println(medicine.toString());
		System.out.println(medicine.getString("medicineName"));

		prescriptionDetails.put("medicine", medicine);

		prescriptionDetails.put("quantity", prescriptionToRecord.getQuantity());
		prescriptionDetails.put("dosage", prescriptionToRecord.getDosage());

		File prescriptionFile = new File("prescriptionsFile.json");

		JSONArray prescription = new JSONArray();
		prescription.put(prescriptionDetails);

		try (FileWriter writer = new FileWriter(prescriptionFile, appendToFile)) {
			{
				writer.write(prescription.toString());
				writer.flush();

				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("File is located at %s%n", prescriptionFile.getAbsolutePath());
	}
}
