package PatientManagmentSystem.Controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class SecretaryController {

	public Object[] ReturnDoctorDetails() {

		String outInfo = "";
		try (BufferedReader reader = new BufferedReader(new FileReader("/Doctors.json"))) {
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
