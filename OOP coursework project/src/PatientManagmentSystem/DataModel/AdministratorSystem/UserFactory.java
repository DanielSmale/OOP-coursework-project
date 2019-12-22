package PatientManagmentSystem.DataModel.AdministratorSystem;

import PatientManagmentSystem.Controllers.AdministratorController;
import PatientManagmentSystem.Controllers.SecretaryController;
import PatientManagmentSystem.DataModel.AbstractUser;
import PatientManagmentSystem.DataModel.DoctorSystem.Doctor;
import PatientManagmentSystem.DataModel.PatientSystem.Patient;
import PatientManagmentSystem.DataModel.SecretarySystem.Secretary;

public class UserFactory implements IFactory {
	AdministratorController administratorController = new AdministratorController();

	public AbstractUser CreateUser(String givenName, String surname, String uniqueID, String password,
			String userType) {

		AbstractUser user;
		switch (userType) {
		case "Doctor":
			user = new Doctor(givenName, surname, uniqueID, password);
			administratorController.StoreDoctorDetails(user);
			break;
		case "Secretary":
			user = new Secretary(givenName, surname, uniqueID, password);
			administratorController.StoreSecretaryDetails(user);
			break;
		case "Patient":
			user = new Patient(givenName, surname, uniqueID, password);
			administratorController.StorePatientDetails(user);
			break;
		default:
			user = null;
		}

		return user;
	}
}
