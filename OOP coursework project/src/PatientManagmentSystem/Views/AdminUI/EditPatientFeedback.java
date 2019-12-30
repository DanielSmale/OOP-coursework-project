package PatientManagmentSystem.Views.AdminUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditPatientFeedback extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 615, 431);
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
		
		JLabel lblPatientFeedback = new JLabel("Patient feedback");
		lblPatientFeedback.setBounds(41, 61, 129, 16);
		contentPane.add(lblPatientFeedback);
		
		JLabel lblFeedbackToSend = new JLabel("Feedback to send to doctor");
		lblFeedbackToSend.setBounds(34, 172, 165, 16);
		contentPane.add(lblFeedbackToSend);
		
		JTextArea edittedFeedbackTextArea = new JTextArea();
		edittedFeedbackTextArea.setBounds(41, 201, 527, 130);
		contentPane.add(edittedFeedbackTextArea);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnSubmit.setBounds(41, 344, 97, 25);
		contentPane.add(btnSubmit);
	}
}
