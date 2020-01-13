package PatientManagmentSystem.DataModel;

public class Medicine {

	private String medicineName;
	private int stock;

	public Medicine(String medicineName, int stock) {
this.medicineName = medicineName;
this.stock = stock;
		
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
