package PatientManagmentSystem.DataModel.PatientSystem;

import PatientManagmentSystem.DataModel.AbstractUser;
import PatientManagmentSystem.DataModel.PotentialUser;

public class Patient extends AbstractUser {

	private int age;
	private String gender;
	private String address;

	public Patient(String givenName, String surname, String uniqueID, String password) {
		super(givenName, surname, uniqueID, password);

	}

	public Patient(String givenName, String surname, String uniqueID, String password, int age, String gender,
			String address) {
		super(givenName, surname, uniqueID, password);
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
}
