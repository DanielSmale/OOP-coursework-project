package PatientManagmentSystem.DataModel.SecretarySystem;

import PatientManagmentSystem.DataModel.AbstractUser;
import PatientManagmentSystem.DataModel.PotentialUser;

public class Secretary extends AbstractUser {

	public Secretary(String givenName, String surname, String uniqueID, String password) {
		super(givenName, surname, uniqueID, password);

	}

}
