package PatientManagmentSystem.DataModel;

public abstract class AbstractUser {

	private String givenName;
	private String surname;
	private String uniqueID;
	private String password;

	public AbstractUser(String givenName, String surname, String uniqueID, String password) {

		this.givenName = givenName;
		this.surname = surname;
		this.uniqueID = uniqueID;
		this.password = password;
	}

	public AbstractUser(PotentialUser potentialUserDetails) {
		this.givenName = potentialUserDetails.givenName;
		this.surname = potentialUserDetails.surname;
		this.uniqueID = potentialUserDetails.uniqueID;
		this.password = potentialUserDetails.password;

	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
