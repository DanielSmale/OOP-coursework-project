package PatientManagmentSystem.Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import PatientManagmentSystem.DataModel.Appointment;
import PatientManagmentSystem.DataModel.DoctorSystem.Doctor;

public class SecretaryController {
	private boolean appendToFile = true;

	public void ReceiveAccountRequest() {

		
	}

	public Doctor[] ReturnDoctorDetails() {
		// Return the all the doctors details and try and match up
		// a free doctor to a patient

		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader("doctorsFile"))) {
			{
				outInfo = reader.readLine();
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONObject allDoctorInfo = new JSONObject(outInfo);

		Doctor[] allDoctors = (Doctor[]) allDoctorInfo.get("Doctors");
		System.out.println(allDoctors);

		return allDoctors;

	}

	public Appointment[] ReturnAppointmentDetails() {
		// Return the all the current appointment details and try and match up
		// a free doctor to a patient

		File appointmentsFile = new File("appointmentsFile");

		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader(appointmentsFile))) {
			{
				outInfo = reader.readLine();
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONObject allAppointmentInfo = new JSONObject(outInfo);

		Appointment[] allAppointments = (Appointment[]) allAppointmentInfo.get("Appointment");
		System.out.println(allAppointments);

		return allAppointments;

	}

	public void StoreAppointmentDetails(Appointment newAppointment) {
		File appointmentsFile = new File("appointmentsFile.json");

		JSONObject appointmentDetails = new JSONObject();
		appointmentDetails.put("AppointmentDate", newAppointment.getDate());
		appointmentDetails.put("PatientID", newAppointment.getPatientID());
		appointmentDetails.put("DoctorID", newAppointment.getDoctorID());

		JSONObject appointment = new JSONObject();
		appointment.put("Appointment", appointmentDetails);

		try (FileWriter writer = new FileWriter(appointmentsFile, appendToFile)) {
			{
				writer.write(appointment.toString());
				writer.flush();

				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("File is located at %s%n", appointmentsFile.getAbsolutePath());
	}

}
