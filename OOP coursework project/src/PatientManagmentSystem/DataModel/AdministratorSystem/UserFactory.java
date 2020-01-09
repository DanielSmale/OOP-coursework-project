package PatientManagmentSystem.DataModel.AdministratorSystem;

import PatientManagmentSystem.Controllers.AdministratorController;
import PatientManagmentSystem.Controllers.SecretaryController;
import PatientManagmentSystem.DataModel.AbstractUser;
import PatientManagmentSystem.DataModel.DoctorSystem.Doctor;
import PatientManagmentSystem.DataModel.PatientSystem.Patient;
import PatientManagmentSystem.DataModel.SecretarySystem.Secretary;

public class UserFactory implements IFactory {


	@Override
	public AbstractUser CreateUser(String givenName, String surname, String uniqueID, String password,
			String userType) {

		AbstractUser user;
		switch (userType) {
		case "Doctor":
			user = new Doctor(givenName, surname, uniqueID, password);
			AdministratorController.getInstance().StoreDoctorDetails(user, true);
			break;
		case "Secretary":
			user = new Secretary(givenName, surname, uniqueID, password);
			AdministratorController.getInstance().StoreSecretaryDetails(user, true);
			break;
		case "Patient":
			user = new Patient(givenName, surname, uniqueID, password);
			AdministratorController.getInstance().StorePatientDetails(user, true);
			break;
		default:
			user = null;
		}

		return user;
	}
}
