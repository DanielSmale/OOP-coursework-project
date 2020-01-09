package PatientManagmentSystem.Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

import PatientManagmentSystem.DataModel.AbstractUser;
import PatientManagmentSystem.DataModel.DoctorFeedback;
import PatientManagmentSystem.DataModel.PotentialUser;
import PatientManagmentSystem.DataModel.AdministratorSystem.Administrator;
import PatientManagmentSystem.DataModel.AdministratorSystem.UserFactory;
import PatientManagmentSystem.DataModel.DoctorSystem.Doctor;
import PatientManagmentSystem.DataModel.PatientSystem.Patient;
import PatientManagmentSystem.DataModel.SecretarySystem.Secretary;
import sun.print.resources.serviceui;
import sun.security.util.ArrayUtil;

public class AdministratorController {
	private static AdministratorController instance;

	// An implementation of the singleton pattern

	private void AdministratorController() {

	}

	public static AdministratorController getInstance() {
		if (instance == null) {
			instance = new AdministratorController();
		}
		return instance;
	}

	PotentialUser potentialUser;

	private boolean appendToFile = true; // Whether or not we are going to overwrite the JSON file
	// or add to the end of it

	public void ReceivePotentialUserDetails(String givenName, String surname, String uniqueID, String password,
			String userType) {
// Called from the administrators create users GUI. This method takes the provided data and passes it on to the userFactory to decide which user to add
		UserFactory userFactory = new UserFactory();

		userFactory.CreateUser(givenName, surname, uniqueID, password, userType);

	}

	public void RemoveDoctor(String IDtoRemove) {

		// Read all the data in
		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader("doctorsFile.json"))) {
			{
				outInfo = reader.readLine();

				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// De-serialise it
		JSONArray storedUsers = new JSONArray(outInfo);

		int length = storedUsers.length();
		Doctor[] inDoctors = new Doctor[storedUsers.length()];

		for (int i = 0; i < length; i++) {

			JSONObject currentUser = storedUsers.getJSONObject(i);

			Doctor current = new Doctor(currentUser.getString("givenName"), currentUser.getString("surname"),
					currentUser.getString("uniqueID"), currentUser.getString("password"));

			inDoctors[i] = current;

		}

		// Iterate through the users and remove the selected one based on their ID

		for (int i = 0; i < inDoctors.length; i++) {

			if (inDoctors[i].getUniqueID() != IDtoRemove) { // if its not the user we want to remove

				inDoctors[i] = inDoctors[i]; // this will drop the old user from the array of users

			}
		}

		// now store it again
		for (int i = 0; i < inDoctors.length; i++) {

			StoreDoctorDetails(inDoctors[i], false);
		}
	}

	public void RemovePatient(String IDtoRemove) {

		// Read all the data in
		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader("patientsFile.json"))) {
			{
				outInfo = reader.readLine();

				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// De-serialise it
		JSONArray storedUsers = new JSONArray(outInfo);

		int length = storedUsers.length();
		Patient[] inPatients = new Patient[storedUsers.length()];

		for (int i = 0; i < length; i++) {

			JSONObject currentUser = storedUsers.getJSONObject(i);

			Patient current = new Patient(currentUser.getString("givenName"), currentUser.getString("surname"),
					currentUser.getString("uniqueID"), currentUser.getString("password"));

			inPatients[i] = current;

		}

		// Iterate through the users and remove the selected one based on their ID

		for (int i = 0; i < inPatients.length; i++) {

			if (inPatients[i].getUniqueID() != IDtoRemove) { // if its not the user we want to remove

				inPatients[i] = inPatients[i]; // this will drop the old user from the array of users

			}
		}

		// now store it again
		for (int i = 0; i < inPatients.length; i++) {

			StorePatientDetails(inPatients[i], false);
		}
	}

	public void RemoveSecretary(String IDtoRemove) {

		// Read all the data in
		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader("secretarysFile.json"))) {
			{
				outInfo = reader.readLine();

				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// De-serialise it
		JSONArray storedUsers = new JSONArray(outInfo);

		int length = storedUsers.length();
		Secretary[] inSecretarys = new Secretary[storedUsers.length()];

		for (int i = 0; i < length; i++) {

			JSONObject currentUser = storedUsers.getJSONObject(i);

			Secretary current = new Secretary(currentUser.getString("givenName"), currentUser.getString("surname"),
					currentUser.getString("uniqueID"), currentUser.getString("password"));

			inSecretarys[i] = current;

		}

		// Iterate through the users and remove the selected one based on their ID

		for (int i = 0; i < inSecretarys.length; i++) {

			if (inSecretarys[i].getUniqueID() != IDtoRemove) { // if its not the user we want to remove

				inSecretarys[i] = inSecretarys[i]; // this will drop the old user from the array of users

			}
		}

		// now store it again
		for (int i = 0; i < inSecretarys.length; i++) {

			StoreSecretaryDetails(inSecretarys[i], false);
		}
	}

	public DoctorFeedback[] ReturnFeedbackDetails() {
//This method passes feedback to the edit feedback GUI
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
				writer.flush();

				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("File is located at %s%n", edittedFeedbackFile.getAbsolutePath());
	}

	public void StoreDoctorDetails(AbstractUser doctorToStore, boolean appendToFile) {
		File doctorsFile = new File("doctorsFile.json");
		// This method is called from the User Factory class
		// After the user is created, serialise them to the file

		JSONObject doctorDetails = new JSONObject();
		doctorDetails.put("givenName", doctorToStore.getGivenName());
		doctorDetails.put("surname", doctorToStore.getSurname());
		doctorDetails.put("uniqueID", doctorToStore.getUniqueID());
		doctorDetails.put("password", doctorToStore.getPassword());

		JSONArray doctor = new JSONArray();
		doctor.put(doctorDetails);

		try (FileWriter writer = new FileWriter(doctorsFile, appendToFile)) {
			{
				writer.write(doctor.toString());
				writer.flush();

				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("File is located at %s%n", doctorsFile.getAbsolutePath());
	}

	public void StoreSecretaryDetails(AbstractUser secretaryToStore, boolean appendToFile) {
		File secretarysFile = new File("secretarysFile.json");
		// This method is called from the User Factory class
		// After the user is created, serialise them to the file

		JSONObject secretaryDetails = new JSONObject();
		secretaryDetails.put("givenName", secretaryToStore.getGivenName());
		secretaryDetails.put("surname", secretaryToStore.getSurname());
		secretaryDetails.put("uniqueID", secretaryToStore.getUniqueID());
		secretaryDetails.put("password", secretaryToStore.getPassword());

		JSONArray secretary = new JSONArray();
		secretary.put(secretaryDetails);

		try (FileWriter writer = new FileWriter(secretarysFile, appendToFile)) {
			{
				writer.write(secretary.toString());
				writer.flush();

				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("File is located at %s%n", secretarysFile.getAbsolutePath());
	}

	public void StorePatientDetails(AbstractUser patientToStore, boolean appendToFile) {
		File patientFile = new File("patientsFile.json");
		// This method is called from the User Factory class
		// After the user is created, serialise them to the file

		JSONObject patientDetails = new JSONObject();
		patientDetails.put("givenName", patientToStore.getGivenName());
		patientDetails.put("surname", patientToStore.getSurname());
		patientDetails.put("uniqueID", patientToStore.getUniqueID());
		patientDetails.put("password", patientToStore.getPassword());

		JSONArray patient = new JSONArray();
		patient.put(patientDetails);

		try (FileWriter writer = new FileWriter(patientFile, appendToFile)) {
			{
				writer.write(patient.toString());
				writer.flush();

				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("File is located at %s%n", patientFile.getAbsolutePath());
	}

	public void StoreAdministratorDetails(Administrator administratorToStore, boolean appendToFile) {
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
				writer.flush();

				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("File is located at %s%n", administratorFile.getAbsolutePath());
	}
}
