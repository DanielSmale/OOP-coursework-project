package PatientManagmentSystem.Controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PatientManagmentSystem.DataModel.AdministratorSystem.Administrator;
import PatientManagmentSystem.DataModel.DoctorSystem.Doctor;
import PatientManagmentSystem.DataModel.PatientSystem.Patient;
import PatientManagmentSystem.DataModel.SecretarySystem.Secretary;

class AdministratorControllerTest {
	AdministratorController testController;

	@BeforeEach
	void setUp() throws Exception {
		testController = new AdministratorController();
	}

	@Test
	void testStoreDoctorDetails() {

		Doctor t = new Doctor("testing", "testing", "T2", "password");
		testController.StoreDoctorDetails(t, true);

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

		// at length-1 because that is the index of the last object in the
		// file where the next user was put
		assertEquals("testing", inDoctors[length - 1].getGivenName());
		assertEquals("testing", inDoctors[length - 1].getSurname());
		assertEquals("T2", inDoctors[length - 1].getUniqueID());
		assertEquals("password", inDoctors[length - 1].getPassword());

	}

	@Test
	void testStoreSecretaryDetails() {

		Secretary t = new Secretary("testing", "testing", "T2", "password");
		testController.StoreDoctorDetails(t, true);

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

		// at length-1 because that is the index of the last object in the
		// file where the next user was put
		assertEquals("testing", inSecretarys[length - 1].getGivenName());
		assertEquals("testing", inSecretarys[length - 1].getSurname());
		assertEquals("T2", inSecretarys[length - 1].getUniqueID());
		assertEquals("password", inSecretarys[length - 1].getPassword());

	}

	@Test
	void testStorePatientDetails() {

		Patient t = new Patient("testing", "testing", "T2", "password");
		testController.StorePatientDetails(t, true);

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

		// at length-1 because that is the index of the last object in the
		// file where the next user was put
		assertEquals("testing", inPatients[length - 1].getGivenName());
		assertEquals("testing", inPatients[length - 1].getSurname());
		assertEquals("T2", inPatients[length - 1].getUniqueID());
		assertEquals("password", inPatients[length - 1].getPassword());

	}

	@Test
	void testStoreAdministratorDetails() {
		Administrator t = new Administrator("testing", "testing", "T2", "password");
		testController.StorePatientDetails(t, true);

		// Read all the data in
		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader("administratorFile.json"))) {
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
		Administrator[] inAdmin = new Administrator[storedUsers.length()];

		for (int i = 0; i < length; i++) {

			JSONObject currentUser = storedUsers.getJSONObject(i);

			Administrator current = new Administrator(currentUser.getString("givenName"),
					currentUser.getString("surname"), currentUser.getString("uniqueID"),
					currentUser.getString("password"));

			inAdmin[i] = current;

		}

		// at length-1 because that is the index of the last object in the
		// file where the next user was put
		assertEquals("testing", inAdmin[length - 1].getGivenName());
		assertEquals("testing", inAdmin[length - 1].getSurname());
		assertEquals("T2", inAdmin[length - 1].getUniqueID());
		assertEquals("password", inAdmin[length - 1].getPassword());
	}



}
