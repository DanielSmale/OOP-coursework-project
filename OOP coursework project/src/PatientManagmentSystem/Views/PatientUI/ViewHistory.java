package PatientManagmentSystem.Views.PatientUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PatientManagmentSystem.Controllers.PatientController;
import PatientManagmentSystem.DataModel.Appointment;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class ViewHistory extends JFrame {
	private PatientController patientController = new PatientController();

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewHistory frame = new ViewHistory();
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
	public ViewHistory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPatientHistory = new JLabel("Patient view history");
		lblPatientHistory.setBounds(12, 13, 124, 16);
		contentPane.add(lblPatientHistory);

		JLabel lblYourId = new JLabel("Your ID");
		lblYourId.setBounds(34, 68, 71, 16);
		contentPane.add(lblYourId);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(96, 65, 172, 22);
		contentPane.add(textField);

		JList historyList = new JList();
		historyList.setBounds(34, 125, 456, 323);
		contentPane.add(historyList);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(298, 64, 97, 25);
		contentPane.add(btnSearch);
	}

	private DefaultListModel PopulateHistoryList(String patientID) {
		DefaultListModel<String> appointmentsDataListModel = new DefaultListModel<String>();

		Appointment[] appointmentsList = patientController.GetPatientHistory(patientID);

		for (int i = 0; i < appointmentsList.length; i++) {

			String appointmentInFo = appointmentsList[i].getDoctorID() + " " + appointmentsList[i].getPatientID() + " "
					+ appointmentsList[i].getDate();

			appointmentsDataListModel.addElement(appointmentInFo);
		}
		return appointmentsDataListModel;

	}
}
