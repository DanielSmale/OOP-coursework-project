package PatientManagmentSystem.Views.AdminUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PatientManagmentSystem.Controllers.AdministratorController;
import PatientManagmentSystem.DataModel.Appointment;
import PatientManagmentSystem.DataModel.DoctorFeedback;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class EditPatientFeedback extends JFrame {


	private JPanel contentPane;
	private JTextField doctorIDTextField;
	private JTextField ratingText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditPatientFeedback frame = new EditPatientFeedback();
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
	public EditPatientFeedback() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEditFeedback = new JLabel("Edit feedback");
		lblEditFeedback.setBounds(31, 32, 84, 16);
		contentPane.add(lblEditFeedback);

		JList feedBackList = new JList();
		feedBackList.setBounds(41, 80, 530, 79);
		contentPane.add(feedBackList);

		DefaultListModel<String> model = SetListsData();
		feedBackList.setModel(model);

		JLabel lblPatientFeedback = new JLabel("Patient feedback");
		lblPatientFeedback.setBounds(41, 61, 129, 16);
		contentPane.add(lblPatientFeedback);

		JLabel lblFeedbackToSend = new JLabel("Feedback to send to doctor");
		lblFeedbackToSend.setBounds(34, 172, 165, 16);
		contentPane.add(lblFeedbackToSend);

		JTextArea edittedFeedbackTextArea = new JTextArea();
		edittedFeedbackTextArea.setBounds(44, 244, 527, 130);
		contentPane.add(edittedFeedbackTextArea);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DoctorFeedback edittedDoctorFeedback = new DoctorFeedback(doctorIDTextField.getText(),
						Integer.parseInt(ratingText.getText()), edittedFeedbackTextArea.getText());
				AdministratorController.getInstance().StoreEdittedFeedback(edittedDoctorFeedback);

				edittedFeedbackTextArea.setText(""); // reset the text after sending the data

			}
		});
		btnSubmit.setBounds(41, 412, 97, 25);
		contentPane.add(btnSubmit);

		JLabel lblDoctorsid = new JLabel("DoctorsID");
		lblDoctorsid.setBounds(59, 219, 56, 16);
		contentPane.add(lblDoctorsid);

		doctorIDTextField = new JTextField();
		doctorIDTextField.setBounds(127, 216, 116, 22);
		contentPane.add(doctorIDTextField);
		doctorIDTextField.setColumns(10);

		JLabel lblUsersRating = new JLabel("Users rating");
		lblUsersRating.setBounds(255, 219, 76, 16);
		contentPane.add(lblUsersRating);

		ratingText = new JTextField();
		ratingText.setBounds(343, 216, 116, 22);
		contentPane.add(ratingText);
		ratingText.setColumns(10);
	}

	private DefaultListModel<String> SetListsData() {

		DefaultListModel<String> feedbackDataListModel = new DefaultListModel<String>();

		DoctorFeedback[] feedbackArray = AdministratorController.getInstance().ReturnFeedbackDetails();

		for (int i = 0; i < feedbackArray.length; i++) {

			String feedbackString = "i: " + feedbackArray[i].getDoctorID() + " " + feedbackArray[i].getRating() + " "
					+ feedbackArray[i].getFeedbackNotes();

			feedbackDataListModel.addElement(feedbackString);
		}

		return feedbackDataListModel;
	}
}
