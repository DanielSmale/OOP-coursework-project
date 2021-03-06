package PatientManagmentSystem.Views.AdminUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PatientManagmentSystem.Controllers.AdministratorController;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.util.Random;

public class CreateUsersPage extends JFrame {

	private JPanel contentPane;
	private JTextField givenNameTxt;
	private JTextField surnameTxt;
	private JTextField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUsersPage frame = new CreateUsersPage();
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
	public CreateUsersPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Provide your details for the admin to set up your account");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setBounds(56, 24, 383, 32);
		contentPane.add(lblTitle);

		JLabel lblGivenName = new JLabel("Given name");
		lblGivenName.setBounds(29, 69, 86, 16);
		contentPane.add(lblGivenName);

		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(29, 98, 56, 16);
		contentPane.add(lblSurname);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(29, 127, 86, 16);
		contentPane.add(lblPassword);

		givenNameTxt = new JTextField();
		givenNameTxt.setColumns(10);
		givenNameTxt.setBounds(110, 66, 303, 22);
		contentPane.add(givenNameTxt);

		surnameTxt = new JTextField();
		surnameTxt.setColumns(10);
		surnameTxt.setBounds(110, 98, 303, 22);
		contentPane.add(surnameTxt);

		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(110, 127, 303, 22);
		contentPane.add(passwordTxt);

		JLabel lblUserType = new JLabel("User type");
		lblUserType.setBounds(59, 171, 56, 16);
		contentPane.add(lblUserType);

		JRadioButton rdbtnDoctor = new JRadioButton("Doctor");
		rdbtnDoctor.setBounds(119, 167, 71, 25);
		contentPane.add(rdbtnDoctor);

		JRadioButton rdbtnSecretary = new JRadioButton("Secretary");
		rdbtnSecretary.setBounds(194, 167, 86, 25);
		contentPane.add(rdbtnSecretary);

		JRadioButton rdbtnPatient = new JRadioButton("Patient");
		rdbtnPatient.setBounds(286, 167, 127, 25);
		contentPane.add(rdbtnPatient);

		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Random uniqueIDNumberGenerator = new Random();
				String givenName = "";
				String surname = "";
				String uniqueIDValue = "";
				String password = "";
				String userType = null;
				// take the values of the text box
				if (givenNameTxt.getText() != null || givenNameTxt.getText() != "") {// check the values aren't null
					givenName = givenNameTxt.getText();
				}

				if (surnameTxt.getText() != null || surnameTxt.getText() != "") {
					surname = surnameTxt.getText();
				}

				if (passwordTxt.getText() != null || passwordTxt.getText() != "") {
					password = passwordTxt.getText();
				}

				if (rdbtnDoctor.isSelected()) {
					userType = "Doctor";
					uniqueIDValue = "D" + uniqueIDNumberGenerator.nextInt(1000);
				}
				if (rdbtnSecretary.isSelected()) {
					userType = "Secretary";
					uniqueIDValue = "S" + uniqueIDNumberGenerator.nextInt(1000);

				}
				if (rdbtnPatient.isSelected()) {
					userType = "Patient";
					uniqueIDValue = "P" + uniqueIDNumberGenerator.nextInt(1000);

				}

				AdministratorController.getInstance().ReceivePotentialUserDetails(givenName, surname, uniqueIDValue,
						password, userType); // and send them to the admin controller to be created

				givenNameTxt.setText("");
				surnameTxt.setText("");
				passwordTxt.setText("");
				rdbtnDoctor.setSelected(false);
				rdbtnSecretary.setSelected(false);
				rdbtnPatient.setSelected(false);

			}
		});
		btnEnter.setBounds(123, 226, 97, 25);
		contentPane.add(btnEnter);
	}
}
