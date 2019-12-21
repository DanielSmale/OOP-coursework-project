package PatientManagmentSystem.DataModel.AdministratorSystem;

import PatientManagmentSystem.DataModel.AbstractUser;

public class Administrator extends AbstractUser {

	private UserFactory userFactory;

	public Administrator(String givenName, String surname, String uniqueID, String password) {
		super(givenName, surname, uniqueID, password);

	}

	public Administrator(String givenName, String surname, String uniqueID, String password, UserFactory userfactory) {
		super(givenName, surname, uniqueID, password);
		this.userFactory = userfactory;

	}

	public void setUserFactory(UserFactory userFactory) {
		this.userFactory = userFactory;
	}

	public AbstractUser CreateUser(String userType) {

		AbstractUser user = userFactory.CreateUser(userType);

		return user;
	}

}
