package PatientManagmentSystem.Views.DoctorUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PatientManagmentSystem.Controllers.DoctorController;
import PatientManagmentSystem.DataModel.Appointment;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPatientHistory extends JFrame {
	DoctorController doctorController = new DoctorController();

	private JPanel contentPane;
	private JTextField patientIDTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPatientHistory frame = new ViewPatientHistory();
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
	public ViewPatientHistory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDoctorViewPatient = new JLabel("Doctor view patient history");
		lblDoctorViewPatient.setBounds(27, 13, 172, 16);
		contentPane.add(lblDoctorViewPatient);

		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setBounds(49, 68, 71, 16);
		contentPane.add(lblPatientId);

		patientIDTxt = new JTextField();
		patientIDTxt.setBounds(111, 65, 172, 22);
		contentPane.add(patientIDTxt);
		patientIDTxt.setColumns(10);

		JList historyList = new JList();
		historyList.setBounds(49, 125, 515, 323);
		contentPane.add(historyList);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				historyList.removeAll(); // remove anything left over in the list
				historyList.setModel(PopulateHistoryList(patientIDTxt.getText()));

			}
		});
		btnSearch.setBounds(313, 64, 97, 25);
		contentPane.add(btnSearch);
	}

	private DefaultListModel<String> PopulateHistoryList(String patientID) {
		DefaultListModel<String> appointmentsDataListModel = new DefaultListModel<String>();

		Appointment[] appointmentsList = doctorController.GetPatientHistory(patientID);

		for (int i = 0; i < appointmentsList.length - 1; i++) {

			String appointmentInFo = appointmentsList[i].getDoctorID() + " " + appointmentsList[i].getPatientID() + " "
					+ appointmentsList[i].getDate();

			appointmentsDataListModel.addElement(appointmentInFo);
		}
		return appointmentsDataListModel;

	}
}
