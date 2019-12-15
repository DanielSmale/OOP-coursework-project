package PatientManagmentSystem.Controllers;

import PatientManagmentSystem.DataModel.DoctorSystem.CreateAppointment;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.*;

public class DoctorController {
	File appointmentsFile = new File("appointments.json");

	
	
	public CreateAppointment SendAppointmentDetails(String date, String patientID, String doctorID) {
		CreateAppointment newAppointment = new CreateAppointment(date, patientID, doctorID);

		StoreAppointmentDetails(newAppointment);

		return newAppointment;
	}

	public void ReturnAppointmentDetails() {
		
	try(FileReader reader = new FileReader(appointmentsFile)){
		
		
		reader.read();
		
		reader.close();
	}catch(IOException e) {
		e.printStackTrace();
	}
	
	
		
	}
	
	
	private void StoreAppointmentDetails(CreateAppointment appointmentToStore) {

		JSONObject appointmentDetails = new JSONObject();
		appointmentDetails.put("AppointmentDate", appointmentToStore.date);
		appointmentDetails.put("PatientID", appointmentToStore.patientID);
		appointmentDetails.put("DoctorID", appointmentToStore.doctorID);

		JSONObject appointment = new JSONObject();
		appointment.put("Appointment", appointmentDetails);

		
		
		try (FileWriter writer = new FileWriter(appointmentsFile,true)) {
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
