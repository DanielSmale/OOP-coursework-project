package PatientManagmentSystem.Views.DoctorUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PatientManagmentSystem.Controllers.DoctorController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class PrescribeMedicines extends JFrame {

	DoctorController doctorController = new DoctorController();

	private JPanel contentPane;
	private JTextField doctorIDTxt;
	private JTextField patientIDTxt;
	private JTextField medicineNameTxt;
	private JTextField quantityTxt;
	private JTextField dosageTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrescribeMedicines frame = new PrescribeMedicines();
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
	public PrescribeMedicines() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDoctorPrescribeMedicines = new JLabel("Doctor prescribe medicines");
		lblDoctorPrescribeMedicines.setBounds(12, 26, 194, 16);
		contentPane.add(lblDoctorPrescribeMedicines);

		JLabel lblDoctorId = new JLabel("Doctor ID");
		lblDoctorId.setBounds(73, 87, 56, 16);
		contentPane.add(lblDoctorId);

		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setBounds(73, 116, 56, 16);
		contentPane.add(lblPatientId);

		JLabel lblMedicineName = new JLabel("Medicine name");
		lblMedicineName.setBounds(36, 145, 93, 16);
		contentPane.add(lblMedicineName);

		JLabel lblMedicineQuantity = new JLabel("Medicine quantity");
		lblMedicineQuantity.setBounds(36, 174, 109, 16);
		contentPane.add(lblMedicineQuantity);

		JLabel lblMedicineDosage = new JLabel("Medicine dosage");
		lblMedicineDosage.setBounds(36, 203, 99, 16);
		contentPane.add(lblMedicineDosage);

		doctorIDTxt = new JTextField();
		doctorIDTxt.setBounds(145, 84, 238, 22);
		contentPane.add(doctorIDTxt);
		doctorIDTxt.setColumns(10);

		patientIDTxt = new JTextField();
		patientIDTxt.setColumns(10);
		patientIDTxt.setBounds(141, 113, 238, 22);
		contentPane.add(patientIDTxt);

		medicineNameTxt = new JTextField();
		medicineNameTxt.setColumns(10);
		medicineNameTxt.setBounds(141, 142, 238, 22);
		contentPane.add(medicineNameTxt);

		quantityTxt = new JTextField();
		quantityTxt.setColumns(10);
		quantityTxt.setBounds(141, 171, 238, 22);
		contentPane.add(quantityTxt);

		dosageTxt = new JTextField();
		dosageTxt.setColumns(10);
		dosageTxt.setBounds(141, 203, 238, 22);
		contentPane.add(dosageTxt);

		JTextArea notesTextArea = new JTextArea();
		notesTextArea.setBounds(127, 238, 371, 125);
		contentPane.add(notesTextArea);

		JLabel lblNotes = new JLabel("notes");
		lblNotes.setBounds(73, 253, 56, 16);
		contentPane.add(lblNotes);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int quantity = 0;
				double dosage = 0;
				if (quantityTxt.getText() != null) {
					quantity = Integer.parseInt(quantityTxt.getText());
				}
				if (dosageTxt.getText() != null) {
					dosage= Double.parseDouble(dosageTxt.getText());
				}

				if (doctorIDTxt.getText() != null && patientIDTxt.getText() != null && notesTextArea.getText() != null
						&& medicineNameTxt.getText() != null) {
					doctorController.CreateNewPrescription(doctorIDTxt.getText(), patientIDTxt.getText(),
							notesTextArea.getText(), medicineNameTxt.getText(), quantity, dosage);
				}

				// now clear the text boxes ready for next time
				doctorIDTxt.setText("");
				patientIDTxt.setText("");
				medicineNameTxt.setText("");
				quantityTxt.setText("");
				dosageTxt.setText("");
				notesTextArea.setText("");
			}

		});
		btnSubmit.setBounds(145, 376, 97, 25);
		contentPane.add(btnSubmit);

	}
}
