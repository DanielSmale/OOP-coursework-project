package PatientManagmentSystem.Views.PatientUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PatientManagmentSystem.Controllers.PatientController;
import PatientManagmentSystem.DataModel.Appointment;
import PatientManagmentSystem.DataModel.Prescription;
import PatientManagmentSystem.DataModel.PatientSystem.Patient;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPrescriptions extends JFrame {
	private PatientController patientController = new PatientController();

	private JPanel contentPane;
	private JTextField patientIDtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrescriptions frame = new ViewPrescriptions();
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
	public ViewPrescriptions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblYourId = new JLabel("Your ID");
		lblYourId.setBounds(31, 64, 71, 16);
		contentPane.add(lblYourId);

		patientIDtextField = new JTextField();
		patientIDtextField.setColumns(10);
		patientIDtextField.setBounds(93, 61, 172, 22);
		contentPane.add(patientIDtextField);

		JList prescriptionList = new JList();
		prescriptionList.setBounds(31, 98, 456, 323);
		contentPane.add(prescriptionList);

		JLabel lblViewPrescription = new JLabel("View prescription");
		lblViewPrescription.setBounds(31, 13, 119, 16);
		contentPane.add(lblViewPrescription);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DefaultListModel<String> model = SetListsData();
				prescriptionList.setModel(model);

			}
		});
		btnSearch.setBounds(295, 60, 97, 25);
		contentPane.add(btnSearch);

	}

	private DefaultListModel<String> SetListsData() {

		DefaultListModel<String> appointmentsDataListModel = new DefaultListModel<String>();

		Prescription[] prescriptionList = patientController.ReturnPrescriptionDetails();

		for (int i = 0; i < prescriptionList.length; i++) {

			String appointmentInFo = prescriptionList[i].getDoctorID() + " " + prescriptionList[i].getPatientID() + " "
					+ prescriptionList[i].getDoctorNote() + " " + prescriptionList[i].getMedicine() + " "
					+ prescriptionList[i].getQuantity() + " " + prescriptionList[i].getDosage();

			appointmentsDataListModel.addElement(appointmentInFo);
		}
		return appointmentsDataListModel;
	}
}
