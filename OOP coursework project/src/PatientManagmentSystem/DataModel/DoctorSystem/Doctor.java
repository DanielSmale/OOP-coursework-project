package PatientManagmentSystem.DataModel.DoctorSystem;

import PatientManagmentSystem.DataModel.AbstractUser;
import PatientManagmentSystem.DataModel.PotentialUser;
import sun.net.www.content.text.plain;

public class Doctor extends AbstractUser {

	public Doctor(String givenName, String surname, String uniqueID, String password) {
		super(givenName, surname, uniqueID, password);

	}

	public Doctor(PotentialUser potentialUserDetails) {
		super(potentialUserDetails);
	}

}
