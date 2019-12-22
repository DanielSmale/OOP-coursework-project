package PatientManagmentSystem.DataModel.PatientSystem;

import PatientManagmentSystem.DataModel.AbstractUser;
import PatientManagmentSystem.DataModel.PotentialUser;

public class Patient extends AbstractUser {

	public Patient(String givenName, String surname, String uniqueID, String password) {
		super(givenName, surname, uniqueID, password);

	}

}
