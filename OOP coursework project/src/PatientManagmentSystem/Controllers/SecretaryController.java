package PatientManagmentSystem.Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import PatientManagmentSystem.DataModel.Appointment;
import PatientManagmentSystem.DataModel.DoctorFeedback;
import PatientManagmentSystem.DataModel.Medicine;
import PatientManagmentSystem.DataModel.PotentialUser;
import PatientManagmentSystem.DataModel.DoctorSystem.Doctor;

public class SecretaryController {
	private boolean appendToFile = true;

	public void ReceiveAccountRequest(String givenName, String surname, String uniqueID, String password,
			String userType) {

		PotentialUser potentialUser = new PotentialUser(givenName, surname, uniqueID, password, userType);

		AdministratorController.getInstance().ReceivePotentialUserDetails(potentialUser);
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
		// this might be wrong
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
	JSONArray medicine = new JSONArray();

	public void StoreMedicineDetails(Medicine newMedicine, boolean appendToFile) {
		File medicinesFile = new File("medicinesFile.json");

		JSONObject medcineDetails = new JSONObject();
		medcineDetails.put("medicineName", newMedicine.getMedicineName());
		medcineDetails.put("stock", newMedicine.getStock());

		medicine.put(medcineDetails);

		try (FileWriter writer = new FileWriter(medicinesFile, appendToFile)) {

			writer.write(medicine.toString());

			writer.flush();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("File is located at %s%n", medicinesFile.getAbsolutePath());

	}

	public Medicine[] ReturnMedicines() {

		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader("medicinesFile.json"))) {
			outInfo = reader.readLine();

			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONArray storedMedicines = new JSONArray(outInfo);

		int length = storedMedicines.length();
		Medicine[] readMedicines = new Medicine[storedMedicines.length()];
		for (int i = 0; i < length; i++) {

			JSONObject medicine = storedMedicines.getJSONObject(i);

			Medicine current = new Medicine(medicine.getString("medicineName"), medicine.getInt("stock"));
			readMedicines[i] = current;

		}
		return readMedicines;
	}

}
