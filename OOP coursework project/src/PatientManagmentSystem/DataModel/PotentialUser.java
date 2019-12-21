package PatientManagmentSystem.DataModel;

public class PotentialUser {

	public String givenName;
	public String surname;
	public String uniqueID;
	public String password;
	public String userType;

	public PotentialUser(String givenName, String surname, String uniqueID, String password, String userType) {
		this.givenName = givenName;
		this.surname = surname;
		this.uniqueID = uniqueID;
		this.password = password;
		this.userType = userType;
	}

}
