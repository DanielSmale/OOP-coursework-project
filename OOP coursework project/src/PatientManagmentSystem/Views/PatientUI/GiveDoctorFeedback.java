package PatientManagmentSystem.Views.PatientUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PatientManagmentSystem.Controllers.PatientController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GiveDoctorFeedback extends JFrame {
	private PatientController patientController = new PatientController();

	private JPanel contentPane;
	private JTextField doctorIDTextField;
	private JTextField ratingTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiveDoctorFeedback frame = new GiveDoctorFeedback();
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
	public GiveDoctorFeedback() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblGiveFeedback = new JLabel("Give feedback");
		lblGiveFeedback.setBounds(23, 23, 102, 16);
		contentPane.add(lblGiveFeedback);

		JLabel lblDoctorsId = new JLabel("Doctor's ID");
		lblDoctorsId.setBounds(38, 71, 87, 16);
		contentPane.add(lblDoctorsId);

		doctorIDTextField = new JTextField();
		doctorIDTextField.setBounds(106, 68, 366, 22);
		contentPane.add(doctorIDTextField);
		doctorIDTextField.setColumns(10);

		JLabel lblYourFeedback = new JLabel("Your feedback");
		lblYourFeedback.setBounds(23, 115, 87, 16);
		contentPane.add(lblYourFeedback);

		JTextArea feedbackTextArea = new JTextArea();
		feedbackTextArea.setBounds(116, 100, 428, 205);
		contentPane.add(feedbackTextArea);

		JLabel lblRating = new JLabel("Rating");
		lblRating.setBounds(50, 314, 56, 16);
		contentPane.add(lblRating);

		ratingTextField = new JTextField();
		ratingTextField.setBounds(126, 318, 116, 22);
		contentPane.add(ratingTextField);
		ratingTextField.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (doctorIDTextField.getText() != null && ratingTextField.getText() != null
						&& feedbackTextArea.getText() != null) {
					SendDoctorFeedback(doctorIDTextField.getText(), Integer.parseInt(ratingTextField.getText()),
							feedbackTextArea.getText()); // send the values off the text box to the secretary
				}

				doctorIDTextField.setText(""); // and empty the text boxes after
				ratingTextField.setText("");
				feedbackTextArea.setText("");
			}
		});
		btnSubmit.setBounds(267, 318, 97, 25);
		contentPane.add(btnSubmit);
	}

	public void SendDoctorFeedback(String doctorID, int rating, String feedback) {

		patientController.SendDoctorFeedback(doctorID, rating, feedback);
	}
}
