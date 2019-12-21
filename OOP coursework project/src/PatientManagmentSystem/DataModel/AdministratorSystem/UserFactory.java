package PatientManagmentSystem.DataModel.AdministratorSystem;

import PatientManagmentSystem.Controllers.AdministratorController;
import PatientManagmentSystem.Controllers.SecretaryController;
import PatientManagmentSystem.DataModel.AbstractUser;
import PatientManagmentSystem.DataModel.DoctorSystem.Doctor;
import PatientManagmentSystem.DataModel.PatientSystem.Patient;
import PatientManagmentSystem.DataModel.SecretarySystem.Secretary;

public class UserFactory implements IFactory {
	AdministratorController administratorController = new AdministratorController();

	public AbstractUser CreateUser(String userType) {

		AbstractUser user;
		switch (userType) {
		case "Doctor":
			user = new Doctor(administratorController.SendPotentialUserDetails());
			administratorController.StoreDoctorDetails(user);
		case "Secretary":
			user = new Secretary(administratorController.SendPotentialUserDetails());
			administratorController.StoreSecretaryDetails(user);
		case "Patient":
			user = new Patient(administratorController.SendPotentialUserDetails());
			administratorController.StorePatientDetails(user);
		default:
			user = null;
		}
		return user;
	}
}
