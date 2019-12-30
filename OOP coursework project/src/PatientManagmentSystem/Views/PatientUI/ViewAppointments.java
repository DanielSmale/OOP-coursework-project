package PatientManagmentSystem.Views.PatientUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PatientManagmentSystem.Controllers.PatientController;
import PatientManagmentSystem.DataModel.Appointment;

import javax.swing.JLabel;
import javax.swing.JList;

public class ViewAppointments extends JFrame {
	PatientController patientController = new PatientController();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAppointments frame = new ViewAppointments();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewAppointments() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPatientsViewAppointment = new JLabel("Patients view appointment");
		lblPatientsViewAppointment.setBounds(28, 26, 155, 16);
		contentPane.add(lblPatientsViewAppointment);

		JList appointmentsList = new JList();
		appointmentsList.setBounds(49, 90, 495, 314);
		contentPane.add(appointmentsList);

		DefaultListModel<String> model = SetListsData();
		appointmentsList.setModel(model);
	}

	private DefaultListModel<String> SetListsData() {

		DefaultListModel<String> appointmentsDataListModel = new DefaultListModel<String>();

		Appointment[] appointmentsList = patientController.ReturnAppointmentsDetails();

		for (int i = 0; i < appointmentsList.length; i++) {

			String appointmentInFo = appointmentsList[i].getDoctorID() + " " + appointmentsList[i].getPatientID() + " "
					+ appointmentsList[i].getDate();

			appointmentsDataListModel.addElement(appointmentInFo);
		}
		return appointmentsDataListModel;
	}
}
