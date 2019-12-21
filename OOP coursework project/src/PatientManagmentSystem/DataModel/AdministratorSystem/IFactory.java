package PatientManagmentSystem.DataModel.AdministratorSystem;

import PatientManagmentSystem.DataModel.AbstractUser;

public interface IFactory {

	public abstract AbstractUser CreateUser(String userType);

}
