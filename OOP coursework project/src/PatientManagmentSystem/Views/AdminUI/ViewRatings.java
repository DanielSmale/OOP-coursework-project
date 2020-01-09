package PatientManagmentSystem.Views.AdminUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PatientManagmentSystem.Controllers.AdministratorController;
import PatientManagmentSystem.DataModel.DoctorFeedback;

import javax.swing.JLabel;
import javax.swing.JList;

public class ViewRatings extends JFrame {


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRatings frame = new ViewRatings();
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
	public ViewRatings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 954, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblViewRatings = new JLabel("View ratings");
		lblViewRatings.setBounds(12, 13, 84, 16);
		contentPane.add(lblViewRatings);

		JList doctorRatingsList = new JList();
		doctorRatingsList.setBounds(31, 65, 525, 284);
		contentPane.add(doctorRatingsList);
		
		
		DefaultListModel<String> model = SetListsData();
		doctorRatingsList.setModel(model);
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
