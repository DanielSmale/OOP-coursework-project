package PatientManagmentSystem.Controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

import PatientManagmentSystem.DataModel.AbstractUser;
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
