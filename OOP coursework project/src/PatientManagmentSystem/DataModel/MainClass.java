package PatientManagmentSystem.DataModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;

public class MainClass {
	//This class is the entry point to the program all key code will be called from here. Gives the admin his initial GUI
	public static JSONArray readAppointments;

	public static void main(String[] args) {

		getStoredAppointments();
	}

	public static void getStoredAppointments() {
		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader("appointmentsFile.json"))) {
			{
				outInfo = reader.readLine();

				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		readAppointments = new JSONArray(outInfo);

	}

}
