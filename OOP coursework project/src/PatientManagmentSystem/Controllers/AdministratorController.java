package PatientManagmentSystem.Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import PatientManagmentSystem.DataModel.AbstractUser;
import PatientManagmentSystem.DataModel.DoctorFeedback;
import PatientManagmentSystem.DataModel.PotentialUser;
import PatientManagmentSystem.DataModel.AdministratorSystem.Administrator;
import PatientManagmentSystem.DataModel.AdministratorSystem.UserFactory;

public class AdministratorController {

	PotentialUser potentialUser;

	private boolean appendToFile = true;

	public void ReceivePotentialUserDetails(String givenName, String surname, String uniqueID, String password,
			String userType) {

		UserFactory userFactory = new UserFactory();

		userFactory.CreateUser(givenName, surname, uniqueID, password, userType);

	}

	public void RemoveUser(String userID) {
		
		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader("feedbackFile.json"))) {
			{
				outInfo = reader.readLine();

				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONArray storedFeedback = new JSONArray(outInfo);

		int length = storedFeedback.length();
		DoctorFeedback[] readFeedback = new DoctorFeedback[storedFeedback.length()];
		for (int i = 0; i < length; i++) {

			JSONObject feedback = storedFeedback.getJSONObject(i);

			DoctorFeedback current = new DoctorFeedback(feedback.getString("doctorID"), feedback.getInt("rating"),
					feedback.getString("feedback"));

			readFeedback[i] = current;

		}
		
	}
	
	public DoctorFeedback[] ReturnFeedbackDetails() {

		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader("feedbackFile.json"))) {
			{
				outInfo = reader.readLine();

				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONArray storedFeedback = new JSONArray(outInfo);

		int length = storedFeedback.length();
		DoctorFeedback[] readFeedback = new DoctorFeedback[storedFeedback.length()];
		for (int i = 0; i < length; i++) {

			JSONObject feedback = storedFeedback.getJSONObject(i);

			DoctorFeedback current = new DoctorFeedback(feedback.getString("doctorID"), feedback.getInt("rating"),
					feedback.getString("feedback"));

			readFeedback[i] = current;

		}

		return readFeedback;
	}

	public void StoreEdittedFeedback(DoctorFeedback feedback) {

		JSONObject feedbackDetails = new JSONObject();
		feedbackDetails.put("doctorID", feedback.getDoctorID());
		feedbackDetails.put("rating", feedback.getRating());
		feedbackDetails.put("feedback", feedback.getFeedbackNotes());

		File edittedFeedbackFile = new File("edittedFeedbackFile.json");

		JSONArray storedFeedback = new JSONArray();
		storedFeedback.put(feedbackDetails);

		try (FileWriter writer = new FileWriter(edittedFeedbackFile, appendToFile)) {
			{
				writer.write(storedFeedback.toString());

				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("File is located at %s%n", edittedFeedbackFile.getAbsolutePath());
	}
	
	
	public void StoreDoctorDetails(AbstractUser doctorToStore) {
		File doctorsFile = new File("doctorsFile.json");

		JSONObject doctorDetails = new JSONObject();
		doctorDetails.put("givenName", doctorToStore.getGivenName());
		doctorDetails.put("surname", doctorToStore.getSurname());
		doctorDetails.put("uniqueID", doctorToStore.getUniqueID());
		doctorDetails.put("password", doctorToStore.getPassword());

		JSONObject doctor = new JSONObject();
		doctor.put("Doctor", doctorDetails);

		try (FileWriter writer = new FileWriter(doctorsFile, appendToFile)) {
			{
				writer.write(doctor.toString());

				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("File is located at %s%n", doctorsFile.getAbsolutePath());
	}

	public void StoreSecretaryDetails(AbstractUser secretaryToStore) {
		File secretarysFile = new File("secretaryFile.json");

		JSONObject secretaryDetails = new JSONObject();
		secretaryDetails.put("givenName", secretaryToStore.getGivenName());
		secretaryDetails.put("surname", secretaryToStore.getSurname());
		secretaryDetails.put("uniqueID", secretaryToStore.getUniqueID());
		secretaryDetails.put("password", secretaryToStore.getPassword());

		JSONObject secretary = new JSONObject();
		secretary.put("Secretary", secretaryDetails);

		try (FileWriter writer = new FileWriter(secretarysFile, appendToFile)) {
			{
				writer.write(secretary.toString());

				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("File is located at %s%n", secretarysFile.getAbsolutePath());
	}

	public void StorePatientDetails(AbstractUser patientToStore) {
		File patientFile = new File("patientsFile.json");

		JSONObject patientDetails = new JSONObject();
		patientDetails.put("givenName", patientToStore.getGivenName());
		patientDetails.put("surname", patientToStore.getSurname());
		patientDetails.put("uniqueID", patientToStore.getUniqueID());
		patientDetails.put("password", patientToStore.getPassword());

		JSONObject secretary = new JSONObject();
		secretary.put("Patient", patientDetails);

		try (FileWriter writer = new FileWriter(patientFile, appendToFile)) {
			{
				writer.write(secretary.toString());

				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("File is located at %s%n", patientFile.getAbsolutePath());
	}

	public void StoreAdministratorDetails(Administrator administratorToStore) {
		File administratorFile = new File("administratorFile.json");

		JSONObject administratorDetails = new JSONObject();
		administratorDetails.put("givenName", administratorToStore.getGivenName());
		administratorDetails.put("surname", administratorToStore.getSurname());
		administratorDetails.put("uniqueID", administratorToStore.getUniqueID());
		administratorDetails.put("password", administratorToStore.getPassword());

		JSONObject administrator = new JSONObject();
		administrator.put("Administrator", administratorDetails);

		try (FileWriter writer = new FileWriter(administratorFile, appendToFile)) {
			{
				writer.write(administrator.toString());

				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("File is located at %s%n", administratorFile.getAbsolutePath());
	}
}
