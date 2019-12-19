package PatientManagmentSystem.Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class SecretaryController {
File doctorsFile = new File("C:\\Users\\Student\\Documents\\GitHub\\OOP-coursework-project\\OOP coursework project\\bin\\doctors.json");
	public Object[] ReturnDoctorDetails() {

		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader(doctorsFile))) {
			{
				outInfo = reader.readLine();
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONObject allDoctorInfo = new JSONObject(outInfo);

		Object[] allDoctors = (Object[]) allDoctorInfo.get("Doctors");
		System.out.println(allDoctors);

		return allDoctors;

	}

}
