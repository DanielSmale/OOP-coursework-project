package PatientManagmentSystem.Views.DoctorUI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import PatientManagmentSystem.Controllers.DoctorController;
import PatientManagmentSystem.DataModel.Appointment;

public class ViewAppointment {
	DoctorController doctorController = new DoctorController();

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAppointment window = new ViewAppointment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public ViewAppointment() {
		initialize();
	}

	private DefaultListModel<String> SetListsData() {

		DefaultListModel<String> appointmentsDataListModel = new DefaultListModel<String>();

		Appointment[] appointmentsList = doctorController.ReturnAppointmentsDetails();

		for (int i = 0; i < appointmentsList.length-1; i++) {

			String appointmentInFo = appointmentsList[i].getDoctorID() + " " + appointmentsList[i].getPatientID() + " "
					+ appointmentsList[i].getDate();

			appointmentsDataListModel.addElement(appointmentInFo);
		}
		return appointmentsDataListModel;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1268, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblDoctorsViewAppointments = new JLabel("Doctors View Appointments");
		lblDoctorsViewAppointments.setBounds(41, 36, 169, 16);
		frame.getContentPane().add(lblDoctorsViewAppointments);

		JList AppointmentsList = new JList();
		AppointmentsList.setBounds(65, 103, 1140, 214);
		frame.getContentPane().add(AppointmentsList);

		DefaultListModel<String> model = SetListsData();
		AppointmentsList.setModel(model);

	}

}
