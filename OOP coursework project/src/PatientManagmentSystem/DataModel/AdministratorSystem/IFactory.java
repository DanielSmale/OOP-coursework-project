package PatientManagmentSystem.DataModel.AdministratorSystem;

import PatientManagmentSystem.DataModel.AbstractUser;
import PatientManagmentSystem.DataModel.PotentialUser;

public interface IFactory {

	public abstract AbstractUser CreateUser(String givenName, String surname, String uniqueID, String password,
			String userType);

	
	public abstract AbstractUser CreateUser(PotentialUser potentialUser);
}
