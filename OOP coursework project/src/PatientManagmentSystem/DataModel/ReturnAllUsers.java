package PatientManagmentSystem.DataModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.org.apache.regexp.internal.REUtil;

import PatientManagmentSystem.Controllers.AdministratorController;
import PatientManagmentSystem.DataModel.DoctorSystem.Doctor;
import PatientManagmentSystem.DataModel.PatientSystem.Patient;
import PatientManagmentSystem.DataModel.SecretarySystem.Secretary;

public class ReturnAllUsers {

	private static ReturnAllUsers instance;

	// An implementation of the singleton pattern

	private void AdministratorController() {

	}

	public static ReturnAllUsers getInstance() {
		if (instance == null) {
			instance = new ReturnAllUsers();
		}
		return instance;
	}

	public AbstractUser[] ReturnUsers() {

		AbstractUser[] allUsers;
		Doctor[] doctors = ReturnAllDoctors();
		Patient[] patients = ReturnAllPatients();
		Secretary[] secretaries = ReturnAllSecretarys();

		allUsers = new AbstractUser[doctors.length + patients.length + secretaries.length];

		int i = 0;
		for (i = 0; i < allUsers.length; i++) {
			allUsers[i] = doctors[i];
		}

		for (i = i; i < allUsers.length; i++) {
			allUsers[i] = patients[i];
		}

		for (i = i; i < allUsers.length; i++) {
			allUsers[i] = secretaries[i];
		}
		return allUsers;
	}

	private Doctor[] ReturnAllDoctors() {

		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader("doctorsFile.json"))) {
			{
				outInfo = reader.readLine();

				reader.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONArray readDoctors = new JSONArray();

		Doctor[] doctorsList = new Doctor[readDoctors.length()];

		if (readDoctors == null) {
			System.out.println("JSON array empty");
		} else {
			int length = readDoctors.length();
			for (int i = 0; i < length; i++) {

				JSONObject individualUser = readDoctors.getJSONObject(i);

				Doctor nextDoctor = new Doctor(individualUser.getString("givenName"),
						individualUser.getString("surname"), individualUser.getString("uniqueID"),
						individualUser.getString("password"));

				doctorsList[i] = nextDoctor;
			}
		}
		return doctorsList;
	}

	private Secretary[] ReturnAllSecretarys() {

		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader("secretarysFile.json"))) {
			{
				outInfo = reader.readLine();

				reader.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONArray readSecretarys = new JSONArray();

		Secretary[] secretarysList = new Secretary[readSecretarys.length()];

		if (readSecretarys == null) {
			System.out.println("JSON array empty");
		} else {
			int length = readSecretarys.length();
			for (int i = 0; i < length; i++) {

				JSONObject individualUser = readSecretarys.getJSONObject(i);

				Secretary nextSecretary = new Secretary(individualUser.getString("givenName"),
						individualUser.getString("surname"), individualUser.getString("uniqueID"),
						individualUser.getString("password"));

				secretarysList[i] = nextSecretary;
			}
		}
		return secretarysList;
	}

	private Patient[] ReturnAllPatients() {

		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader("patientsFile.json"))) {
			{
				outInfo = reader.readLine();

				reader.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONArray readPatients = new JSONArray();

		Patient[] patientsList = new Patient[readPatients.length()];

		if (readPatients == null) {
			System.out.println("JSON array empty");
		} else {
			int length = readPatients.length();
			for (int i = 0; i < length; i++) {

				JSONObject individualUser = readPatients.getJSONObject(i);

				Patient nextPatient = new Patient(individualUser.getString("givenName"),
						individualUser.getString("surname"), individualUser.getString("uniqueID"),
						individualUser.getString("password"));

				patientsList[i] = nextPatient;
			}
		}
		return patientsList;
	}

}
