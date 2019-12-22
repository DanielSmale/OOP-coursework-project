package PatientManagmentSystem.DataModel.AdministratorSystem;

import PatientManagmentSystem.DataModel.AbstractUser;

public interface IFactory {

	public abstract AbstractUser CreateUser(String givenName, String surname, String uniqueID, String password,
			String userType);

}
