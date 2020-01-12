package PatientManagmentSystem.Views.DoctorUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import PatientManagmentSystem.Controllers.DoctorController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddNotes {
	DoctorController doctorController = new DoctorController();

	private JFrame frame;
	private JTextField doctorIDTxt;
	private JTextField patientIDTxt;
	private JTextField dateTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNotes window = new AddNotes();
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
	public AddNotes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 554, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea notesTextArea = new JTextArea();
		notesTextArea.setBounds(45, 190, 396, 246);
		frame.getContentPane().add(notesTextArea);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (notesTextArea.getText() != null && dateTxt.getText() != null && patientIDTxt.getText() != null
						&& doctorIDTxt.getText() != null) {
					doctorController.SendNotes(notesTextArea.getText(), dateTxt.getText(), patientIDTxt.getText(),
							doctorIDTxt.getText());
				}

				notesTextArea.setText("");
				dateTxt.setText("");
				patientIDTxt.setText("");
				doctorIDTxt.setText("");
			}
		});
		btnSave.setBounds(55, 461, 97, 25);
		frame.getContentPane().add(btnSave);

		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setBounds(12, 13, 56, 16);
		frame.getContentPane().add(lblNotes);

		JLabel lblDoctorId = new JLabel("Doctor ID");
		lblDoctorId.setBounds(34, 80, 56, 16);
		frame.getContentPane().add(lblDoctorId);

		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setBounds(34, 109, 56, 16);
		frame.getContentPane().add(lblPatientId);

		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(34, 138, 56, 16);
		frame.getContentPane().add(lblDate);

		doctorIDTxt = new JTextField();
		doctorIDTxt.setBounds(97, 77, 187, 22);
		frame.getContentPane().add(doctorIDTxt);
		doctorIDTxt.setColumns(10);

		patientIDTxt = new JTextField();
		patientIDTxt.setBounds(97, 109, 187, 22);
		frame.getContentPane().add(patientIDTxt);
		patientIDTxt.setColumns(10);

		dateTxt = new JTextField();
		dateTxt.setBounds(97, 138, 197, 22);
		frame.getContentPane().add(dateTxt);
		dateTxt.setColumns(10);
	}
}
